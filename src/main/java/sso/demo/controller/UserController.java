package sso.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sso.demo.api.base.RestResponse;
import sso.demo.api.user.input.RestUserCommand;
import sso.demo.api.user.output.UserOutput;
import sso.demo.service.UserServcie;

@Api(value = "用户操作接口")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserServcie userServcie;

    @ApiOperation(value = "新增用户")
    @PostMapping("/insert")
    public RestResponse<UserOutput> insertUser(@RequestBody RestUserCommand restUserCommand){
        return userServcie.insertUser(restUserCommand);
    }
}
