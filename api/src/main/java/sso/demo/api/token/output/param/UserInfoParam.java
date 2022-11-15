package sso.demo.api.token.output.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


/**
 * @author gengzhihao
 * @date 2022/11/10 14:24
 * @description 用户信息参数
**/
@ApiModel("用户信息参数")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoParam implements Serializable {
    private static final long serialVersionUID = -2148856183030795954L;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    //token中不能放入敏感信息
//    /**
//     * 密码
//     */
//    private String password;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Object age;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Object sex;
    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String tel;
    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String card;
    /**
     * 结婚信息。0代表未结婚，1代表已结婚
     */
    @ApiModelProperty("结婚信息。0代表未结婚，1代表已结婚")
    private Integer married;
}
