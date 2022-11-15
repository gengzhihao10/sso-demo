package sso.demo.api.consts.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum {

    //枚举
    SUCCESS(0,"成功"),
    FAILED(-1,"未知原因失败"),
    INPUT_IS_NULL(10000,"入参为空"),
    CREATE_SNOWFLAKE_ID_FAILED(10100,"构造雪花算法id失败"),

    USER_IS_NOT_EXIST(10200,"用户不存在"),
    USER_DATA_WRONG(10201,"用户数据错误"),

    TOKEN_IS_NULL(10300,"传入token为空"),
    TOKEN_OUT_OF_DATE(10301,"token已过期"),
    TOKEN_USERNAME_IS_NULL(10302,"校验token时用户名不能为空"),
    TOKEN_USER_NOT_EXIST(10303,"用户不存在"),
    TOKEN_USERNAME_PARSE_FAILED(10304,"用户名解析失败"),
    ;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

}
