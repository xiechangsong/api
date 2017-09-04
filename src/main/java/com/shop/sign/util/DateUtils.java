package main.java.com.shop.sign.util;


import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Date;

import static org.apache.commons.lang3.time.DateUtils.parseDate;


/**
 * 日期时间工具类
 * 
 * @author sunaolin
 * 
 */
public abstract class DateUtils {

    /**
     * 使用默认的时间格式进行格式化日期时间
     * 
     * @param date 日期时间
     * 
     * @return 返回格式化后的字符串
     */
    public static String format(Date date) {

        return format(date, SPayConfig.DATE_TIME_FORMAT);
    }

    /**
     * 格式化日期时间
     * 
     * @param date 日期时间
     * 
     * @param pattern 格式字符串
     * 
     * @return 返回格式化后的字符串
     */
    public static String format(Date date, String pattern) {
        Validate.notNull(date);
        Validate.notEmpty(pattern);

        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 把{@code String}格式的日期类型转换成{@code Date}类型
     * 
     * @param date {@code String}格式的日期
     * 
     * @return 返回{@code Date}类型日期
     * 
     * @throws ParseException 解析异常
     */
    public static Date parse(String date) throws ParseException {

        return parse(date, SPayConfig.DATE_TIME_FORMAT);
    }

    /**
     * 把{@code String}格式的日期类型转换成{@code Date}类型
     * 
     * @param date {@code String}格式的日期
     * 
     * @param pattern 日期格式
     * 
     * @return 返回{@code Date}类型日期
     * 
     * @throws ParseException 解析异常
     */
    public static Date parse(String date, String pattern) throws ParseException {
        Validate.notEmpty(date);
        Validate.notEmpty(pattern);

        return parseDate(date, new String[] { pattern });
    }
}