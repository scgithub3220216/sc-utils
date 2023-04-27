package crypto.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import crypto.rsa.RsaUtils;
import org.apache.commons.lang3.StringUtils;

import java.security.*;
import java.security.spec.InvalidKeySpecException;


/**
 * 360 Financial Copyright
 *
 * @author shen chen
 * @description 签名工具类
 * @date 2023/4/26 17:01
 */
public class SignatureUtils {

    /**
     * Signature.getInstance() 入参
     */
    public static final String MD5_WITH_RSA = "MD5withRSA";
    public static final String SHA1_WITH_RSA = "SHA1withRSA";
    public static final String SHA224_WITH_RSA = "SHA224withRSA";
    public static final String SHA256_WITH_RSA = "SHA256withRSA";
    public static final String SHA512_WITH_RSA = "SHA512withRSA";

    public static final String MD5 = "MD5";
    public static final String SHA_1 = "SHA-1";
    public static final String SHA_256 = "SHA-256";
    public static final String SHA_512 = "SHA-512";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException {
        String text = "邮件内容";

        String algorithm = SHA512_WITH_RSA;
        PrivateKey privateKey = RsaUtils.getPrivateKey();
        PublicKey publicKey = RsaUtils.getPublicKey();
        String signatureData = getSignature(text, algorithm, privateKey);
        System.out.println("signatureData = " + signatureData);
        boolean verifyFlag = verifySignature(text, algorithm, publicKey, signatureData);
        System.out.println("verifyFlag = " + verifyFlag);

        String signature = getSignature(text,SHA_1);
        System.out.println("signature = " + signature);
        boolean b = verifySignature(text, signature,SHA_1);
        System.out.println("b = " + b);
    }


    /**
     * 获取签名 默认使用 md5进行加密
     *
     * @param content 文本
     * @return 签名  会把结果转成16进制
     */
    public static String getSignature(String content) throws NoSuchAlgorithmException {
        // 获取数字摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(MD5);
        // 获取消息数字摘要的字节数组
        byte[] digest = messageDigest.digest(content.getBytes());
        return toHex(digest);
    }

    /**
     * 获取签名
     *
     * @param content   文本
     * @param algorithm 加密算法
     * @return 签名 会把结果转成16进制
     */
    public static String getSignature(String content, String algorithm) throws NoSuchAlgorithmException {
        // 获取数字摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        // 获取消息数字摘要的字节数组
        byte[] digest = messageDigest.digest(content.getBytes());
        return toHex(digest);
    }

    /**
     * 对签名进行校验
     *
     * @param content   原文
     * @param signature 签名
     * @return true 效验正确  false 效验失败
     */
    public static boolean verifySignature(String content, String signature) throws NoSuchAlgorithmException {
        // 获取数字摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(MD5);
        // 获取消息数字摘要的字节数组
        byte[] digest = messageDigest.digest(content.getBytes());
        return StringUtils.equals(signature, toHex(digest));
    }

    /**
     * 根据私钥 获取签名
     *
     * @param text       原文
     * @param algorithm  算法
     * @param privateKey 私钥
     * @return 签名
     */
    public static String getSignature(String text, String algorithm, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // 获取签名对象
        Signature signature = Signature.getInstance(algorithm);
        // 初始化签名
        signature.initSign(privateKey);
        // 传入原文
        signature.update(text.getBytes());
        // 开始签名
        byte[] sign = signature.sign();
        // 对签名数据进行 Base64 编码
        return Base64.encode(sign);
    }

    /**
     * 对签名进行校验
     *
     * @param content   原文
     * @param signature 签名
     * @param algorithm 算法
     * @return true 效验正确  false 效验失败
     */
    public static boolean verifySignature(String content, String signature, String algorithm) throws NoSuchAlgorithmException {
        // 获取数字摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        // 获取消息数字摘要的字节数组
        byte[] digest = messageDigest.digest(content.getBytes());
        return StringUtils.equals(signature, toHex(digest));
    }

    /**
     * 根据公钥 效验签名
     *
     * @param text          原文
     * @param algorithm     算法
     * @param publicKey     公钥
     * @param signatureData 签名
     * @return 数据是否被篡改
     */
    private static boolean verifySignature(String text, String algorithm, PublicKey publicKey, String signatureData) {
        boolean verify;
        try {
            // 获取签名对象
            Signature signature = Signature.getInstance(algorithm);
            // 初始化签名
            signature.initVerify(publicKey);
            // 传入原文
            signature.update(text.getBytes());
            // 效验数据
            verify = signature.verify(Base64.decode(signatureData));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return verify;
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
