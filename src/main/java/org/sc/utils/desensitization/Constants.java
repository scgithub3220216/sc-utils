package org.sc.utils.desensitization;



/**
 * 常量类
 *
 * @author junpeng.zou
 * @date 2020/11/4 14:50
 */
public class Constants {

    public static final String MSIE = "MSIE";
    public static final String TRIDENT = "Trident";

    private Constants() {
    }

    public static final int ONE = 1;

    public static final int NEGATIVE_ONE = -1;

    public static final long ZERO_LONG = 0L;

    public static final int TWO = 2;

    public static final String ZERO_TWO = "02";
    public static final String ZERO_ZERO = "00";
    public static final String ZERO_THREE = "03";
    public static final String ZERO_FOUR = "04";
    public static final String ZERO_ONE = "01";

    public static final int THREE = 3;


    public static final int FOUR = 4;

    public static final int FIVE = 5;

    public static final int SIX = 6;

    public static final int TWELVE = 12;

    public static final int SIXTEEN = 16;

    public static final String ONE_STR = "1";

    public static final String TWO_STR = "2";

    public static final int ZERO = 0;

    public static final String ZERO_PERCENT = "0.00%";

    public static final int DEFAULT_PAGE_SIZE = 20;

    public static final int TEN = 10;

    public static final int TWENTY = 20;

    public static final int THIRTY = 30;

    public static final int FORTY = 40;

    public static final int FIFTY = 50;

    public static final int TWO_HUNDRED_INT = 200;

    public static final Long FIVE_HUNDRED_LONG = 500L;

    public static final String PERCENT = "%";

    public static final int ONE_HUNDRED_INT = 100;
    public static final int ONE_THOUSAND_INT = 1000;

    public static final int FIVE_HUNDRED_INT = 500;
    /**
     * 七天的秒数
     */
    public static final int SEVEN_DAY_SECOND = 604800;

    public static final String MONTH_CHINESE = "月";

    public static final String DAY_CHINESE = "日";


    /**
     * 产品类型 cap36
     */
    public static final String PRODUCT_TYPE_CAP = "CAP36";

    /**
     * 周转金
     */
    public static final String PRODUCT_CODE_JIETIAO_ZJJ = "ZZJ";

    /**
     * 斜杠符号
     */
    public static final String SLASH_SYMBOL = "/";

    /**
     * 反斜杠符号
     */
    public static final String RESERVE_SLASH_SYMBOL = "\\";

    /**
     * 与符号
     */
    public static final String AND_SYMBOL = "&";

    public static final String VERTICAL_SYMBOL = "\\|";
    public static final String VERTICAL_SYMBOL_ONE = "|";

    /**
     * Y
     */
    public static final String Y = "Y";

    /**
     * 是
     */
    public static final String Y_ZH = "是";
    /**
     * N
     */
    public static final String N = "N";

    /**
     * 否
     */
    public static final String N_ZH = "否";

    /**
     * 横杠符号
     */
    public static final String HORIZONTAL_BAR = "-";

    /**
     * 双杠符号
     */
    public static final String D_HORIZONTAL_BAR = "--";
    /**
     * 分号分隔符
     */
    public static final String SEMICOLON = ";";

    public static final String SEMICOLON_NEW_LING = ";\\n";
    public static final String NEW_LINE = "\\n";

    public static final String SPECIAL_SYMBOL = "#";

    public static final String AT_SYMBOL = "@";

    public static final String GLOBAL = "global";

    public static final String TIME = "time";

    /**
     * 逗号分隔符号
     */
    public static final String COMMA_SYMBOL = ",";

    /**
     * 等号
     */
    public static final String EQUALS_SIGN = "=";

    /**
     * 授信子状态  （审核中-人工审核）
     */
    public static final String MANUAL = "MANUAL";

    /**
     * 授信子状态  （审核中-补件中）
     */
    public static final String PTING = "PTING";

    /**
     * apr状态
     */
    public static final String APR_MANUAL = "APR_MANUAL";

    /**
     * 借款申请状态-放款通过
     */
    public static final String APPLY_SUCCESS_STATUS = "DS";

    /**
     * APS是审核通过
     */
    public static final String APS_STATUS = "APS";

    /**
     * 内部员工标识
     */
    public static final String INTERNAL_STAFF_SYMBOL = "4401";

    /**
     * http请求成功状态码
     */
    public static final String HTTP_SUCCESS = "200";

    /**
     * 借条还款渠道
     */
    public static final String JT_REPAYMENT_CHANNEL = "JT_repayment_Channel";
    /**
     * api渠道
     */
    public static final String API = "api";
    public static final String API_DEFAULT_VALUE = "api渠道还款";
    /**
     * 借条 还款类型
     */
    public static final String REPAYMENT_TYPE = "rpyTransType";
    /**
     * 微零花 还款类型
     */
    public static final String WLH_REPAYMENT_TYPE = "Wlh_Repay_Type";
    /**
     * 借条 还款交易类型
     */
    public static final String REPAYMENT_RESULT = "refundTransResult";
    /**
     * 扣款通道
     */
    public static final String REFUND_TRANS_CHANNEL = "refundTransChannel";

    /**
     * 还款成功状态
     */
    public static final String REPAY_SUCCESS = "S";

    public static final String SUCCESS = "SUCCESS";

    public static final String FAIL = "FAIL";

    /**
     * 非还款成功状态记录
     */
    public static final String NOT_REPAY_SUCCESS = "N";


    /**
     * 产品定价 还款方式字典类型rpyType.
     */
    public static final String DICT_TYPE_RPYTYPE = "rpyType";

    public static final String PRO_PRICE_NEW_LOGIC_REY_TYPE = "proPrice_newLogic_reyType";

    /**
     * 等本等息（分期）
     */
    public static final String EQUAL_INTEREST = "03";


    /**
     * 是锁期
     */
    public static final String IS_LOCK_YES = "Y";

    /**
     * 不是锁期
     */
    public static final String IS_LOCK_NO = "N";

    public static final String DESENSITIZATE_REGEX_VALUE = "(?<=.'{'{0}'}')(\\w|\\W)(?=.'{'{1}'}')";


    public static final String PACKAGE_SERVICE = ".service.";

    public static final Integer THREE_HUNDRED_INT = 300;
    public static final String ONT_HUNDRED_STR = "100";
    public static final int ONT_HUNDRED_INT = 100;

    /**
     * 北京人群包接口请求的userNo参数的键
     */
    public static final String HTTP_USER_NO_FIELD_KEY = "userno";

    /**
     * 结清状态 2
     */
    public static final String SETTLE_STATE = "2";
    /**
     * 借条
     */
    public static final String JIETIAO = "jieTiao";
    /**
     * 借蛙
     */
    public static final String JIEWA = "jieWa";
    /**
     * 智信
     */
    public static final String ZHIXIN = "zhiXin";

    /**
     * 分期商城
     */
    public static final String MALL = "mall";

    /**
     * 新微零花
     */
    public static final String NEWWLH = "newWlh";


    /**
     * 老微零花
     */
    public static final String WLH = "wlh";

    /**
     * 鱼快ETC
     */
    public static final String ETC = "etc";

    /**
     * 重审记录
     */
    public static final String RETRIAL = "360RETRIAL";


    /**
     * 整笔打折类型枚举
     */
    public static final String LUMP_DISCOUNT = "0014";

    /**
     * 公司名称
     */
    public static final String COMPANY_QIYU = "QIYU";
    /**
     * M0 逾期状态
     */
    public static final String M_ZERO = "M0";

    public static final String ZERO_STRING = "0";
    public static final String ONE_STRING = "1";

    public static final String TWO_STRING = "2";

    public static final String THREE_STRING = "3";

    public static final String FOUR_STRING = "4";

    public static final String LOANCYCLE_FORMAT = "{0}-{1}";

    /**
     * 日期格式yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期yyyy-MM-dd格式
     */
    public static final String YYYYMMDD = "yyyy-MM-dd";
    /**
     * 日期yyyy-MM-dd格式
     */
    public static final String YYYYMM = "yyyy-MM";

    /**
     * 不是锁期
     */
    public static final String FLAG_F = "F";
    /**
     * 智信产品信息键值分隔符
     */
    public static final String ZHI_XIN_PRODUCT_KEY = "%s#%s#%s";
    /**
     * 智信产品信息键值分隔符
     */
    public static final String ZHI_XIN_PRODUCT_REDIS_KEY = "zhiXinProductRedisKey";
    /**
     * 商城还款类型
     */
    public static final String MALL_REPAY_TYPE = "360MALL_chargeType";
    /**
     * 商城还款银行
     */
    public static final String BANK_NAME = "360MALL_BankType";
    /**
     * 商城资金通道
     */
    public static final String CHANNEL_TYPE = "360MALL_channelType";
    /**
     * 商城还款结果
     */
    public static final String REPAY_RESULT = "360MALL_repayStatus";

    public static final String BIZ_PLATFORM = "BizPlatform";

    public static final String DEFAULT = "DEFAULT";

    public static final String MALL_REFUND_TYPE = "360MALL_refundType";
    /**
     * 未入账订单类型
     */
    public static final String NOT_CREDITED_ORDER = "notCreditedOrder";
    /**
     * 未成功订单类型
     */
    public static final String NOT_SUCCESS_ORDER = "notSuccessOrder";

    public static final String WLH_COUPON_TYPE = "wlh_coupon_type";

    public static final String BEGIN = "begin";
    public static final String END = "end";

    public static final String LEAK = "leak";
    public static final String NOT_DEAL = "notDeal";
    public static final String QUEUE_LEAK = "queueLeak";
    public static final String DEALING = "dealing";
    /**
     * 七陌重复来电计数
     */
    public static final String QI_MOO_REPEAT_COUNT = "call_event_repeat_call_inc_%s";
    /**
     * 七陌来电事件模板次数限制
     */
    public static final String REDIS_CALL_EVENT_SMS_TEMPLATE_LIMIT_INC = "call_event_sms_template_limit_inc_%s";
    /**
     * 七陌来电事件模板频次限制
     */
    public static final String REDIS_CALL_EVENT_SMS_TEMPLATE_LIMIT_NUM = "call_event_sms_template_limit_num_%s";
    /**
     * 七陌来电事件短信模板有效时间
     */
    public static final String REDIS_CALL_EVENT_SMS_TEMPLATE_EXPIRE_TIME = "call_event_sms_template_expire_time_%s";
    /**
     * 七陌来电事件全局频次限制计数
     */
    public static final String REDIS_CALL_EVENT_SMS_GLOBAL_LIMIT_INC = "call_event_sms_global_limit_inc_%s";
    /**
     * 七陌来电事件全局频次限制
     */
    public static final String REDIS_CALL_EVENT_SMS_GLOBAL_NUM = "call_event_sms_global_limit_num_%s";
    /**
     * 七陌来电事件全局有效时间
     */
    public static final String REDIS_CALL_EVENT_SMS_GLOBAL_EXPIRE_TIME = "call_event_sms_global_expire_time_%s";


    public static final String CQ_PDD = "pdd";
    public static final String TEMPLATE_SINGLE = "模板短信";
    public static final String TEMPLATE_BATCH = "批量模板短信";
    public static final String DEFINE_SINGLE = "自定义短信";
    public static final String DEFINE_BATCH = "批量自定义短信";

    public static final String PKG_SOURCE_DICT_CONFIG = "pkg_source_dict_config";
    /**
     * 本人敏感标签key
     */
    public static final String LABEL_SECURITY_KEY = "label_security_%s";
    /**
     * 亲属敏感标签key
     */
    public static final String LABEL_CONTRACT_KEY = "label_contract_%s";
    /**
     * 亲属敏感标签key
     */
    public static final String LABEL_CAREER_INFORMATION_KEY = "label_career_information";
    /**
     * 客服系统投诉标签key
     */
    public static final String LABEL_COMPLAINT_KEY = "label_complaint_%s";

    public static final String QI_MOO_NODE_NO = "qi_moo_node_no";
    public static final String UPDATE = "update";
    public static final String UPDATE_TIME = "update_time";
    public static final String LN_FREE_INT = "LN_FREEINT";
    public static final String CRM = "CRM";
    public static final String CRM_LOWER = "crm";

    /**
     * 处理called_no字段异常key
     */
    public static final String ORIGIN_CALLED_NO_ERROR_KEY = "origin_called_no_error";

    public static final String COLON = ":";

    public static final String CRM_FEAD_JUST_REDIS = "crm_fee_adjust_redis";
    /**
     * 调整费用分次手动标志
     */
    public static final String CRM_FEE_ADJUST = "crm_fee_adjust_";
    /**
     * GNS短信内容验证码，兑换码脱敏权限
     */
    public static final String VERIFICATION_REDEMPTION_DESENSITIZATION = "gns:smsContent:desensitization";

    public static final String CQ_FACADE_FLAG = "cqFacadeFlag";
    public static final String QI_MO_PUSH_PHONE_FILTER = "qiMo_push_phone_filter";
    /**
     * 七陌通话记录创建时间
     */
    public static final String OFFERING_TIME = "OFFERING_TIME";
    /**
     * 通话时长
     */
    public static final String CALL_TIME_LENGTH = "CALL_TIME_LENGTH";
    /**
     * 录音文件名字
     */
    public static final String RECORD_FILE_NAME = "RECORD_FILE_NAME";
    /**
     * s3录音地址
     */
    public static final String JIE_LOCAL_FILE = "360JIE_LOCAL_FILE";
    /**
     * 通话Id
     */
    public static final String CALL_SHEET_ID = "CALL_SHEET_ID";
    /**
     * 生成socket系统得token
     */
    public static final String CRM_WEB_SOCKET = "%s_crm_web_socket_%s";
    /**
     * 坐席状态key
     */
    public static final String SEAT_STATE = "seat_state_%s";
    /**
     * 坐席状态key
     */
    public static final String CRM_QIMOO_DISPLAY_KEY = "crm_qimoo_display_key";
    public static final String OUT_COMPLAIN_CALL_MODEL_SCORE = "OutComplainCallModelScore";

    /**
     * 云软接口验签字段
     */
    public static final String APP_SECRET = "imcc.crm.sdk.user.info";
    /**
     * 云软进线事件key
     */
    public static final String IMCC_INCOMING_EVENT_REDIS_KEY = "imcc_incoming_event_%s";

    public static final String SMECC = "360SMECC";
    public static final String BTL = "360BTL";
    public static final String RE_TRIAL = "360RETRIAL";

    public static final String USER_ANTICIPATION_LABEL = "user_anticipation_label";

    public static final String PHONE_REPEAT_INCOMING = "电话重复进线({0})";

    public static final String SESSION_REPEAT_INCOMING = "会话重复进线({0})";

    public static final String CALL_FLAG_INFO_REDIS_KEY = "call_flag_info_redis_key";
    public static final String CALL_TRANSFER_INFO_REDIS_KEY = "call_transfer_info_redis_key";
    public static final String YR_MESSAGE_FLAG_INFO_REDIS_KEY = "yr_message_flag_info_redis_key";

    public static final String CRM_NAME_STR = "客服";

    public static final String UNDERSCORE = "_";

    public static final String POINT = ".";
    public static final String POINT_TRANSFER = "\\.";

    public static final String ZIP = "zip";

    public static final String XLSX_SUFFIX = ".xlsx";

    public static final String TEMP_PATH = "/opt/data/temp";

    /**
     * BTL授信子状态  （初审通过-补件中）
     */
    public static final String BTL_SUPP_TODO = "BTL_SUPP_TODO";

    /**
     * BTL授信子状态  （终审中）
     */
    public static final String BTL_SUPP_DONE = "BTL_SUPP_DONE";

    /**
     * 通知管理权限
     */
    public static final String CRM_NOTICE_ADMIN_PERMISSION = "crm:notice:broadcast:admin";

    public static final String ALL_NOTICE_SUM_KEY = "all_notice_message_num";
    public static final String RECENT_NOTICE_SUM_KEY = "recent_notice_message_num";
    public static final String SEAT_NOTICE_READ_NUM_KEY_PREFIX = "notice_read_num_seat_";

    /**
     * 通知公告不置顶默认时间
     */
    public static final String NOTICE_STICK_DEFAULT_TIME = "1999-01-01";

    public static final String WORK_ORDER = "workOrder";

    public static final String HTML_BR = " <br/> ";

    public static final String TIME_OUT = "TIME_OUT";
    public static final String OUT = "OUT";
    public static final String INSIDE = "INSIDE";

    public static final String INCOMING_UN_REPAY_RECORD = "incoming_unRepay_record";

    public static final String NIL = "nil";

    public static final String MAX_OVERDUE_KEY = "max_overdue_%s";


    public static final String CT = "CT";
    public static final String UR = "UR";

    public static final String LPS_FACADE_CHANGE_FLAG = "lps_facade_change_flag";

    public static final String LEFT_BRACKETS = "(";

    public static final String BRIGHT_BRACKETS = ")";

    public static final String LEFT_MID_BRACKETS = "[";

    public static final String BRIGHT_MID_BRACKETS = "]";

    public static final String KNOWLEDGE_SYSTEM = "knowledge";


    public static final String NULL_CHARACTER = "空";
    /**
     * 未成功还款进线优化 进线时间 改成换行 年月日在上 时间在下
     */
    public static final String INCOMING_UNREPAY_DATE_PATTERN = "yyyy-MM-dd\nHH:mm:ss";

    public static final String EXPORT_DATE_PATTERN = "yyyyMMddHHmmss";

    public static final String CODE = "code";
    public static final String DATA = "data";

    /**
     * source / 漏斗
     */
    public static final String SIGN = "sign";
    public static final String SOURCE_LIST = "sourceList";
    public static final String PAGE_LINK_LIST = "pageLinkList";

    public static final String FAQ_SOURCE = "faq_source";

    public static final String SYS = "sys";
    public static final String REPEAT_SOURCE = "source: ";
    public static final String REPEAT_PAGE_LINK = "页面链接: ";
    public static final String REPEAT_PAGE_NAME = "页面名称: ";
    public static final String REPEAT_SUFFIX = " 重复, 请重新输入";


    public static final String CODE_KEY = "code";

    public static final String DATA_KEY = "data";
    /**
     * 质检系统业务规则类型 查询及导出权限
     */
    public static final String RECORD_SESSION_RULE_PERMISSION_CODE = "session:record:ruleModel";
    /**
     * 用户标签权限
     */
    public static final String CRM_USER_LABEL_INFO = "crm:user:label:info";
    public static final String WLH_CONTROL_USER_NOT_FOUND = "用户信息不存在不允许操作";
    public static final String WLH_CONTROL_USER_NOT_APPLY = "用户微零花未授信不允许操作";
    public static final String WLH_CONTROL_USER_IS_CANCEL = "用户微零花注销账户不允许操作";
    public static final String WLH_CONTROL_IS_NORMAL = "用户微零花管制码正常,无需操作";
    public static final String WLH_CONTROL_COMMIT_FALI = "提交失败,请稍后操作";
    public static final String CAS_SEAT = "风控";
    public static final String JC = "JC";
    public static final String DJ = "DJ";
    public static final String CRM_STR = "CRM";
    public static final String WLH_360_PAY_CONTROL_CODE = "wlh360payConrrolCode";
    public static final String ADD_CHARACTERS = "新增";
    public static final String CANCEL_CHARACTERS = "撤销";

    public static final String WLH_CONTROL_CODE_ERROR_REDIS_KEY = "wlh_control_code_error_redis_key";
    public static final String WLH_CONTROL_FK_CONTROL = "风控管制";
    public static final String EVENT_CONTROL_USER = "{0}[{1}]";

    /**
     * deptId 类型
     */
    public static final String DICT_DEPT_ID_TYPE = "crm_unite_permission_deptId";

    // 不区分主体
    public static final String COMMON = "COMMON";
    /**
     * redisKey:loan_subject_key_主体
     * hashKey:资方类型  MALL 商城 WLH 微零花 JT 借条主营
     * hashValue:资方code
     */
    public static final String LOAN_SUBJECT_REDIS_KEY = "loan_subject_key_%s";
    public static final String LOAN_360 = "360LOAN";
    public static final String CRM_REMARK_RES_FLAG = "crm_remark_res_flag";
    public static final String S_STR_U = "S";
    public static final String F_STR_U = "F";

    /**
     * dict  小额地推  借据标识 loanFlag type
     */
    public static final String CRM_LOAN_REPAY_TEAM_FLAG = "crm_loan_repay_team_flag";

    public static final String CRM_DICT_LOAN_REPAY = "crm_loan_repay";
    public static final String REPAY_CURRENT = "提前还当期";


    public static final String COOKIE_LOGIN_NAME = "loginName";
    public static final String CRM_DZL_REDIS_KEY = "crm:dzl:";
    public static final String FEE_PUBLIC_ADJUST_ROLES = "fee_public_adjust_roles";
    public static final String CRM_FEE_PUBLIC_ADJUST_APPLY = "crm:feePublicAdjust:apply";
    public static final String REFUND_APPLY_REASON_MAIN = "refund_apply_reason_main";

    public static final String ZERO_HH_MM = "00:00";
    public static final String DOUBLE_ZERO_STR = "0.00";
    public static final String OPERATION_SUCCESS = "操作完成";
    public static final String BATCH_OPERATION_SUCCESS = "批量送复核操作完成";
    public static final int INT_TEN_THOUSAND_ONE = 10000;

    public static final String IS_LQS_VIP = "is_crm_vip";

    public static final String MENU_PERMISSION_QC_RULE = "crm:crmCallRecord:qc:rule";
    public static final String RESERVE_PUBLIC_THRESHOLD = "reserve_public_account_amt_threshold";

    public static final String RESERVE_PUBLIC_TRAIL_AMT = "reserve_public_trail_amt_%s";

    public static final String DICT_TYPE_LOAN_APPL_THIRD = "loan_appl_third";

    public static final String RESERVE_PUBLIC_MSG_NOTICE = "reserve_public_msg_notice";

    public static final String SMS = "sms";

    public static final String EMAIL = "email";

    public static final String SMS_TEMPLATE_NO = "smsTemplateNo";

    public static final String RESERVE_PUBLIC_PART_FAIL_KEY = "reserve_public_part_fail";

    public static final String MY_COMPANY = "我司开具";
    public static final String CAPITAL = "资方开具";

    public static final String TWO_ZERO = "00";

    public static final String RESERVE_PUBLIC_QUERY_TIMES = "reserve_public_query_times";

    public static final String RP_SETTLE = "RP_SETTLE";
    public static final String UN_SETTLE = "欠款未结清";
    public static final String NOT_FOUND_WLH_INFO = "暂未查到新微零花账户或欠款";

    public static final String HE_XIN_UN_KNOW_STATUS = "WZZT";

    public static final String UN_KNOW_STATUS = "reserve_public_un_know_status_%s";
    public static final String ZIP_SUFFIX = ".zip";
    public static final String DELAY_SUCCESS = "延期成功";

    public static final String PERCENT_S = "%s";

    public static final String ROLE_ID = "roleId";

    public static final String DEPT_ADMIN = "deptAdmin";
    /**
     * vip接口管理 reids key
     */
    public static final String CRM_OUTTER_INTERFACE_MANAGE = "crm_outter_interface_manage_%s";


    public static final String PKG_TYPE = "pkgType";
    public static final String ZHI_XIN_ICE = "360ICE";
    public static final String VIP_CUST = "重要客户";

    public static final String CRM_VIP_REFUND_FAIL_LAST_QUERY_DATETIME = "crm_vip_refund_fail_last_query_datetime";

    public static final String USER_LABEL_CONFIG_REDIS_KEY = "user_label_config_key";

    public static final String USER_LABEL_CONFIG_LABEL_CODE = "user_label_config_label_code";

    public static final String UR_ALIAS = "UR";

    public static final String UL_ALIAS = "UL";

    public static final String NA_ALIAS = "NA";

    public static final String NO_ALIAS = "NO";

    public static final String NM_ALIAS = "NM";

    public static final String UC_ALIAS = "UC";

    public static final String RM_ALIAS = "RM";

    public static final String UM_ALIAS = "UM";

    public static final String QA_ALIAS = "QA";

    public static final String UP_ALIAS = "UP";

    public static final String USER_LABEL_QI_MO_CACHE_KEY = "qimo_label_menu_%s";

    public static final String USER_LABEL_QI_MO_TIME_CACHE_KEY = "qimo_label_time_%s";

    public static final String YYYY_MM_DD_HH = "yyyyMMddHH";

    public static final String USER_LABEL_MENU_DICT = "user_label_menu_dict";
    /**
     * 工单标签字典类型
     */
    public static final String CRM_WORK_LABEL_DICT = "crm_work_label";
    public static final String CUST_NO = "custNo";
    public static final String CONTRACT_NO = "contractNo";
    public static final String PRODUCT_CODE = "productCode";
    public static final String USER_NO = "userNo";

    public static final String YYYY_MM_DD = "yyyy/MM/dd";
    public static final String QI_MO_ACCOUNT_SWITCH = "qimo_account_switch";

    public static final String CRM_CUISHOU_FILTER_VX_CODE = "crm_cuishou_filter_vx_code";

    public static final String LOAN_ASSET_ATTRIBUTION_CUISHOU_CODE = "loan_asset_attribution_cuishou_code";
    public static final String RP_STR = "RP";
    public static final String REFUND_STR = "REFUND";
    public static final String USER_NO_OVER_PAY = "用户暂无可退溢缴款！";
    public static final String BILL = "BILL";
    public static final String BILL_STR = "分期商城";
    public static final String YYYY_MM = "yyyy/MM";

    /**
     * 0 关(老逻辑)  1 开
     */
    public static final String BLACK_LIST_SMS_SLS_FLAG = "black_list_sms_sls_flag";
    public static final String BLACK_LIST_CALL_SLS_FLAG = "black_list_call_sls_flag";

    public static final String BLACK_LIST_SOURCE = "CRM系统";
    public static final String BANK_INFO_REDIS_KEY = "bank_info_redis_key";

    public static final String SOFT_CONFIG_TIME_REDIS_KEY = "soft_config_time_redis_key";
    public static final String CRM_IMCC_AUTH_URL = "crmImccAuthUrl";

    public static final String CRM_PUBLIC_QUERY_TOLERANCE = "crm_public_query_tolerance";
    public static final String INDIVIDUAL_ACHIEVEMENT_SKILL_GROUP = "individual_achievement_skill_group";
    public static final String SEAT_MANAGE_POSITION = "seat_manage_position";
    public static final String CRM_PERSONAL_ACHIEVENMENT_QUERY = "crm:personalAchievenment:query";
    public static final String LOCK_STR = "lock";
    public static final String LOAN_CALC_FLAG = "loan_calc_flag";
    public static final String PUSH_SENSITIVE_INFO_ROLE_IDS = "push_sensitive_info_role_ids";
    public static final String CRM_PHONE_REPEAT_REMARK = "crm_phone_repeat_remark_%s";
    public static final String CRM_PHONE_REPEAT_LOG = "crm_phone_repeat_log_%s";
    public static final String TRANSFER = "transfer";
    public static final String DIAL_TRANSFER = "dialTransfer";
    public static final String ASK_TRANSFER_RESULT_TIME = "ask_transfer_result_time";

}
