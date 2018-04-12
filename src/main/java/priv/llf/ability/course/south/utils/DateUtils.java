package priv.llf.ability.course.south.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: eleven
 * @since: 2018/4/6 14:28
 * @Description:
 */
public class DateUtils {

    public static final int pattenToDay    = 1;
    public static final int pattenToSecond = 2;
    public static SimpleDateFormat sdfToDay    = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdfToSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getCurrentDateByFormat(int patten){
        Date currentDate;
        Date date = new Date();
        try {
            if (patten == pattenToDay){
                currentDate = sdfToDay.parse(sdfToDay.format(new Date()));
            }else {
                currentDate = sdfToSecond.parse(sdfToSecond.format(new Date()));
            }
        }catch (ParseException e){
            throw new IllegalArgumentException("转换失败，时间参数格式错误");
        }
        return currentDate;
    }


    public static Date toDate(String timeStr,int patten){
        Date result;
        try {
            if (patten == pattenToDay){
                result = sdfToDay.parse(timeStr);
            }else {
                result = sdfToSecond.parse(timeStr);
            }
        }catch (ParseException e){
            throw new IllegalArgumentException("转换失败，时间参数格式错误");
        }
        return result;
    }
    public static String toString(Date date,int patten){
        String result;
        try {
            if (patten == pattenToDay){
                result = sdfToDay.format(date);
            }else {
                result = sdfToSecond.format(date);
            }
        }catch (Exception e){
            throw new IllegalArgumentException("转换失败，时间参数格式错误");
        }

        return result;
    }
    /**
     * 判断时间是否在时间段内
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return 1：早于给定的时间段 2晚于给定的时间段  3在时间范围内
     */
    public static int belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.before(begin)) return 1;
        if (date.after(end)) return 2;
        return 3;
    }

}
