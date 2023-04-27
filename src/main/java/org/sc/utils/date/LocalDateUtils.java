package org.sc.utils.date;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * @author shen chen
 * @description Java8日期时间工具类
 * @date 2023/4/25 17:14
 */
public class LocalDateUtils {

    /**
     * 显示年月日时分秒，例如 2015-08-11 09:51:53.
     */
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 标准日期时间格式，精确到毫秒：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 仅显示年月日，例如 2015-08-11.
     */
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 标准日期格式：yyyy年MM月dd日
     */
    public static final String CHINESE_DATE_PATTERN = "yyyy年MM月dd日";


    /**
     * 仅显示时分秒，例如 09:51:53.
     */
    public static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * 显示年月日时分秒(无符号)，例如 20150811095153.
     */
    public static final String UNSIGNED_DATETIME_PATTERN = "yyyyMMddHHmmss";

    /**
     * 仅显示年月日(无符号)，例如 20150811.
     */
    public static final String UNSIGNED_DATE_PATTERN = "yyyyMMdd";


    /**
     * 春天;
     */
    public static final Integer SPRING = 1;

    /**
     * 夏天;
     */
    public static final Integer SUMMER = 2;

    /**
     * 秋天;
     */
    public static final Integer AUTUMN = 3;

    /**
     * 冬天;
     */
    public static final Integer WINTER = 4;

    /**
     * 星期日;
     */
    public static final String SUNDAY = "星期日";

    /**
     * 星期一;
     */
    public static final String MONDAY = "星期一";

    /**
     * 星期二;
     */
    public static final String TUESDAY = "星期二";

    /**
     * 星期三;
     */
    public static final String WEDNESDAY = "星期三";

    /**
     * 星期四;
     */
    public static final String THURSDAY = "星期四";

    /**
     * 星期五;
     */
    public static final String FRIDAY = "星期五";

    /**
     * 星期六;
     */
    public static final String SATURDAY = "星期六";

    /**
     * 年
     */
    private static final String YEAR = "year";

    /**
     * 月
     */
    private static final String MONTH = "month";

    /**
     * 周
     */
    private static final String WEEK = "week";

    /**
     * 日
     */
    private static final String DAY = "day";

    /**
     * 时
     */
    private static final String HOUR = "hour";

    /**
     * 分
     */
    private static final String MINUTE = "minute";

    /**
     * 秒
     */
    private static final String SECOND = "second";

    /**
     * 获取当前日期和时间字符串.
     *
     * @return String 日期时间字符串，例如 2015-08-11 09:51:53
     */
    public static String getLocalDateTimeStr() {
        return format(LocalDateTime.now(), DATETIME_PATTERN);
    }

    /**
     * 获取当前日期字符串.
     *
     * @return String 日期字符串，例如2015-08-11
     */
    public static String getLocalDateStr() {
        return format(LocalDate.now(), DATE_PATTERN);
    }

    /**
     * 获取当前时间字符串.
     *
     * @return String 时间字符串，例如 09:51:53
     */
    public static String getLocalTimeStr() {
        return format(LocalTime.now(), TIME_PATTERN);
    }

    /**
     * 获取当前星期字符串.
     *
     * @return String 当前星期字符串，例如 星期二
     */
    public static String getDayOfWeekStr() {
        return format(LocalDate.now(), "E");
    }

    /**
     * 获取指定日期是星期几
     * 这个方法的星期几内容可以自定义
     *
     * @param localDate 日期
     * @return String 星期几
     */
    public static String getDayOfWeekStr2(LocalDate localDate) {
        String[] weekOfDays = {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
        int dayOfWeek = localDate.getDayOfWeek().getValue() - 1;
        return weekOfDays[dayOfWeek];
    }

    /**
     * 获取指定日期是星期几
     *
     * @param localDate 日期
     * @return String 星期几
     */
    public static String getDayOfWeekStr(LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    /**
     * 获取日期时间字符串
     *
     * @param temporal 需要转化的日期时间
     * @param pattern  时间格式
     * @return String 日期时间字符串，例如 2015-08-11 09:51:53
     */
    public static String format(TemporalAccessor temporal, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(temporal);
    }

    /**
     * 日期时间字符串转换为日期时间(java.time.LocalDateTime)
     *
     * @param localDateTimeStr 日期时间字符串
     * @param pattern          日期时间格式 例如DATETIME_PATTERN
     * @return LocalDateTime 日期时间
     */
    public static LocalDateTime parseLocalDateTime(String localDateTimeStr, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(localDateTimeStr, dateTimeFormatter);
    }

    /**
     * 日期字符串转换为日期(java.time.LocalDate)
     *
     * @param localDateStr 日期字符串
     * @param pattern      日期格式 例如DATE_PATTERN
     * @return LocalDate 日期
     */
    public static LocalDate parseLocalDate(String localDateStr, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(localDateStr, dateTimeFormatter);
    }

    /**
     * 获取指定日期时间加上指定数量日期时间单位之后的日期时间.
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @param chronoUnit    日期时间单位
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime plus(LocalDateTime localDateTime, int num, ChronoUnit chronoUnit) {
        return localDateTime.plus(num, chronoUnit);
    }

    /**
     * 获取指定日期时间 加上 指定 秒 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime plusSeconds(LocalDateTime localDateTime, int num) {
        return localDateTime.plus(num, ChronoUnit.SECONDS);
    }

    /**
     * 获取指定日期时间 加上 指定 分钟 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime plusMinutes(LocalDateTime localDateTime, int num) {
        return localDateTime.plus(num, ChronoUnit.MINUTES);
    }

    /**
     * 获取指定日期时间 加上 指定 小时 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime plusHours(LocalDateTime localDateTime, int num) {
        return localDateTime.plus(num, ChronoUnit.HOURS);
    }

    /**
     * 获取指定日期时间 加上 指定 天数 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime plusDay(LocalDateTime localDateTime, int num) {
        return localDateTime.plus(num, ChronoUnit.DAYS);
    }


    /**
     * 获取指定日期时间 加上 指定 月份 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime plusMonth(LocalDateTime localDateTime, int num) {
        return localDateTime.plus(num, ChronoUnit.MONTHS);
    }

    /**
     * 获取指定日期时间 加上 指定 年 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime plusYears(LocalDateTime localDateTime, int num) {
        return localDateTime.plus(num, ChronoUnit.YEARS);
    }

    /**
     * 获取指定日期时间 减去 指定 小时 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime minusHours(LocalDateTime localDateTime, int num) {
        return localDateTime.minus(num, ChronoUnit.HOURS);
    }

    /**
     * 获取指定日期时间 减去 指定 秒 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime minusSeconds(LocalDateTime localDateTime, int num) {
        return localDateTime.minus(num, ChronoUnit.SECONDS);
    }

    /**
     * 获取指定日期时间 减去 指定 分钟 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime minusMinutes(LocalDateTime localDateTime, int num) {
        return localDateTime.minus(num, ChronoUnit.MINUTES);
    }

    /**
     * 获取指定日期时间 减去 指定 天数 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime minusDay(LocalDateTime localDateTime, int num) {
        return localDateTime.minus(num, ChronoUnit.DAYS);
    }

    /**
     * 获取指定日期时间 减去 指定 月份 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime minusMonth(LocalDateTime localDateTime, int num) {
        return localDateTime.minus(num, ChronoUnit.MONTHS);
    }

    /**
     * 获取指定日期时间 减去 指定 年 后的时间
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime minusYears(LocalDateTime localDateTime, int num) {
        return localDateTime.minus(num, ChronoUnit.YEARS);
    }


    /**
     * 获取指定日期时间减去指定数量日期时间单位之后的日期时间.
     *
     * @param localDateTime 日期时间
     * @param num           数量
     * @param chronoUnit    日期时间单位
     * @return LocalDateTime 新的日期时间
     */
    public static LocalDateTime minus(LocalDateTime localDateTime, int num, ChronoUnit chronoUnit) {
        return localDateTime.minus(num, chronoUnit);
    }

    /**
     * 根据 ChronoUnit 计算两个日期时间之间相隔日期时间
     *
     * @param start      开始日期时间
     * @param end        结束日期时间
     * @param chronoUnit 日期时间单位
     * @return long 相隔日期时间
     */
    public static long between(LocalDateTime start, LocalDateTime end, ChronoUnit chronoUnit) {
        return Math.abs(start.until(end, chronoUnit));
    }

    /**
     * 根据 ChronoUnit 计算两个日期时间之间相隔日期时间
     *
     * @param start      开始日期
     * @param end        结束日期
     * @param chronoUnit 日期时间单位,(ChronoUnit.YEARS,ChronoUnit.MONTHS,ChronoUnit.WEEKS,ChronoUnit.DAYS)
     * @return long 相隔年数或月数或天数
     */
    public static long between(LocalDate start, LocalDate end, ChronoUnit chronoUnit) {
        return Math.abs(start.until(end, chronoUnit));
    }

    /**
     * 获取本年第一天的日期字符串
     *
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfYearStr() {
        return getBeginOfYearStr(LocalDateTime.now());
    }

    /**
     * 获取本年最后一天的日期字符串
     *
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfYearStr() {
        return getEndOfYearStr(LocalDateTime.now());
    }

    /**
     * 获取指定日期当年第一天的日期字符串
     *
     * @param localDateTime 指定日期时间
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfYearStr(LocalDateTime localDateTime) {
        return getBeginOfYearStr(localDateTime, DATETIME_PATTERN);
    }

    /**
     * 获取指定日期当年最后一天的日期字符串
     *
     * @param localDateTime 指定日期时间
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfYearStr(LocalDateTime localDateTime) {
        return getEndOfYearStr(localDateTime, DATETIME_PATTERN);
    }

    /**
     * 获取指定日期当年第一天的日期字符串,带日期格式化参数
     *
     * @param localDateTime 指定日期时间
     * @param pattern       日期时间格式
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfYearStr(LocalDateTime localDateTime, String pattern) {
        return format(localDateTime.withDayOfYear(1).withHour(0).withMinute(0).withSecond(0), pattern);
    }

    /**
     * 获取指定日期当年最后一天的日期字符串,带日期格式化参数
     *
     * @param localDateTime 指定日期时间
     * @param pattern       日期时间格式
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfYearStr(LocalDateTime localDateTime, String pattern) {
        return format(localDateTime.with(TemporalAdjusters.lastDayOfYear()).withHour(23).withMinute(59).withSecond(59), pattern);
    }

    /**
     * 获取本月第一天的日期字符串
     *
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfMonthStr() {
        return getBeginOfMonthStr(LocalDateTime.now());
    }

    /**
     * 获取本月最后一天的日期字符串
     *
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfMonthStr() {
        return getEndOfMonthStr(LocalDateTime.now());
    }

    /**
     * 获取指定日期当月第一天的日期字符串
     *
     * @param localDateTime 指定日期时间
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getBeginOfMonthStr(LocalDateTime localDateTime) {
        return getBeginOfMonthStr(localDateTime, DATETIME_PATTERN);
    }

    /**
     * 获取指定日期当月最后一天的日期字符串
     *
     * @param localDateTime 指定日期时间
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfMonthStr(LocalDateTime localDateTime) {
        return getEndOfMonthStr(localDateTime, DATETIME_PATTERN);
    }

    /**
     * 获取指定日期当月第一天的日期字符串,带日期格式化参数
     *
     * @param localDateTime 指定日期时间
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfMonthStr(LocalDateTime localDateTime, String pattern) {
        return format(localDateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0), pattern);
    }

    /**
     * 获取指定日期当月最后一天的日期字符串,带日期格式化参数
     *
     * @param localDateTime 指定日期时间
     * @param pattern       日期时间格式
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfMonthStr(LocalDateTime localDateTime, String pattern) {
        return format(localDateTime.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59), pattern);
    }

    /**
     * 获取本周第一天的日期字符串
     *
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfWeekStr() {
        return getBeginOfWeekStr(LocalDateTime.now());
    }

    /**
     * 获取本周最后一天的日期字符串
     *
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfWeekStr() {
        return getEndOfWeekStr(LocalDateTime.now());
    }

    /**
     * 获取指定日期当周第一天的日期字符串,这里第一天为周一
     *
     * @param localDateTime 指定日期时间
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfWeekStr(LocalDateTime localDateTime) {
        return getBeginOfWeekStr(localDateTime, DATETIME_PATTERN);
    }

    /**
     * 获取指定日期当周最后一天的日期字符串,这里最后一天为周日
     *
     * @param localDateTime 指定日期时间
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfWeekStr(LocalDateTime localDateTime) {
        return getEndOfWeekStr(localDateTime, DATETIME_PATTERN);
    }

    /**
     * 获取指定日期当周第一天的日期字符串,这里第一天为周一,带日期格式化参数
     *
     * @param localDateTime 指定日期时间
     * @param pattern       日期时间格式
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfWeekStr(LocalDateTime localDateTime, String pattern) {
        return format(localDateTime.with(DayOfWeek.MONDAY).withHour(0).withMinute(0).withSecond(0), pattern);
    }

    /**
     * 获取指定日期当周最后一天的日期字符串,这里最后一天为周日,带日期格式化参数
     *
     * @param localDateTime 指定日期时间
     * @param pattern       日期时间格式
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfWeekStr(LocalDateTime localDateTime, String pattern) {
        return format(localDateTime.with(DayOfWeek.SUNDAY).withHour(23).withMinute(59).withSecond(59), pattern);
    }

    /**
     * 获取今天开始时间的日期字符串
     *
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfDayStr() {
        return getBeginOfDayStr(LocalDateTime.now());
    }

    /**
     * 获取今天结束时间的日期字符串
     *
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfDayStr() {
        return getEndOfDayStr(LocalDateTime.now());
    }

    /**
     * 获取指定日期开始时间的日期字符串
     *
     * @param localDateTime 指定日期时间
     * @return String 格式：yyyy-MM-dd 00:00:00
     */
    public static String getBeginOfDayStr(LocalDateTime localDateTime) {
        return getBeginOfDayStr(localDateTime, DATETIME_PATTERN);
    }

    /**
     * 获取指定日期结束时间的日期字符串
     *
     * @param localDateTime 指定日期时间
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfDayStr(LocalDateTime localDateTime) {
        return getEndOfDayStr(localDateTime, DATETIME_PATTERN);
    }

    /**
     * 获取指定日期开始时间的日期字符串,带日期格式化参数
     *
     * @param localDateTime 指定日期时间
     * @param pattern       日期时间格式
     * @return String 格式：yyyy-MM-dd HH:mm:ss
     */
    public static String getBeginOfDayStr(LocalDateTime localDateTime, String pattern) {
        return format(localDateTime.withHour(0).withMinute(0).withSecond(0), pattern);
    }

    /**
     * 获取指定日期结束时间的日期字符串,带日期格式化参数
     *
     * @param localDateTime 指定日期时间
     * @param pattern       日期时间格式
     * @return String 格式：yyyy-MM-dd 23:59:59
     */
    public static String getEndOfDayStr(LocalDateTime localDateTime, String pattern) {
        return format(localDateTime.withHour(23).withMinute(59).withSecond(59), pattern);
    }

    /**
     * 切割日期。按照周期切割成小段日期段。例如： <br>
     *
     * @param startDate 开始日期（yyyy-MM-dd）
     * @param endDate   结束日期（yyyy-MM-dd）
     * @param period    周期（天，周，月，年）
     * @return 切割之后的日期集合
     * <li>startDate="2019-02-28",endDate="2019-03-05",period="day"</li>
     * <li>结果为：[2019-02-28, 2019-03-01, 2019-03-02, 2019-03-03, 2019-03-04, 2019-03-05]</li><br>
     * <li>startDate="2019-02-28",endDate="2019-03-25",period="week"</li>
     * <li>结果为：[2019-02-28,2019-03-06, 2019-03-07,2019-03-13, 2019-03-14,2019-03-20,
     * 2019-03-21,2019-03-25]</li><br>
     * <li>startDate="2019-02-28",endDate="2019-05-25",period="month"</li>
     * <li>结果为：[2019-02-28,2019-02-28, 2019-03-01,2019-03-31, 2019-04-01,2019-04-30,
     * 2019-05-01,2019-05-25]</li><br>
     * <li>startDate="2019-02-28",endDate="2020-05-25",period="year"</li>
     * <li>结果为：[2019-02-28,2019-12-31, 2020-01-01,2020-05-25]</li><br>
     */
    public static List<String> listDateStrs(String startDate, String endDate, String period) {
        List<String> result = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        LocalDate end = LocalDate.parse(endDate, dateTimeFormatter);
        LocalDate start = LocalDate.parse(startDate, dateTimeFormatter);
        LocalDate tmp = start;
        switch (period) {
            case DAY:
                while (start.isBefore(end) || start.isEqual(end)) {
                    result.add(start.toString());
                    start = start.plusDays(1);
                }
                break;
            case WEEK:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    if (tmp.plusDays(6).isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + tmp.plusDays(6));
                    }
                    tmp = tmp.plusDays(7);
                }
                break;
            case MONTH:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    LocalDate lastDayOfMonth = tmp.with(TemporalAdjusters.lastDayOfMonth());
                    if (lastDayOfMonth.isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + lastDayOfMonth);
                    }
                    tmp = lastDayOfMonth.plusDays(1);
                }
                break;
            case YEAR:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    LocalDate lastDayOfYear = tmp.with(TemporalAdjusters.lastDayOfYear());
                    if (lastDayOfYear.isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + lastDayOfYear);
                    }
                    tmp = lastDayOfYear.plusDays(1);
                }
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getLocalDateTimeStr());
        System.out.println(getLocalDateStr());
        System.out.println(getLocalTimeStr());
        System.out.println(getDayOfWeekStr());
        System.out.println(getDayOfWeekStr(LocalDate.now()));
        System.out.println(getDayOfWeekStr2(LocalDate.now()));

        System.out.println("========");
        System.out.println(format(LocalDate.now(), UNSIGNED_DATE_PATTERN));

        System.out.println("========");
        System.out.println(parseLocalDateTime("2020-12-13 11:14:12", DATETIME_PATTERN));
        System.out.println(parseLocalDate("2020-12-13", DATE_PATTERN));

        System.out.println("========");
        System.out.println(plus(LocalDateTime.now(), 3, ChronoUnit.HOURS));
        System.out.println(minus(LocalDateTime.now(), 4, ChronoUnit.DAYS));

        System.out.println("========");
        System.out.println(between(LocalDateTime.now(), parseLocalDateTime("2020-12-12 12:03:12", DATETIME_PATTERN), ChronoUnit.MINUTES));
        System.out.println(between(LocalDate.now(), parseLocalDate("2021-12-12", DATE_PATTERN), ChronoUnit.WEEKS));

        System.out.println("========");
        System.out.println(getBeginOfYearStr());
        System.out.println(getBeginOfYearStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN)));
        System.out.println(getBeginOfYearStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN), UNSIGNED_DATETIME_PATTERN));

        System.out.println(getEndOfYearStr());
        System.out.println(getEndOfYearStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN)));
        System.out.println(getEndOfYearStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN), UNSIGNED_DATETIME_PATTERN));

        System.out.println("========");
        System.out.println(getBeginOfMonthStr());
        System.out.println(getBeginOfMonthStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN)));
        System.out.println(getBeginOfMonthStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN), UNSIGNED_DATETIME_PATTERN));

        System.out.println(getEndOfMonthStr());
        System.out.println(getEndOfMonthStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN)));
        System.out.println(getEndOfMonthStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN), UNSIGNED_DATETIME_PATTERN));

        System.out.println("========");
        System.out.println(getBeginOfWeekStr());
        System.out.println(getBeginOfWeekStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN)));
        System.out.println(getBeginOfWeekStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN), UNSIGNED_DATETIME_PATTERN));

        System.out.println(getEndOfWeekStr());
        System.out.println(getEndOfWeekStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN)));
        System.out.println(getEndOfWeekStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN), UNSIGNED_DATETIME_PATTERN));

        System.out.println("========");
        System.out.println(getBeginOfDayStr());
        System.out.println(getBeginOfDayStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN)));
        System.out.println(getBeginOfDayStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN), UNSIGNED_DATETIME_PATTERN));

        System.out.println(getEndOfDayStr());
        System.out.println(getEndOfDayStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN)));
        System.out.println(getEndOfDayStr(parseLocalDateTime("2021-12-12 12:03:12", DATETIME_PATTERN), UNSIGNED_DATETIME_PATTERN));

        System.out.println("========");
        List<String> dateStrs = listDateStrs("2019-01-30", "2020-12-13", YEAR);
        for (String dateStr : dateStrs) {
            System.out.println(dateStr);
        }

        System.out.println("========");
        List<String> dateStrs1 = listDateStrs("2019-01-30", "2020-12-13", MONTH);
        for (String dateStr : dateStrs1) {
            System.out.println(dateStr);
        }

        System.out.println("========");
        List<String> dateStrs2 = listDateStrs("2020-12-01", "2020-12-13", DAY);
        for (String dateStr : dateStrs2) {
            System.out.println(dateStr);
        }
    }

}