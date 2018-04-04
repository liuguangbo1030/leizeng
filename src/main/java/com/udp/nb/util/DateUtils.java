package com.udp.nb.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 日期工具类
 *
 * @author cloudy
 *
 */
public class DateUtils {
    /** 日期格式 */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /** 时间格式 */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 时间格式 */
    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final SimpleDateFormat dayFormat1 = new SimpleDateFormat("yyyyMMdd");

    public static final SimpleDateFormat dayFormat2 = new SimpleDateFormat(DATE_FORMAT);

    public static final SimpleDateFormat dateTimeFormat3 = new SimpleDateFormat(DATE_TIME_FORMAT);

    public static final SimpleDateFormat dateFormatOFyyyyMMddHHmmss = new SimpleDateFormat(
            "yyyyMMddHHmmss");

    /**
     * 解析日期
     *
     * @param dateStr
     * @param dateFormat
     * @return
     * @throws ParseException
     */
    public static Date parseDateStr(String dateStr, String dateFormat) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat(dateFormat);
        Date date = ft.parse(dateStr);
        return date;
    }

    /**
     * 计算两个日期的时间差
     *
     * @param dateStr1
     * @param dateStr2
     * @return
     * @throws ParseException
     */
    public static int computeDateDifference(String dateStr1, String dateStr2) throws ParseException {
        Date date1 = parseDateStr(dateStr1, DATE_FORMAT);
        Date date2 = parseDateStr(dateStr2, DATE_FORMAT);
        int days1 = (int) TimeUnit.MILLISECONDS.toDays(date1.getTime());
        int days2 = (int) TimeUnit.MILLISECONDS.toDays(date2.getTime());
        return days2 - days1;

    }

    /**
     * 计算两个日期的日期差
     *
     * @param dateStr1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static int computeDateDifference(String dateStr1, Date date2) throws ParseException {
        Date date1 = parseDateStr(dateStr1, DATE_FORMAT);
        int days1 = (int) TimeUnit.MILLISECONDS.toDays(date1.getTime());
        int days2 = (int) TimeUnit.MILLISECONDS.toDays(date2.getTime());
        return days2 - days1;

    }

    /**
     * 计算两个日期的小时差
     *
     * @param dateStr1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static int computeHoursDifference(String dateStr1, Date date2) throws ParseException {
        Date date1 = parseDateStr(dateStr1, DATE_TIME_FORMAT);
        int hours1 = (int) TimeUnit.MILLISECONDS.toHours(date1.getTime());
        int hours2 = (int) TimeUnit.MILLISECONDS.toHours(date2.getTime());
        return hours2 - hours1;
    }

    /**
     * 计算两个日期的分钟差
     *
     * @param dateStr1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static long computeMinutesDifference(String dateStr1, Date date2) throws ParseException {
        Date date1 = parseDateStr(dateStr1, DATE_TIME_FORMAT);
        long minutes1 = TimeUnit.MILLISECONDS.toMinutes(date1.getTime());
        long minutes2 = TimeUnit.MILLISECONDS.toMinutes(date2.getTime());
        return minutes2 - minutes1;
    }

    /**
     * 计算两个日期的秒差
     *
     * @param dateStr1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static long computeSecondsDifference(String dateStr1, Date date2) throws ParseException {
        Date date1 = parseDateStr(dateStr1, DATE_TIME_FORMAT);
        long minutes1 = TimeUnit.MILLISECONDS.toSeconds(date1.getTime());
        long minutes2 = TimeUnit.MILLISECONDS.toSeconds(date2.getTime());
        return minutes2 - minutes1;
    }

    /**
     * 获取当前时间字符串
     *
     * @return
     */
    public static String getCurrentTimeStr() {
        SimpleDateFormat ft = new SimpleDateFormat(DATE_TIME_FORMAT);
        return ft.format(new Date());
    }

    /**
     * 获取指定时间字符串
     *
     * @return
     */
    public static String getTimeStrOfDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat ft = new SimpleDateFormat(DATE_TIME_FORMAT);
        return ft.format(date);
    }

    /**
     * 获取当前日期字符串
     *
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat ft = new SimpleDateFormat(DATE_FORMAT);
        return ft.format(new Date());
    }

    /**
     * 获取当前时间前面一段时间。参数单位是分钟
     *
     * @param minute
     * @return
     */
    public static String getTimeStrBeforeNow(long minute) {
        long time = System.currentTimeMillis() - minute * 60 * 1000;
        Date date = new Date(time);

        SimpleDateFormat ft = new SimpleDateFormat(DATE_TIME_FORMAT);
        return ft.format(date);
    }

    /**
     * 比较两个时间字符串的先后。
     *
     * @param timeStr1
     * @param timeStr2
     * @return
     * @throws ParseException
     */
    public static boolean isBefore(String timeStr1, String timeStr2) throws ParseException {
        Date date1 = parseDateStr(timeStr1, DATE_TIME_FORMAT);
        Date date2 = parseDateStr(timeStr2, DATE_TIME_FORMAT);
        return date1.before(date2);
    }

    /**
     * 判断当前时间时间是否在两个时间之中
     *
     * @param timeStr1
     * @param timeStr2
     * @return
     * @throws ParseException
     */
    public static boolean isInTimeRange(String timeStr1, String timeStr2) throws ParseException {
        Date date1 = parseDateStr(timeStr1, TIME_FORMAT);
        Date date2 = parseDateStr(timeStr2, TIME_FORMAT);

        SimpleDateFormat ft = new SimpleDateFormat(TIME_FORMAT);
        Date curr = ft.parse(ft.format(new Date()));
        return (date1.before(curr) && curr.before(date2));
    }

    /**
     * 获取当前日
     *
     * @return
     * @throws ParseException
     */
    public static int getDay(String dateStr) {
        if (dateStr == null || dateStr == "") {
            return -1;
        }

        Date date = null;
        try {
            date = dayFormat2.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
        }
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.get(Calendar.DAY_OF_YEAR);
        }
        return -1;
    }

    /**
     * 获取当前月
     *
     * @return
     * @throws ParseException
     */
    public static int getMonth(String dateStr) {
        if (dateStr == null || dateStr == "") {
            return -1;
        }

        Date date = null;
        try {
            date = dayFormat2.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
        }
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.get(Calendar.MONTH) + 1; // 为啥要多加1??
        }
        return -1;
    }

    /**
     * 获取当前周 dateStr -> YYYY-MM-DD
     *
     * @return
     * @throws ParseException
     */
    public static int getWeek(String dateStr) {
        if (dateStr == null || dateStr == "") {
            return -1;
        }

        Date date = null;
        try {
            date = dayFormat2.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
        }
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.setFirstDayOfWeek(Calendar.MONDAY);// 每一周第一天为周一
            return cal.get(Calendar.WEEK_OF_YEAR);
        }
        return -1;
    }

    /**
     * 获取指定日期: YYYYMMDD
     *
     * @return
     */
    public static int getDayFromDate(Date date) {
        int fday = 0;

        if (date == null) {
            // 默认当天
            date = new Date();
        }

        if (date != null) {
            String dateStr = dayFormat1.format(date);
            if (dateStr != null && Integer.valueOf(dateStr) > 0) {
                fday = Integer.parseInt(dateStr);
            }
        }
        return fday;
    }

    /**
     * 判断 是否合法日期格式
     *
     * @return
     */
    public static boolean isValidDay(String strDay) {
        if (strDay != null) {
            try {
                dayFormat2.parse(strDay);
                return true;
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 获取当天日期 yyyy-mm-dd
     */
    public static String getCurrentDayStr() {
        return dayFormat2.format(new Date());
    }

    /**
     * 获取指定日期字符串 yyyy-mm-dd
     */
    public static String getDayStrFromDate(Date date) {
        if (date == null) {
            return null;
        }
        return dayFormat2.format(date);
    }

    /**
     * 获取指定日期字符串 yyyy-mm-dd HH:nn:ss
     */
    public static String getDayTimeStrFromDate(Date date) {
        if (date == null) {
            return null;
        }
        return dateTimeFormat3.format(date);
    }

    /**
     * 获取当前月的第一天
     *
     * @return
     */
    public static String getFirstDayOfMonth() {
        // 当前日期实例
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// 取当前日期月的第一天
        return dayFormat2.format(c.getTime());

    }

    /**
     * 获取当前周周一的日期
     *
     * @return
     */
    public static String getFirstDayOfWeek() {
        // 当前日期实例
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 取当前日期月的第一天
        return dayFormat2.format(c.getTime());

    }

    /**
     * 获取当前年份的第一天的日期
     *
     * @return
     */
    public static String getFirstDayOfYear() {
        // 当前日期实例
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_YEAR, Calendar.YEAR);// 取当前日期月的第一天
        return dayFormat2.format(c.getTime());

    }

    /**
     * 前一天日期
     */
    public static String getLastDay() {
        // 当前日期实例
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);// 取当前日期的前一天日期
        return dayFormat2.format(c.getTime());
    }

    /**
     * 获取上周第一天 注意： 日期方法里第一天是星期日的,可是我们是从周一开始算第一天
     */
    public static String getFirstDayOfLastWeek() {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.WEEK_OF_MONTH, -1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 上一周第一天

        return dayFormat2.format(calendar.getTime());
    }

    /**
     * 获取上周最后一天 其实就是当前周的第一天
     */
    public static String getLastDayOfLastWeek() {
        // 当前日期实例
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);// 取当前周的第一天,即上周的星期日
        return dayFormat2.format(c.getTime());
    }

    /**
     * 获取上月第一天
     */
    public static String getFirstDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);// 得到当前月份
        calendar.set(Calendar.MONTH, month - 1);// 上个月
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 上个月第一天

        return dayFormat2.format(calendar.getTime());
    }

    /**
     * 获取上月最后一天
     */
    public static String getLastDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);// 得到当前月份
        calendar.set(Calendar.MONTH, month - 1);// 上个月
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// 上个月最后一天

        return dayFormat2.format(calendar.getTime());
    }

    /**
     * 获取上年第一天
     */
    public static String getFirstDayOfLastYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);// 得到当前年份
        calendar.set(Calendar.YEAR, year - 1);// 上一年
        calendar.set(Calendar.DAY_OF_YEAR, 1);// 上一年第一天

        return dayFormat2.format(calendar.getTime());
    }

    /**
     * 获取上年最后一天
     */
    public static String getLastDayOfLastYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);// 得到当前年份
        calendar.set(Calendar.YEAR, year - 1);// 上一年
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));// 上一年最后一天

        return dayFormat2.format(calendar.getTime());
    }

    /**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static String getFirstDayOfWeek(int year, int week) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 设置周一
        c.setFirstDayOfWeek(Calendar.MONDAY);
        return dayFormat2.format(c.getTime());
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static String getLastDayOfWeek(int year, int week) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return dayFormat2.format(c.getTime());
    }

    /**
     * 得到某年某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dayFormat2.format(c.getTime());
    }

    /**
     * 得到某年某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dayFormat2.format(c.getTime());
    }

    /**
     * 格式转换日期:yyyy-mm-dd
     *
     * @param date
     */
    public static Date getDateFromDayStr(String date) {
        if (date == null || date == "") {
            try {
                return dayFormat2.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block

            }
        }
        return null;
    }

    /**
     * 格式转换日期:yyyy-mm-dd HH:MM:SS
     *
     * @param time
     */
    public static Date getDateFromTimeStr(String time) {
        if (time == null || time == "") {
            try {
                return dateTimeFormat3.parse(time);
            } catch (ParseException e) {
                // TODO Auto-generated catch block

            }
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("getFirstDayOfMonth:" + getFirstDayOfMonth());

        System.out.println("getFirstDayOfWeek:" + getFirstDayOfWeek());

        System.out.println("getFirstDayOfYear:" + getFirstDayOfYear());

        System.out.println("getCurrentDayStr:" + getCurrentDayStr());

        System.out.println("getFirstDayOfLastMonth: " + getFirstDayOfLastMonth());

        System.out.println("getLastDayOfLastMonth: " + getLastDayOfLastMonth());

        System.out.println("getFirstDayOfLastYear: " + getFirstDayOfLastYear());

        System.out.println("getLastDayOfLastYear: " + getLastDayOfLastYear());

        System.out.println("getFirstDayOfLastWeek: " + getFirstDayOfLastWeek());

        System.out.println("getLastDayOfLastWeek: " + getLastDayOfLastWeek());

        System.out.println("get Week of year:" + getWeek("2014-07-21"));
        System.out.println("get Week of year:" + getWeek("2014-07-27"));

        System.out.println("get month of year:" + getMonth("2014-07-27"));

        System.out.println("get day of year:" + getDay("2014-07-24"));

        System.out.println("getFirstDayOfWeek:" + getFirstDayOfWeek(2014, 30));

        System.out.println("getLastDayOfWeek:" + getLastDayOfWeek(2014, 30));

        System.out.println("getFirstDayOfMonth:" + getFirstDayOfMonth(2014, 7));

        System.out.println("getLastDayOfMonth:" + getLastDayOfMonth(2014, 7));

        System.out.println("getDateFromDayStr:" + getDateFromDayStr("2014-01-10"));
    }

    /**
     *
     *
     * */
    public static Date getDateByChangeDay(Date date, int day) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        Date retunDate = cal.getTime();
        return retunDate;
    }

    public static String getDateTimeStringByyyyyMMddHHmmssString(String dateTime)
            throws ParseException {
        if (dateTime == null) {
            return null;
        }
        Date date = dateFormatOFyyyyMMddHHmmss.parse(dateTime);
        if (date != null) {
            return dateTimeFormat3.format(date);
        }
        return null;
    }


    public static Date getDateFromyyyyMMddHHmmssString(String dateTime) throws ParseException {
        if (dateTime == null) {
            return null;
        }
        Date date = dateFormatOFyyyyMMddHHmmss.parse(dateTime);
        return date;
    }

    public static long getDateDiffByDateTimeString(String dateTimeOne, String dateTimeTwo)
            throws ParseException {
        Date timeOneDate = dateTimeFormat3.parse(dateTimeOne);
        Date timeTwoDate = dateTimeFormat3.parse(dateTimeTwo);
        return timeTwoDate.getTime() - timeOneDate.getTime();
    }
}
