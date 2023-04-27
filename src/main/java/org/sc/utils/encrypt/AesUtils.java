package org.sc.utils.encrypt;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author shen chen
 * @description aes加密
 * @date 2023/4/24 16:32
 */
public class AesUtils {
    /**
     * Aes 算法的秘钥必须是16个字节
     */
    private static final String AES_KEY = "$w3A567#1.34d67&";
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";


    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String crypto = encrypt("这是待加密的原文", ALGORITHM, TRANSFORMATION, AES_KEY);
        System.out.println("加密 = " + crypto);
        // 解密
        String decryptDES = decrypt(crypto, ALGORITHM, TRANSFORMATION, AES_KEY);
        System.out.println("解密 = " + decryptDES);
    }

    /**
     * 加密 使用默认的填充模式   ECB/PKCS5Padding
     *
     * @param input          明文
     * @param algorithm      获取密钥的算法  AES/DES
     * @param transformation 获取Cipher对象的算法
     * @param securityKey    秘钥
     * @return 密文
     */
    public static String encrypt(String input, String algorithm, String transformation, String securityKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 获取加密对象  参数表示用什么类型加密
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE, algorithm, transformation, securityKey);
        // 进行加密
        byte[] binaryData = cipher.doFinal(input.getBytes());
        // 使用 base64 是为了可读性更强
        return Base64.encode(binaryData);
    }

    /**
     * 解密
     *
     * @param input          密文
     * @param algorithm      获取密钥的算法  AES/DES
     * @param transformation 获取Cipher对象的算法
     * @param securityKey    秘钥
     * @return 明文
     */
    public static String decrypt(String input, String algorithm, String transformation, String securityKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE, algorithm, transformation, securityKey);
        byte[] bytes = cipher.doFinal(Base64.decode(input));
        return new String(bytes);
    }

    private static Cipher getCipher(int decryptMode, String algorithm, String transformation, String securityKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        // 获取加密对象  参数表示用什么类型加密
        Cipher cipher = Cipher.getInstance(transformation);
        // 指定秘钥规则 第一个参数表示秘钥  第二个参数表示 算法
        SecretKeySpec secretKeySpec = new SecretKeySpec(securityKey.getBytes(), algorithm);

        // 对加密进行初始化 第一个参数表示模式(加密/解密) 第二个参数表示秘钥规则
        cipher.init(decryptMode, secretKeySpec);
        return cipher;
    }
}
