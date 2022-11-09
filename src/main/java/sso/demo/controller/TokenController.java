package sso.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sso.demo.api.base.RestResponse;
import sso.demo.api.token.input.RestTokenCommand;
import sso.demo.api.token.output.TokenCommandOutput;
import sso.demo.api.user.input.RestUserCommand;
import sso.demo.api.user.output.UserCommandOutput;
import sso.demo.service.TokenService;

@Api(value = "token操作接口")
@RequestMapping("/token")
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;


    @ApiOperation(value = "生成token")
    @PostMapping("/generate")
    public RestResponse<TokenCommandOutput> generateToken(@RequestBody RestTokenCommand restTokenCommand){
        return tokenService.generateToken(restTokenCommand);
    }
}
