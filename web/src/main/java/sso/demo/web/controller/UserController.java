package sso.demo.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sso.demo.api.base.RestResponse;
import sso.demo.api.user.input.RestUserCommand;
import sso.demo.api.user.output.UserCommandOutput;
import sso.demo.web.service.UserServcie;


@RestController
public class UserController {

    @Autowired
    private UserServcie userServcie;

    @ApiOperation(value = "新增用户")
    @PostMapping("/insert")
    public RestResponse<UserCommandOutput> insertUser(@RequestBody RestUserCommand restUserCommand){
        return userServcie.insertUser(restUserCommand);
    }
}
