package sso.demo.api.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import sso.demo.api.consts.enums.SSOResponseCodeEnum;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ApiModel("通用响应")
public class SSOResponse<T> implements Serializable {

    private static final long serialVersionUID = -1784985132736151264L;

    @ApiModelProperty("响应码")
    private Integer code;

    @ApiModelProperty("提示信息")
    private String message;

    @ApiModelProperty("数据集")
    private T data;

    public SSOResponse() {
    }

    public SSOResponse(Integer code) {
        this.code = code;
    }

    public SSOResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public SSOResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> SSOResponse<T> ok(){
        return new SSOResponse<>(SSOResponseCodeEnum.SUCCESS.getCode(), SSOResponseCodeEnum.SUCCESS.getDesc());
    }
    public static <T> SSOResponse<T> ok(T data){
        return new SSOResponse<>(SSOResponseCodeEnum.SUCCESS.getCode(), SSOResponseCodeEnum.SUCCESS.getDesc(),data);
    }
    public static <T> SSOResponse<T> fail(SSOResponseCodeEnum SSOResponseCodeEnum){
        return new SSOResponse<>(SSOResponseCodeEnum.getCode(), SSOResponseCodeEnum.getDesc());
    }
}
