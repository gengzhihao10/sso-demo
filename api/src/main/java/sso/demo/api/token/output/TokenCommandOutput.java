package sso.demo.api.token.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sso.demo.api.token.output.param.UserInfoParam;
import sso.demo.api.consts.DateFormatPattern;

import java.io.Serializable;

@ApiModel("token写命令出参")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenCommandOutput implements Serializable {

    private static final long serialVersionUID = -1365417670942057789L;

    /**
     * token，登陆凭证
     */
    @ApiModelProperty("token，登陆凭证")
    private String token;

    /**
     * 用户信息参数
     */
    @ApiModelProperty("用户信息参数")
    private UserInfoParam userInfoParam;
}
