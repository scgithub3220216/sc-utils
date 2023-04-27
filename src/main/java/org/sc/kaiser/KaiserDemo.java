package org.sc.kaiser;


/**
 * @author shen chen
 * @description 凯撒加密
 * @date 2023/4/24 14:19
 */
public class KaiserDemo {
    public static void main(String[] args) {
        // 定义原文
        String msg = "hello world!";
        // key
        int key = 3;
        // 加密
        String encrypt = encrypt(msg, key);
        System.out.println("encrypt = " + encrypt);

        System.out.println("====================");

        // 解密
        String decrypt = decrypt(encrypt, key);
        System.out.println("decrypt = " + decrypt);

    }

    public static String encrypt(String artile, int key) {
        char[] chars = artile.toCharArray();
        char[] cryptoMsg = new char[chars.length];
        // 加密
        for (int i = 0; i < chars.length; i++) {
            cryptoMsg[i] = (char) (chars[i] + key);
        }
        return String.valueOf(cryptoMsg);
    }

    public static String decrypt(String input, int key) {
        char[] chars = input.toCharArray();
        char[] deyptoMsg = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            deyptoMsg[i] = (char) (chars[i] - key);
        }
        return String.valueOf(deyptoMsg);
    }
}
