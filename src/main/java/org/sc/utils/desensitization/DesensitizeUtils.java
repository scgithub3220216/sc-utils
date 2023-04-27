package org.sc.utils.desensitization;

import org.apache.commons.lang3.StringUtils;
import org.sc.utils.Constants;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shen chen
 * @description 脱敏工具类
 * 支持 手机号码  银行卡号  邮箱 脱敏
 * @date 2023/4/27 16:26
 */
public class DesensitizeUtils {

    private static final String EMAIL_REGEX = "(?<=)[\\w\\-]*(?=[\\w\\-]{2}\\@)";

    private static final String NUMBER_REGEX = "[0-9]+";

    public static void main(String[] args) {
        String str = "欧阳娜娜";
        String s = desensitizeForName(str, 2);
        System.out.println("s = " + s);
    }

    /**
     * 获取脱敏的值
     *
     * @param str                 字符串值
     * @param desensitizeTypeEnum 脱敏规则
     * @return 脱敏后的值
     */
    public String getValueByDesensitizeTypeEnum(String str, DesensitizeTypeEnum desensitizeTypeEnum) {

        if (StringUtils.isBlank(str) || Objects.isNull(desensitizeTypeEnum)) {
            return str;
        }
        // 邮箱
        if (DesensitizeTypeEnum.EMAIL.equals(desensitizeTypeEnum)) {
            return desensitizeForEmail(str);
        }
        // 姓氏脱敏
        if (DesensitizeTypeEnum.LAST_NAME.equals(desensitizeTypeEnum)) {
            return desensitizeForName(str, 1);
        }
        // 名字脱敏
        if (DesensitizeTypeEnum.FIRST_NAME.equals(desensitizeTypeEnum)) {
            return desensitizeForName(str, 2);
        }

        return desensitizeNumber(str, desensitizeTypeEnum.getFrontSize(), desensitizeTypeEnum.getEndSize());

    }


    /**
     * 脱敏字符串中的数字
     * 如 aaaxxx22232323 -> aaaxxx********
     *
     * @param content 内容
     * @return 数字脱敏后的内容
     */
    public static String doDesensitizeNumberForContent(String content) {
        if (StringUtils.isBlank(content)) {
            return StringUtils.EMPTY;
        }
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        StringBuffer sb = new StringBuffer();
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {

            String regexStr = matcher.group();
            // 手机号长度
            if (StringUtils.isNotBlank(regexStr)) {
                matcher.appendReplacement(sb, getAsteriskByNumber(regexStr.length()));
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 将内容根据正则匹配到的内容脱敏
     *
     * @param content 内容
     * @param regex   正则
     * @return 脱敏后的内容
     */
    public static String doDesensitizeNumberForContent(String content, String regex) {
        if (StringUtils.isBlank(content) || StringUtils.isBlank(regex)) {
            return StringUtils.EMPTY;
        }

        Pattern pattern = Pattern.compile(regex);
        StringBuffer sb = new StringBuffer();
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            // 手机号长度
            if (StringUtils.isNotBlank(matcher.group())) {
                matcher.appendReplacement(sb, getAsteriskByNumber(matcher.group().length()));
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 根据长度获取星号
     *
     * @param length 长度
     * @return ***
     */
    private static String getAsteriskByNumber(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    /**
     * 脱敏
     *
     * @param numberNo 脱敏原始串
     * @param start    开始保留几位
     * @param end      后保留几位
     * @return 脱敏串
     */
    public static String desensitizeNumber(String numberNo, int start, int end) {
        if (StringUtils.isEmpty(numberNo)) {
            return StringUtils.EMPTY;
        }
        if (0 > start || 0 > end) {
            return numberNo;
        }
        numberNo = numberNo.trim();
        // 卡号小于最小长度 直接返回 不
        return (start + end + 1) > numberNo.length() ? numberNo
                : numberNo.replaceAll(MessageFormat.format(Constants.DESENSITIZATE_REGEX_VALUE, start, end), "*");
    }

    /**
     * 邮箱进行脱敏 *******bb@hotmail.com
     *
     * @param email 邮箱
     * @return 脱敏后的邮箱
     */
    public static String desensitizeForEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return StringUtils.EMPTY;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        while (matcher.find()) {
            email = email.replaceAll(matcher.group(), desensitizeNumber(matcher.group(), 0, 0));
        }
        return email;
    }

    /**
     * 姓名脱敏
     *
     * @param fullName 王小五
     * @param type     1:姓氏脱敏 （*小五）
     *                 2 姓名脱敏 (王**)
     * @return
     */
    public static String desensitizeForName(String fullName, int type) {
        if (StringUtils.isBlank(fullName)) {
            return StringUtils.EMPTY;
        }
        if (type == 1) {
            return desensitizeForFirstName(fullName);
        }
        return desensitizeForLastName(fullName);
    }

    private static String desensitizeForFirstName(String fullName) {
        int offset = Constants.ONE;
        // 复姓
        if (fullName.length() > Constants.THREE) {
            offset = Constants.TWO;
        }
        String name = fullName.substring(offset);
        return StringUtils.leftPad(name, StringUtils.length(fullName), "*");
    }

    private static String desensitizeForLastName(String fullName) {
        int offset = Constants.ONE;
        // 复姓
        if (fullName.length() > Constants.THREE) {
            offset = Constants.TWO;
        }
        String name = StringUtils.left(fullName, offset);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }

}
