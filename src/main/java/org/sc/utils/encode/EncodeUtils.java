package org.sc.utils.encode;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author shen chen
 * @description 自定义的 Base64编码工具类 暂时先试用  com.sun.org.apache.xerces.internal.impl.dv.util.Base64的 方法进行编码
 * @date 2023/4/27 15:52
 */
public class EncodeUtils {


    /**
     * Base64 编码
     */
    public static String encode(byte[] bytes) {
        return Base64.encode(bytes);
    }

    /**
     * Base64 解码
     */
    public static byte[] decode(String bytes) {
        return Base64.decode(bytes);
    }
}
