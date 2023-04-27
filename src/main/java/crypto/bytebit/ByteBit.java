package crypto.bytebit;

/**
 * 360 Financial Copyright
 *
 * @author shen chen
 * @description byte 和 bit 的关系
 * @date 2023/4/24 15:55
 */
public class ByteBit {
    public static void main(String[] args) {
        /**
         * 根据编码的格式不一样, 对应的字节也不一样
         *  如果是UTF-8 3字节
         *       GBK   2字节
         *      英文 就无所谓编码格式 1个字节
         */
        String a = "中"; // 一个中文对应三个字节
        byte[] bytes = a.getBytes();
        // byte[] bytes = a.getBytes("GBK");
        for (byte aByte : bytes) {
            int c = aByte;
            System.out.println("c = " + c);
            String s = Integer.toBinaryString(c);
            System.out.println("s = " + s);
        }

    }
}
