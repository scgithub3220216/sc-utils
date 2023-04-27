package crypto.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import crypto.rsa.RsaUtils;

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
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException {
        String text = "邮件内容";

        String algorithm = "sha256withrsa";
        PrivateKey privateKey = RsaUtils.getPrivateKey();
        PublicKey publicKey = RsaUtils.getPublicKey();
        String signatureData = getSignature(text, algorithm, privateKey);
        System.out.println("signatureData = " + signatureData);
        boolean verifyFlag = verifySignature(text, algorithm, publicKey, signatureData);
        System.out.println("verifyFlag = " + verifyFlag);
    }

    /**
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

}
