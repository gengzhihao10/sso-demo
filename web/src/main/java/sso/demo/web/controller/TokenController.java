package sso.demo.web.controller;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sso.demo.api.base.SSOResponse;
import sso.demo.api.interfaces.TokenApiService;
import sso.demo.api.token.input.RestTokenCommand;
import sso.demo.api.token.output.TokenCommandOutput;
import sso.demo.api.consts.enums.SSOResponseCodeEnum;
import sso.demo.web.service.TokenService;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@RestController
@Slf4j
public class TokenController implements TokenApiService {

    @Autowired
    private TokenService tokenService;


    @Override
    public SSOResponse<TokenCommandOutput> generateToken(@RequestBody RestTokenCommand restTokenCommand) {
        return tokenService.generateToken(restTokenCommand);
    }

    @Override
    public SSOResponse<SSOResponseCodeEnum> checkToken(HttpServletRequest request) {

        //获取token
        Object token = request.getHeader("token");
        Object userName = request.getHeader("userName");
        //传入token不能为空
        if (ObjectUtil.isNull(token)){
            log.error("传入token为空，用户名为 {}",userName);
            return SSOResponse.fail(SSOResponseCodeEnum.TOKEN_IS_NULL);
        }
        //传入用户名不能为空
        if (ObjectUtil.isNull(userName)){
            log.error("传入用户名为空,token为 {}",token);
            return SSOResponse.fail(SSOResponseCodeEnum.TOKEN_USERNAME_IS_NULL);
        }
        //解析用户名
        String userNameDecode;
        try {
            userNameDecode = URLDecoder.decode((String)userName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("用户名解析失败，未解析用户名为 {}",userName);
            return SSOResponse.fail(SSOResponseCodeEnum.TOKEN_USERNAME_PARSE_FAILED);
        }


        return tokenService.checkToken(String.valueOf(token),userNameDecode);
    }
}
