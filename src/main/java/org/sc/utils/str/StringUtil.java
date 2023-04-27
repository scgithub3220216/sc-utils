package org.sc.utils.str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shen chen
 * @description 自定义的字符串处理工具类, 继承 lang3
 * @date 2023/4/27 18:51
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {

    public static void main(String[] args) {
        String str = "  ssfs   gdg" +
                "jjionnl\r ,,\n;;''[　]［　］＇＇；；ｓｔｒ ";
        System.out.println("str = " + str);
        String s = removeSpaces(str);
        System.out.println("s = " + s);
    }

    /**
     * 去除 所有的空格 回车 换行 并把其中的符号 从全角 转为 半角
     *
     * @param source 待处理的文本
     * @return 处理后的文本
     */
    public static String removeSpaces(String source) {
        if (isBlank(source)) {
            return source;
        }
        // 符号转为半角
        String dbc = toDBC(source);
        // 替换 换行空格
        Pattern p = Pattern.compile("[\\s]"); // 匹配空格
        Matcher m = p.matcher(dbc);
        return m.replaceAll(EMPTY);
    }

    /**
     * 转半角的函数(DBC case)
     * 全角空格为12288，半角空格为32
     * 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
     *
     * @param input 任意字符串
     * @return 半角字符串
     */
    public static String toDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                //全角空格为12288，半角空格为32
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                //其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);

    }

    /**
     * 转全角的方法(SBC case)
     * 全角空格为12288，半角空格为32
     * 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
     *
     * @param input 任意字符串
     * @return 半角字符串
     */
    public static String toSBC(String input) {
        //半角转全角：
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 32) {
                c[i] = (char) 12288;
                continue;
            }
            if (c[i] < 127)
                c[i] = (char) (c[i] + 65248);
        }
        return new String(c);
    }
}
