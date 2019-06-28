package com.xingyun.util;



import com.xingyun.model.SearchCond;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AverageDateUtil {



    public static Boolean findSame(String cond,Date strDate,String date){
        if (cond.equals("Year")) {
            //Date dateFromStr = DateUtil.getDateFromStr(strDate, "yyyy");
            String strFromDate = DateUtil.getStrFromDate(strDate, "yyyy");
            if (date.equals(strFromDate)) {
                return true;
            }
        } else if (cond.equals("Mon")) {
            //Date dateFromStr = DateUtil.getDateFromStr(strDate, "yyyy-MM");
            String strFromDate = DateUtil.getStrFromDate(strDate, "yyyy-MM");
            if (date.equals(strFromDate)) {
                return true;
            }
        } else if (cond.equals("Day")) {
            //Date dateFromStr = DateUtil.getDateFromStr(strDate, "yyyy-MM-dd");
            String strFromDate = DateUtil.getStrFromDate(strDate, "yyyy-MM-dd");
            if (date.equals(strFromDate)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 根据条件判断查询何种平均值
     * @param cond
     * @return
     */
    public static String findFormat(String cond){
        if (cond.equals("Year")) {
            return "yyyy";
        } else if (cond.equals("Mon")) {
            return "yyyy-MM";
        } else if (cond.equals("Day")) {
            return "yyyy-MM-dd";
        }
        return null;
    }

    /**
     * 根据查询条件拆分时间
     * @param searchCond
     * @return
     */
    public static List<String> splitDate(SearchCond searchCond){
        String startTime = searchCond.getStartTime();
        String endTime = searchCond.getEndTime();
        String cond = searchCond.getCondition();
        List<String> list = new ArrayList<>();
        //拆分成数组
        String[] dateBegs = startTime.split("-");
        String[] dateEnds = endTime.split("-");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        try {
                if (cond.equals("Day")) {
                    //时间转化为时间戳
                    start.set(Integer.valueOf(dateBegs[0]), Integer.valueOf(dateBegs[1]) - 1, Integer.valueOf(dateBegs[2]));
                    Long sT = start.getTimeInMillis();
                    end.set(Integer.valueOf(dateEnds[0]), Integer.valueOf(dateEnds[1]) - 1, Integer.valueOf(dateEnds[2]));
                    Long eT = end.getTimeInMillis();
                    //定义一个一天的时间戳时长
                    Long oneDay = 1000 * 60 * 60 * 24l;
                    Long time = sT;
                    //循环得出
                    if(end.before(start)){
                        throw new Exception("结束时间不能小于开始时间！");
                    }
                    while (time <= eT) {
                        list.add(new SimpleDateFormat("yyyy-MM-dd").format(new Date(time)));
                        time += oneDay;
                    }
                } else if (cond.equals("Mon")) {
                    //ArrayList<String> result = new ArrayList<String>();
                    Calendar sT = Calendar.getInstance();
                    Calendar eT = Calendar.getInstance();
                    sT.setTime(DateUtil.getDateFromStr(startTime, "yyyy-MM"));
                    sT.set(sT.get(Calendar.YEAR), sT.get(Calendar.MONTH), 1);
                    eT.setTime(DateUtil.getDateFromStr(endTime, "yyyy-MM"));
                    eT.set(eT.get(Calendar.YEAR), eT.get(Calendar.MONTH), 2);
                    Calendar curr = sT;
                    if(end.before(start)){
                        throw new Exception("结束时间不能小于开始时间！");
                    }
                    while (curr.before(eT)) {
                        list.add(DateUtil.getStrFromDate(curr.getTime(), "yyyy-MM"));
                        curr.add(Calendar.MONTH, 1);
                    }
                } else if (cond.equals("Year")) {
                    Calendar sT = Calendar.getInstance();
                    Calendar eT = Calendar.getInstance();
                    sT.setTime(DateUtil.getDateFromStr(startTime, "yyyy"));
                    //System.err.println(sT.getTime());
                    //sT.set(sT.get(Calendar.YEAR), 0);
                    eT.setTime(DateUtil.getDateFromStr(endTime, "yyyy"));
                    //eT.set(eT.get(Calendar.YEAR), 1);
                    Calendar curr = sT;
                    if(end.before(start)){
                        throw new Exception("结束时间不能小于开始时间！");
                    }
                    while (curr.before(eT) || curr.equals(eT)) {
                        list.add(DateUtil.getStrFromDate(curr.getTime(), "yyyy"));
                        curr.add(Calendar.YEAR, 1);
                    }
                }

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return  list;
    }

    /*public static void main(String[] args){
        //AverageDateUtil averageDateUtil = new AverageDateUtil();
        Map<String,Object> map = new HashMap<>();
        map.put("startTime","2019-03");
        map.put("endTime","2019-05");
        map.put("condition","M");
        System.err.print(AverageDateUtil.splitDate(map).toString());
    }*/
}
