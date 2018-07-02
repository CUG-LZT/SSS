package com.pro.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pro.entity.Dataofmonitor;
import com.pro.utils.DataSave;
import com.pro.utils.IsStandChange;
import com.pro.utils.LampofSave;

/**
 * 此线程用于从9003端口获取并解析数据，最后存入数据库中
 * 
 * @author lzt
 * 
 */
public class GetDataServer extends Thread {
	Socket scoket = null;

	public GetDataServer(Socket scoket) {
		super();
		this.scoket = scoket;
	}

	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader bfr = null;
		OutputStream ot = null;
		BufferedWriter bfw = null;
		String leftoflast = "";
		int sumi = 0;
		try {
			System.out.println("开始解析收到的数据... ");
			is = scoket.getInputStream();
			isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);
			ot = scoket.getOutputStream();
			bfw = new BufferedWriter(new OutputStreamWriter(ot));
			String data;
			char charsoflab[] = new char[10];// 存储无影灯
			while ((data = bfr.readLine()) != null) {
				// 去获取数据的空格
				data = data.trim();
				data = leftoflast + data;
				leftoflast = "";
				if (!data.endsWith("&&")) {
					if (data.lastIndexOf("##") > 2) {// 不是&&结尾 ，但是最后一个##不在开头
														// 截取最后一个##开始到结束
						leftoflast = data.substring(data.lastIndexOf("##"),
								data.length());
						data = data.substring(0, data.lastIndexOf("##") - 2);
					} else { // 不是&&结尾 并且没有或者只有一个## 全部移到下一组
						leftoflast = data;
						data = "";
					}
				}
				System.out
						.println("**********************接收数据************************");
				System.out.println("**数据为:" + data);
				// 获取当前时间
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				String time = format.format(date);

				// 解析数据并将多条数据整理
				ArrayList<String> list = new ArrayList<String>();
				// 利用正则表达式使分离多条数据，存在list中
				Pattern pattern = Pattern.compile("(?<=##)(.+?)(?=&&)");
				Matcher matcher = pattern.matcher(data);
				while (matcher.find()) {
					list.add(matcher.group());
				}
				/*
				 * datas[0]:##id=212; datas[1]:dt=20180615143300;
				 * datas[2]:p1-28=
				 * 0.0*0.0*0.0*0.0*0.0*0.0*0.0*0.0*0.0*0.0*0.0*0.0
				 * *0.0*0.0*0.0*0.0
				 * *0.0*0.0*-25.0*-25.0*-25.0*-25.0*-25.0*-25.0*0.0*0.0*0.0*0.0;
				 * datas
				 * [3]:t11-20=21.0*22.0*23.0*24.0*25.0*26.0*27.0*28.0*29.0*30.0;
				 * datas
				 * [4]:rh11-20=41.0*42.0*43.0*44.0*45.0*46.0*47.0*48.0*49.0*
				 * 50.0; datas[5]:d11-20=0000000000; &&
				 */
				if (data.contains("setup")) {
					System.out.println("******发送数据标准******");
					if (data.equals("##ID=212;SETUP&&")) {
						IsStandChange.isstandchange = true;
					}
				} else if (data.contains("ok")) {
					// 收到数据标准回执
					//IsStandChange.isstandchange = false;
					System.out.println("******数据标准成功接收******");
				} else if (data.contains("lock") || data.contains("unlk") ) {
					// 收到灯控制回执
					System.out.println("******无影灯锁定（解锁）成功******");
				} else {
					// 如果标准发生变化，则发送标准

					data = "";// 清空缓存区
					System.out.println("**清空数据缓存data,转存入链表:" + data + "**");
					// 服务器发应答指令##ok;datetime&& 并将数据整理入库
					//需要马上发指令的时候不回OK，并且该条数据不接收
					if(IsStandChange.isstandchange != true && LampofSave.islock != 1 && LampofSave.isunlk != 1){
						bfw.write("##ok;" + time + "&&");// 收到反馈
						System.out.println("**发送反馈：##ok;" + time + "&&**");
						System.out.println("**开始解析数据**");
					}
					// 创建数据对象
					Dataofmonitor dom = new Dataofmonitor();
					for (int i = 0; i < list.size(); i++) {
						String[] datas = list.get(i).split(";");
						// 多数据或者少数据都认为是错误的数据 ；*需要转义
						if (IsStandChange.isstandchange != true && LampofSave.islock != 1 && LampofSave.isunlk != 1 && datas.length > 5
								&& datas[2].split("\\*").length == 28
								&& datas[3].split("\\*").length == 10
								&& datas[4].split("\\*").length == 10) {
							System.out.println("**数据中监测点个数："
									+ datas[2].split("\\*").length + "  "
									+ datas[3].split("\\*").length + "   "
									+ datas[4].split("\\*").length);
							// 将时间设置格式
							String dt = datas[1].split("=")[1];
							if (dt.length() != 14) {// 时间数据不对跳出本次循环
								System.out.println("**第" + (i + 1) + "条数据丢弃**");
								continue;
							}
							dt = dt.substring(0, 4) + "-" + dt.substring(4, 6)
									+ "-" + dt.substring(6, 8) + " "
									+ dt.substring(8, 10) + ":"
									+ dt.substring(10, 12) + ":"
									+ dt.substring(12, 14);
							// 时间存入对象
							dom.setDtime(Timestamp.valueOf(dt));
							// 压差存入对象
							dom.setDp1(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[0]));
							dom.setDp2(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[1]));
							dom.setDp3(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[2]));
							dom.setDp4(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[3]));
							dom.setDp5(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[4]));
							dom.setDp6(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[5]));
							dom.setDp7(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[6]));
							dom.setDp8(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[7]));
							dom.setDp9(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[8]));
							dom.setDp10(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[9]));
							dom.setDp11(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[10]));
							dom.setDp12(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[11]));
							dom.setDp13(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[12]));
							dom.setDp14(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[13]));
							dom.setDp15(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[14]));
							dom.setDp16(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[15]));
							dom.setDp17(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[16]));
							dom.setDp18(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[17]));
							dom.setDp19(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[18]));
							dom.setDp20(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[19]));
							dom.setDp21(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[20]));
							dom.setDp22(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[21]));
							dom.setDp23(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[22]));
							dom.setDp24(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[23]));
							dom.setDp25(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[24]));
							dom.setDp26(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[25]));
							dom.setDp27(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[26]));
							dom.setDp28(Double.parseDouble((datas[2].split("=")[1])
									.split("\\*")[27]));
							// 温度存入对象
							dom.setDt1(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[0]));
							dom.setDt2(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[1]));
							dom.setDt3(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[2]));
							dom.setDt4(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[3]));
							dom.setDt5(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[4]));
							dom.setDt6(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[5]));
							dom.setDt7(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[6]));
							dom.setDt8(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[7]));
							dom.setDt9(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[8]));
							dom.setDt10(Double.parseDouble((datas[3].split("=")[1])
									.split("\\*")[9]));
							// 温度存入对象
							dom.setDrh1(Double.parseDouble((datas[4].split("=")[1])
									.split("\\*")[0]));
							dom.setDrh2(Double.parseDouble((datas[4].split("=")[1])
									.split("\\*")[1]));
							dom.setDrh3(Double.parseDouble((datas[4].split("=")[1])
									.split("\\*")[2]));
							dom.setDrh4(Double.parseDouble((datas[4].split("=")[1])
									.split("\\*")[3]));
							dom.setDrh5(Double.parseDouble((datas[4].split("=")[1])
									.split("\\*")[4]));
							dom.setDrh6(Double.parseDouble((datas[4].split("=")[1])
									.split("\\*")[5]));
							dom.setDrh7(Double.parseDouble((datas[4].split("=")[1])
									.split("\\*")[6]));
							dom.setDrh8(Double.parseDouble((datas[4].split("=")[1])
									.split("\\*")[7]));
							dom.setDrh9(Double.parseDouble((datas[4].split("=")[1])
									.split("\\*")[8]));
							dom.setDrh10(Double.parseDouble((datas[4]
									.split("=")[1]).split("\\*")[9]));
							// 将无影灯的信息存入对象
							charsoflab = (datas[5].split("=")[1]).toCharArray();
							dom.setDlamp1(charsoflab[0] - '0');
							dom.setDlamp2(charsoflab[1] - '0');
							dom.setDlamp3(charsoflab[2] - '0');
							dom.setDlamp4(charsoflab[3] - '0');
							dom.setDlamp5(charsoflab[4] - '0');
							dom.setDlamp6(charsoflab[5] - '0');
							dom.setDlamp7(charsoflab[6] - '0');
							dom.setDlamp8(charsoflab[7] - '0');
							dom.setDlamp9(charsoflab[8] - '0');
							dom.setDlamp10(charsoflab[9] - '0');
							DataSave.savedatafromnet(dom);
							System.out.println("**第" + (i + 1) + "条数据保留**");
						} else
							// if
							System.out.println("**第" + (i + 1) + "条数据丢弃**");
					}// for
					//----------------------------------------------
					if (IsStandChange.isstandchange) {
						String stand = IsStandChange.getStandInfo();
						bfw.write(stand);
						System.out.println("******发送数据标准：" + stand + "******");
						IsStandChange.isstandchange = false;
					}

					if (LampofSave.islock == 1) {
						List<Integer> dataofloc = LampofSave.getdataoflock();
						String str = "##lock=212;";
						for (Integer integer : dataofloc) {
							str = str + "d" + integer.toString() + ";";
						}
						str += "&&";
						System.out.println("******发送锁定指令：" + str);
						bfw.write(str);
						LampofSave.islock = 0;
					}
					if (LampofSave.isunlk == 1) {
						List<Integer> dataofloc = LampofSave.getdataofunlk();
						String str = "##unlk=212;";
						for (Integer integer : dataofloc) {
							str = str + "d" + integer.toString() + ";";
						}
						str += "&&";
						System.out.println("******发送解锁指令：" + str);
						bfw.write(str);
						LampofSave.isunlk = 0;
					}
					
					
				}

				bfw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bfw != null)
					bfw.close();
				if (ot != null)
					ot.close();
				if (bfr != null)
					bfr.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
				if (scoket != null)
					scoket.close();
				System.out.print("线程结束\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
