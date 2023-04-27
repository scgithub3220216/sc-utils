package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 360 Financial Copyright
 *
 * @author shen chen
 * @description
 * @date 2023/4/25 11:49
 */
public class digestDigestDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 原文
        String input = "aa";
        // 算法
        String md5 = getDigest(input, "MD5");
        System.out.println("md5 = " + md5);
        String sha1 = getDigest(input, "SHA-1");
        System.out.println("sha1 = " + sha1);
        String sha256 = getDigest(input, "SHA-256");
        System.out.println("sha256 = " + sha256);
        String sha512 = getDigest(input, "SHA-512");
        System.out.println("sha512 = " + sha512);

    }

    /**
     * 获取数字摘要
     *
     * @param input     原文
     * @param algorithm 算法
     * @return 密文
     */
    public static String getDigest(String input, String algorithm) throws NoSuchAlgorithmException {
        // 获取数字摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        // 获取消息数字摘要的字节数组
        byte[] digest = messageDigest.digest(input.getBytes());
        return toHex(digest);
    }

    /**
     * 转成16进制
     */
    private static String toHex(byte[] digest) {

        // 创建对象用来拼接
        StringBuilder sb = new StringBuilder();

        for (byte b : digest) {
            // 转成 16进制
            String s = Integer.toHexString(b & 0xff);
            if (s.length() == 1) {
                // 如果生成的字符只有一个，前面补0
                s = "0" + s;
            }
            sb.append(s);
        }
        return sb.toString();
    }
}
