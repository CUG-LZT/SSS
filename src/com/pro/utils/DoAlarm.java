package com.pro.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pro.entity.Dataofmonitor;
import com.pro.entity.Standofdata;

/**
 * 用于监测数据是否异常：
 * 		在规定时间内数据全都不合格则认为数据异常
 * @author lzt
 *
 */
public class DoAlarm extends TimerTask {

	private static boolean isRunning = false;
	private ServletContext context = null;

	public DoAlarm() {
	}

	public DoAlarm(ServletContext context) {
		this.context = context;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (!isRunning) {
			isRunning = true;
			context.log("开始执行指定任务");
			// TODO 添加自定义的详细任务
			Session ss = null;
			try {
				context.log("报警信息开始收集");
				//用于计数；若和数据长度相等，则判断这段时间数据异常，报警
				int[] sumofpress = new int[28];
				int[] sumoftemp = new int[10];
				int[] sumofrh = new int[10];
				ss = HibernateSessionFactory.getSession();
				//获取检验标准
				Query query = ss.createQuery("from Standofdata");
				Standofdata sod = (Standofdata) query.uniqueResult();
				
				//获取报警时间
				double dpt = sod.getSptime();
				double dtt = sod.getSttime();
				double drht = sod.getSrhtime();
				//获取气压标准
				double dp1 = Double.valueOf(sod.getSstandofp1().split(",")[1]);
				double dp2 = Double.valueOf(sod.getSstandofp2().split(",")[1]);
				double dp3 = Double.valueOf(sod.getSstandofp3().split(",")[1]);
				double dp4 = Double.valueOf(sod.getSstandofp4().split(",")[1]);
				double dp5 = Double.valueOf(sod.getSstandofp5().split(",")[1]);
				double dp6 = Double.valueOf(sod.getSstandofp6().split(",")[1]);
				double dp7 = Double.valueOf(sod.getSstandofp7().split(",")[1]);
				double dp8 = Double.valueOf(sod.getSstandofp8().split(",")[1]);
				double dp9 = Double.valueOf(sod.getSstandofp9().split(",")[1]);
				double dp10 = Double.valueOf(sod.getSstandofp10().split(",")[1]);
				double dp11 = Double.valueOf(sod.getSstandofp11().split(",")[1]);
				double dp12 = Double.valueOf(sod.getSstandofp12().split(",")[1]);
				double dp13 = Double.valueOf(sod.getSstandofp13().split(",")[1]);
				double dp14 = Double.valueOf(sod.getSstandofp14().split(",")[1]);
				double dp15 = Double.valueOf(sod.getSstandofp15().split(",")[1]);
				double dp16 = Double.valueOf(sod.getSstandofp16().split(",")[1]);
				double dp17 = Double.valueOf(sod.getSstandofp17().split(",")[1]);
				double dp18 = Double.valueOf(sod.getSstandofp18().split(",")[1]);
				double dp19l = Double.valueOf(sod.getSstandofp19().split(",")[0]);
				double dp19h = Double.valueOf(sod.getSstandofp19().split(",")[1]);
				double dp20l = Double.valueOf(sod.getSstandofp20().split(",")[0]);
				double dp20h = Double.valueOf(sod.getSstandofp20().split(",")[1]);
				double dp21l = Double.valueOf(sod.getSstandofp21().split(",")[0]);
				double dp21h = Double.valueOf(sod.getSstandofp21().split(",")[1]);
				double dp22l = Double.valueOf(sod.getSstandofp22().split(",")[0]);
				double dp22h = Double.valueOf(sod.getSstandofp22().split(",")[1]);
				double dp23l = Double.valueOf(sod.getSstandofp23().split(",")[0]);
				double dp23h = Double.valueOf(sod.getSstandofp23().split(",")[1]);
				double dp24l = Double.valueOf(sod.getSstandofp24().split(",")[0]);
				double dp24h = Double.valueOf(sod.getSstandofp24().split(",")[1]);
				double dp25 = Double.valueOf(sod.getSstandofp25().split(",")[1]);
				double dp26 = Double.valueOf(sod.getSstandofp26().split(",")[1]);
				double dp27 = Double.valueOf(sod.getSstandofp27().split(",")[1]);
				double dp28 = Double.valueOf(sod.getSstandofp28().split(",")[1]);
				//获取温度标准
				double dtl = Double.valueOf(sod.getSstandoft().split(",")[0]);
				double dth = Double.valueOf(sod.getSstandoft().split(",")[1]);
				//获取湿度标准
				double drhl = Double.valueOf(sod.getSstandofrh().split(",")[0]);
				double drhh = Double.valueOf(sod.getSstandofrh().split(",")[1]);
				
				//获取当前时间
				java.util.Date javaDate = new java.util.Date();
				//当前时间
				long javaTime = javaDate.getTime();
				//气压报警时间长度
				long starttimeofpress = (long) (javaTime - dpt * 60 * 1000);
				//温度报警时间长度
				long starttimeoftemp = (long) (javaTime - dtt * 60 * 1000);
				//湿度报警时间长度
				long starttimeofrh = (long) (javaTime - drht * 60 * 1000);
				//结束时间也是当前时间
				long endtime = javaTime;
				//建立时间戳
				java.sql.Timestamp stimeofpress = new java.sql.Timestamp(starttimeofpress);
				java.sql.Timestamp stimeoftemp = new java.sql.Timestamp(starttimeoftemp);
				java.sql.Timestamp stimeofrh = new java.sql.Timestamp(starttimeofrh);
				java.sql.Timestamp etime = new java.sql.Timestamp(endtime);
				
				//当前时间转换为时间戳
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowstr = df.format(etime);
				etime = Timestamp.valueOf(nowstr);
				
				
				//获取时间内的气压数据
				String hqlofpress = "from Dataofmonitor where dtime between '" + stimeofpress + "' and '" + etime + "'";
				Query queryofpress = ss.createQuery(hqlofpress);
				List<Dataofmonitor> domofpress = queryofpress.list();
				if (domofpress.size() == 0) {
					if (AlarminfoSave.alarmofpressofid == -1) {
						AlarminfoSave.alarmofpressofid = AlarminfoSave.add(stimeofpress, etime,"全局", "无压差数据上传", "未处理","通讯异常");
						//System.out.println("AlarminfoSave.alarmofpressofid: "+AlarminfoSave.alarmofpressofid);
					} else{
						//如果c1不是0而是一个id那说明，在上一次之后的时间内依然没有数据上传，只需要更新报警的结束时间就可以了
						AlarminfoSave.update(AlarminfoSave.alarmofpressofid, etime);
					}
				}else{
					AlarminfoSave.alarmofpressofid = -1;
				}
				
				//循环统计判P1-P28异常次数
				for (int i = 0; i < domofpress.size(); i++) {
					if (domofpress.get(i).getDp1() > dp1 || 0 > domofpress.get(i).getDp1()) {
						sumofpress[0]++;
					}
					if (domofpress.get(i).getDp2() > dp2 || 0 > domofpress.get(i).getDp2()) {
						sumofpress[1]++;
					}
					if (domofpress.get(i).getDp3() > dp3 || 0 > domofpress.get(i).getDp3()) {
						sumofpress[2]++;
					}
					if (domofpress.get(i).getDp4() > dp4 || 0 > domofpress.get(i).getDp4()) {
						sumofpress[3]++;
					}
					if (domofpress.get(i).getDp5() > dp5 || 0 > domofpress.get(i).getDp5()) {
						sumofpress[4]++;
					}
					if (domofpress.get(i).getDp6() > dp6 || 0 > domofpress.get(i).getDp6()) {
						sumofpress[5]++;
					}
					if (domofpress.get(i).getDp7() > dp7 || 0 > domofpress.get(i).getDp7()) {
						sumofpress[6]++;
					}
					if (domofpress.get(i).getDp8() > dp8 || 0 > domofpress.get(i).getDp8()) {
						sumofpress[7]++;
					}
					if (domofpress.get(i).getDp9() > dp9 || 0 > domofpress.get(i).getDp9()) {
						sumofpress[8]++;
					}
					if (domofpress.get(i).getDp10() > dp10 || 0 > domofpress.get(i).getDp10()) {
						sumofpress[9]++;
					}
					if (domofpress.get(i).getDp11() > dp11 || 0 > domofpress.get(i).getDp11()) {
						sumofpress[10]++;
					}
					if (domofpress.get(i).getDp12() > dp12 || 0 > domofpress.get(i).getDp12()) {
						sumofpress[11]++;
					}
					if (domofpress.get(i).getDp13() > dp13 || 0 > domofpress.get(i).getDp13()) {
						sumofpress[12]++;
					}
					if (domofpress.get(i).getDp14() > dp14 || 0 > domofpress.get(i).getDp14()) {
						sumofpress[13]++;
					}
					if (domofpress.get(i).getDp15() > dp15 || 0 > domofpress.get(i).getDp15()) {
						sumofpress[14]++;
					}
					if (domofpress.get(i).getDp16() > dp16 || 0 > domofpress.get(i).getDp16()) {
						sumofpress[15]++;
					}
					if (domofpress.get(i).getDp17() > dp17 || 0 > domofpress.get(i).getDp17()) {
						sumofpress[16]++;
					}
					if (domofpress.get(i).getDp18() > dp18 || 0 > domofpress.get(i).getDp18()) {
						sumofpress[17]++;
					}
					if (!(domofpress.get(i).getDp19() >= dp19h || dp19l >= domofpress.get(i).getDp19())) {
						sumofpress[18]++;
					}
					if (!(domofpress.get(i).getDp20() >= dp20h || dp20l >= domofpress.get(i).getDp20())) {
						sumofpress[19]++;
					}
					if (!(domofpress.get(i).getDp21() >= dp21h || dp21l >= domofpress.get(i).getDp21())) {
						sumofpress[20]++;
					}
					if (!(domofpress.get(i).getDp22() >= dp22h || dp22l >= domofpress.get(i).getDp22())) {
						sumofpress[21]++;
					}
					if (!(domofpress.get(i).getDp23() >= dp23h || dp23l >= domofpress.get(i).getDp23())) {
						sumofpress[22]++;
					}
					if (!(domofpress.get(i).getDp24() >= dp24h || dp24l >= domofpress.get(i).getDp24())) {
						sumofpress[23]++;
					}
					if (domofpress.get(i).getDp25() > dp25 || 0 > domofpress.get(i).getDp25()) {
						sumofpress[24]++;
					}
					if (domofpress.get(i).getDp26() > dp26 || 0 > domofpress.get(i).getDp26()) {
						sumofpress[25]++;
					}
					if (domofpress.get(i).getDp27() > dp27 || 0 > domofpress.get(i).getDp27()) {
						sumofpress[26]++;
					}
					if (domofpress.get(i).getDp28() > dp28 || 0 > domofpress.get(i).getDp28()) {
						sumofpress[27]++;
					}
				}
				//查看统计的单个点异常总数和数据长度是否一样 ，是则说明这一段时间内气压都不正常
				for(int i = 0 ; i < 28 ; i++){
					if (sumofpress[i] == domofpress.size() && domofpress.size() != 0){
						if(AlarminfoSave.idofp[i] == (-1)){
							AlarminfoSave.idofp[i] = AlarminfoSave.add(stimeofpress, etime,"p"+(i+1), "p"+(i+1)+"压差异常", "未处理","压差异常");
						}else{
							AlarminfoSave.update(AlarminfoSave.idofp[i], etime);
						}
					}else{
						AlarminfoSave.idofp[i] = -1;
					}
				}
				
				//检测温度是否异常
				String hqloftemp = "from Dataofmonitor where dtime between '" + stimeoftemp + "' and '" + etime + "'";
				Query queryoftemp = ss.createQuery(hqloftemp);
				List<Dataofmonitor> domoftemp = queryoftemp.list();//总共多少条数据
				if (domoftemp.size() == 0) {
					if (AlarminfoSave.alarmoftempofid == -1) { //AlarminfoSave.alarmoftempofid == -1 说明上一次数据都是正常的
						AlarminfoSave.alarmoftempofid = AlarminfoSave.add(stimeoftemp, etime,"全局", "无温度数据上传", "未处理","通讯异常");
					} else{
						//如果c1不是0而是一个id那说明，在上一次之后的时间内依然没有数据上传，只需要更新报警的结束时间就可以了
						AlarminfoSave.update(AlarminfoSave.alarmoftempofid, etime);
					}
				}else{
					AlarminfoSave.alarmoftempofid = -1;
				}
				for(int i = 0 ; i < domoftemp.size() ; i++){
					if(domoftemp.get(i).getDt1() > dth || domoftemp.get(i).getDt1() < dtl){
						sumoftemp[0]++;
					}
					if(domoftemp.get(i).getDt2() > dth || domoftemp.get(i).getDt2() < dtl){
						sumoftemp[1]++;
					}
					if(domoftemp.get(i).getDt3() > dth || domoftemp.get(i).getDt3() < dtl){
						sumoftemp[2]++;
					}
					if(domoftemp.get(i).getDt4() > dth || domoftemp.get(i).getDt4() < dtl){
						sumoftemp[3]++;
					}
					if(domoftemp.get(i).getDt5() > dth || domoftemp.get(i).getDt5() < dtl){
						sumoftemp[4]++;
					}
					if(domoftemp.get(i).getDt6() > dth || domoftemp.get(i).getDt6() < dtl){
						sumoftemp[5]++;
					}
					if(domoftemp.get(i).getDt7() > dth || domoftemp.get(i).getDt7() < dtl){
						sumoftemp[6]++;
					}
					if(domoftemp.get(i).getDt8() > dth || domoftemp.get(i).getDt8() < dtl){
						sumoftemp[7]++;
					}
					if(domoftemp.get(i).getDt9() > dth || domoftemp.get(i).getDt9() < dtl){
						sumoftemp[8]++;
					}
					if(domoftemp.get(i).getDt10() > dth || domoftemp.get(i).getDt10() < dtl){
						sumoftemp[9]++;
					}
				}
				//查看统计的总数和数据长度是否一样 ，是则说明这一段时间内温度都不正常
				for(int i = 0 ; i < 10 ; i++){
					if (sumoftemp[i] == domoftemp.size() && domoftemp.size() != 0){ //domoftemp.size()时间内的总记录数
						if(AlarminfoSave.idoft[i] == (-1)){
							AlarminfoSave.idoft[i] = AlarminfoSave.add(stimeofpress, etime,"T"+(i+1), "T"+(i+1)+"温度异常", "未处理","温度异常");
						}else{
							AlarminfoSave.update(AlarminfoSave.idoft[i], etime);
						}
					}else{
						AlarminfoSave.idoft[i] = -1;
					}
				}
				
				
				//检测湿度是否异常
				String hqlofrh = "from Dataofmonitor where dtime between '" + stimeofrh + "' and '" + etime + "'";
				Query queryofrh = ss.createQuery(hqlofrh);
				List<Dataofmonitor> domofrh = queryofrh.list();
				if (domofrh.size() == 0) {
					if (AlarminfoSave.alarmofrhofid == -1) {
						AlarminfoSave.alarmofrhofid = AlarminfoSave.add(stimeofrh, etime,"全局", "无湿度数据上传", "未处理","通讯异常");
					} else{
						//如果c1不是0而是一个id那说明，在上一次之后的时间内依然没有数据上传，只需要更新报警的结束时间就可以了
						AlarminfoSave.update(AlarminfoSave.alarmofrhofid, etime);
					}
				}else{
					AlarminfoSave.alarmofrhofid = -1;
				}
				for(int i = 0 ; i < domofrh.size() ; i++){
					if(domofrh.get(i).getDrh1() >  drhh || domofrh.get(i).getDrh1() < drhl)
						sumofrh[0]++;
					if(domofrh.get(i).getDrh2() >  drhh || domofrh.get(i).getDrh2() < drhl)
						sumofrh[1]++;
					if(domofrh.get(i).getDrh3() >  drhh || domofrh.get(i).getDrh3() < drhl)
						sumofrh[2]++;
					if(domofrh.get(i).getDrh4() >  drhh || domofrh.get(i).getDrh4() < drhl)
						sumofrh[3]++;
					if(domofrh.get(i).getDrh5() >  drhh || domofrh.get(i).getDrh5() < drhl)
						sumofrh[4]++;
					if(domofrh.get(i).getDrh6() >  drhh || domofrh.get(i).getDrh6() < drhl)
						sumofrh[5]++;
					if(domofrh.get(i).getDrh7() >  drhh || domofrh.get(i).getDrh7() < drhl)
						sumofrh[6]++;
					if(domofrh.get(i).getDrh8() >  drhh || domofrh.get(i).getDrh8() < drhl)
						sumofrh[7]++;
					if(domofrh.get(i).getDrh9() >  drhh || domofrh.get(i).getDrh9() < drhl)
						sumofrh[8]++;
					if(domofrh.get(i).getDrh10() >  drhh || domofrh.get(i).getDrh10() < drhl)
						sumofrh[9]++;
				}
				//查看统计的总数和数据长度是否一样 ，是则说明这一段时间内湿度都不正常
				for(int i = 0 ; i < 10 ; i++){
					if (sumofrh[i] == domofrh.size() && domofrh.size() != 0){
						if(AlarminfoSave.idofrh[i] == (-1)){
							AlarminfoSave.idofrh[i] = AlarminfoSave.add(stimeofrh, etime,"RH"+(i+1), "RH"+(i+1)+"湿度异常", "未处理","湿度异常");
						}else{
							AlarminfoSave.update(AlarminfoSave.idofrh[i], etime);
						}
					}else{
						AlarminfoSave.idofrh[i] = -1;
					}
				}
				
				
				
			} catch (Exception e) {
				context.log("error");
				e.printStackTrace();

			} finally {
				if (ss != null) {
					ss.close();
				}
				isRunning = false;
				context.log("报警信息任务执行结束");
			}
		} else {
			context.log("上一次任务执行还未结束");
		}
	}

}
