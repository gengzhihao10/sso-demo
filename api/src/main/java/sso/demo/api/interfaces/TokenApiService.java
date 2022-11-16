package sso.demo.api.interfaces;

import cn.hutool.core.util.ObjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sso.demo.api.base.RestResponse;
import sso.demo.api.consts.enums.ResponseCodeEnum;
import sso.demo.api.token.input.RestTokenCommand;
import sso.demo.api.token.output.TokenCommandOutput;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "token操作接口")
@RequestMapping("/token")
public interface TokenApiService {

    @ApiOperation(value = "生成token")
    @PostMapping("/generate")
    RestResponse<TokenCommandOutput> generateToken(RestTokenCommand restTokenCommand);

    @ApiOperation(value = "校验token")
    @PostMapping("/check")
    RestResponse<ResponseCodeEnum> checkToken(Object object, HttpServletRequest request, HttpServletResponse response);
}
