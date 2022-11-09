package sso.demo.api.token.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import sso.demo.api.base.BaseInput;
import sso.demo.utils.InputCheckUtil;

import java.io.Serializable;

@Slf4j
@ApiModel("token写命令入参")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestTokenCommand  extends BaseInput implements Serializable {


    private static final long serialVersionUID = -1042243831234064731L;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    @Override
    public void check() {
        InputCheckUtil.checkInput(username,"用户名不能为空");
        InputCheckUtil.checkInput(password,"密码不能为空");
    }
}
