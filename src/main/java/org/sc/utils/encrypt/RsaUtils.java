package org.sc.utils.encrypt;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author shen chen
 * @description 非对称加密 Rsa 工具类
 * @date 2023/4/25 17:14
 */
public class RsaUtils {

    /**
     * 公钥  可从配置文件中读取
     */
    private static final String PUBLIC_KEY_STRING = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBFMwjzYohSxwvAtK/SuR31aJZzhe8t8B2P9oY\n" +
            "v4GNg+bU/OKfbd/LuW9phu89xAnqAkQpIqeFgqmFTmY4tI89sh7NwRVUMSNv9dlJ/KgDUiaoKthx\n" +
            "wqJ2QsHWgW8n/9gaFVvQ+HlO9cCUy8JUDaluOCjUpRbpx7+HKw2Ag3qsVQIDAQAB";

    /**
     * 私钥
     */
    private static final String PRIVATE_KEY_STRING = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIEUzCPNiiFLHC8C0r9K5HfVolnO\n" +
            "F7y3wHY/2hi/gY2D5tT84p9t38u5b2mG7z3ECeoCRCkip4WCqYVOZji0jz2yHs3BFVQxI2/12Un8\n" +
            "qANSJqgq2HHConZCwdaBbyf/2BoVW9D4eU71wJTLwlQNqW44KNSlFunHv4crDYCDeqxVAgMBAAEC\n" +
            "gYBArO///Gt6dQzhDTQVPuwskvEuuBGysAsR9LpNbh72jiFplG/kXAQnKnmFUWOr+f7RrmMCjWeM\n" +
            "gMR5k6eqP+YI1yrRW7Z6fD8wbEdhCZWnBWCydryQ5tM81cj6aTx/8NgDQTBuUJ9MN8uHO5+p8Sux\n" +
            "lxxa4eifvULc7j8H0QSFnQJBAM0LOVDKHaEjPsiusyDkY/itUWbs+n6gLtvqSWrJQlxzs5xAuFyg\n" +
            "5ylu1GNdMRc1JwZO2BjSr0b2QGm9ClxjblsCQQChKN/ojLbbZDPsv7XXIrzdgLsY9494LeCUOXXq\n" +
            "tcK7hXxw3CuFizO8MvL016IcPqKW+ZWHRehNU8+xRy8HVa8PAkAq8bTZZNt7ykP2CBDgTLVbegFY\n" +
            "iz2Tk7z8tj8WLHzHnDv799olHFYN6XZ2MSh88dbwjUbZPBcVx7GJ89vdqb2NAkEAho9aZREYnJZN\n" +
            "xJ9NdRPMHiYeEfqiD/Y+TYSssAyTS39pJ9KthBN2Xu0rbsOc13h0yRobf5cfH3GbOKn22mjwgQJB\n" +
            "AKyzkySweCExnjgyZfgFZtlC0POcLQwGL/SDimG+s9Em1A0UVlDBXrxD8rPb1sNd5m/bPQ61MACN\n" +
            "gQsvAGFsQ24=";

    /**
     * 填充模式 等同与  RSA === RSA/ECB/PKCS1Padding
     */
    private static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    /**
     * 算法
     */
    private static final String ALGORITHM = "RSA";

    public static void main(String[] args) throws Exception {
        // 生成 公钥私钥
        // generateSecretKey();

        String input = "明文";
        // 加密
        String cipherText = encrypt(input);
        System.out.println("密文 = " + cipherText);

        //  公钥解密
        String decrypt = decrypt(cipherText);
        System.out.println("解密后的明文 = " + decrypt);
    }

    public static void generateSecretKey() throws NoSuchAlgorithmException {
        // 创建秘钥对生成器对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        // 生成秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 生成公钥
        PublicKey publicKey = keyPair.getPublic();
        // 生成私钥
        PrivateKey privateKey = keyPair.getPrivate();
        // 获取公钥字节数组
        byte[] publicKeyEncoded = publicKey.getEncoded();
        // 获取私钥字节数组
        byte[] privateKeyEncoded = privateKey.getEncoded();

        String publicKeyString = Base64.encode(publicKeyEncoded);
        String privateKeyString = Base64.encode(privateKeyEncoded);
        System.out.println("publicKeyString = " + publicKeyString);
        System.out.println("privateKeyString = " + privateKeyString);
    }

    /**
     * 加密
     *
     * @param input 明文
     * @return 密文
     */
    public static String encrypt(String input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        PrivateKey privateKey = getPrivateKey();
        // 创建加密对象
        Cipher cipher = getCipher();
        // 初始化加密
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        // 私钥加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        return Base64.encode(bytes);
    }

    /**
     * 加密
     *
     * @param input         明文
     * @param privateKeyStr 私钥
     * @return 密文
     */
    public static String encrypt(String input, String privateKeyStr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        PrivateKey privateKey = getPrivateKey(privateKeyStr);
        // 创建加密对象
        Cipher cipher = getCipher();
        // 初始化加密
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        // 私钥加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        return Base64.encode(bytes);
    }

    /**
     * 解密
     *
     * @param cipherText 密文
     * @return 明文
     */
    public static String decrypt(String cipherText) throws NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {
        PublicKey publicKey = getPublicKey();
        Cipher cipher = getCipher();
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(Base64.decode(cipherText));
        return new String(bytes);
    }

    /**
     * 解密
     *
     * @param cipherText   密文
     * @param publicKeyStr 公钥
     * @return 密文
     */
    public static String decrypt(String cipherText, String publicKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {
        PublicKey publicKey = getPublicKey(publicKeyStr);
        Cipher cipher = getCipher();
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(Base64.decode(cipherText));
        return new String(bytes);
    }

    private static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance(TRANSFORMATION);
    }

    /**
     * 获取公钥
     *
     * @return 公钥对象
     */
    public static PublicKey getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 获取密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        // 构建密钥规范 进行Base64解码
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decode(PUBLIC_KEY_STRING));
        // 生成公钥
        return keyFactory.generatePublic(spec);
    }

    /**
     * 获取公钥
     *
     * @param publicKeyStr 公钥字符串
     * @return 公钥对象
     */
    public static PublicKey getPublicKey(String publicKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 获取密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        // 构建密钥规范 进行Base64解码
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decode(publicKeyStr));
        // 生成公钥
        return keyFactory.generatePublic(spec);
    }

    /**
     * 获取私钥
     *
     * @return 私钥对象
     */
    public static PrivateKey getPrivateKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
        // 获取密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        // 构建密钥规范 进行Base64解码
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.decode(PRIVATE_KEY_STRING));
        // 生成私钥
        return keyFactory.generatePrivate(spec);
    }

    /**
     * 获取私钥
     *
     * @param privateKeyStr 私钥字符串
     * @return 私钥对象
     */
    public static PrivateKey getPrivateKey(String privateKeyStr) throws InvalidKeySpecException, NoSuchAlgorithmException {
        // 获取密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        // 构建密钥规范 进行Base64解码
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.decode(privateKeyStr));
        // 生成私钥
        return keyFactory.generatePrivate(spec);
    }
}
