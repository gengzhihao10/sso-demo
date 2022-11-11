package sso.demo.controller;

import cn.hutool.core.util.ObjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sso.demo.api.base.RestResponse;
import sso.demo.api.token.input.RestTokenCommand;
import sso.demo.api.token.output.TokenCommandOutput;
import sso.demo.consts.enums.ResponseCodeEnum;
import sso.demo.service.TokenService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Api(value = "token操作接口")
@RequestMapping("/token")
@RestController
@Slf4j
public class TokenController {

    @Autowired
    private TokenService tokenService;


    @ApiOperation(value = "生成token")
    @PostMapping("/generate")
    public RestResponse<TokenCommandOutput> generateToken(@RequestBody RestTokenCommand restTokenCommand) {
        return tokenService.generateToken(restTokenCommand);
    }

    @ApiOperation(value = "校验token")
    @PostMapping("/check")
    public RestResponse<ResponseCodeEnum> checkToken(@RequestBody Object object, HttpServletRequest request, HttpServletResponse response) {

        //获取token
        Object token = request.getHeader("token");
        Object userName = request.getHeader("userName");
        //传入token不能为空
        if (ObjectUtil.isNull(token)){
            log.error("传入token为空，用户名为 {}",userName);
            return RestResponse.fail(ResponseCodeEnum.TOKEN_IS_NULL);
        }
        //传入用户名不能为空
        if (ObjectUtil.isNull(userName)){
            log.error("传入用户名为空,token为 {}",token);
            return RestResponse.fail(ResponseCodeEnum.TOKEN_USERNAME_IS_NULL);
        }
        //解析用户名
        String userNameDecode;
        try {
            userNameDecode = URLDecoder.decode((String)userName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("用户名解析失败，未解析用户名为 {}",userName);
            return RestResponse.fail(ResponseCodeEnum.TOKEN_USERNAME_PARSE_FAILED);
        }


        return tokenService.checkToken(String.valueOf(token),userNameDecode);
    }
}
