package org.sc.utils.desensitization;

/**
 * @author shen chen
 * @description 脱敏类型枚举
 * @date 2023/4/27 16:26
 */
public enum DesensitizeTypeEnum {

    ID_CARD(1, "身份证号码", 3, 4),
    MOBILE(2, "手机号码", 3, 2),
    TELEPHONE(3, "电话", 3, 2),
    EMAIL(4, "电子邮件", -1, -1),
    BANK_CARD(5, "银行卡号", 0, 4),
    VERIFY_CODE(6, "验证码", 0, 0),
    // 姓氏脱敏
    LAST_NAME(7, "姓氏", -1, -1),
    // 名字脱敏
    FIRST_NAME(8, "名字", -1, -1),
    // 车牌号脱敏
    CAR_NO(9, "车牌号", 2, 2),
    // 车架号脱敏
    CAR_FRAME_NO(10, "车架号", 3, 4)

    ;

    private int type;

    private String desc;
    /**
     * 前面保留几位
     */
    private int frontSize;

    /**
     * 后面保留几位
     */
    private int endSize;

    public int getFrontSize() {
        return frontSize;
    }

    public int getEndSize() {
        return endSize;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    DesensitizeTypeEnum(int type, String desc, int frontSize, int endSize) {
        this.type = type;
        this.desc = desc;
        this.frontSize = frontSize;
        this.endSize = endSize;
    }

}
