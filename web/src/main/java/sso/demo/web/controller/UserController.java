package sso.demo.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sso.demo.api.base.SSOResponse;
import sso.demo.api.interfaces.UserApiService;
import sso.demo.api.user.input.RestUserCommand;
import sso.demo.api.user.output.UserCommandOutput;
import sso.demo.web.service.UserServcie;


@RestController
public class UserController implements UserApiService {

    @Autowired
    private UserServcie userServcie;

    @Override
    public SSOResponse<UserCommandOutput> insertUser(@RequestBody RestUserCommand restUserCommand){
        return userServcie.insertUser(restUserCommand);
    }
}
