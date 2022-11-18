package sso.demo.api.token.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import sso.demo.api.base.SSOBaseInput;

import java.io.Serializable;

@Slf4j
@ApiModel("token写命令入参")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestCheckTokenCommand extends SSOBaseInput implements Serializable {
    private static final long serialVersionUID = -1781108417298960801L;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 用户名
     */
    @ApiModelProperty("用户登陆凭证")
    private String token;

    @Override
    public void check() {

    }
}
