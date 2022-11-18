package sso.demo.api.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import sso.demo.api.base.SSOResponse;
import sso.demo.api.consts.enums.SSOResponseCodeEnum;
import sso.demo.api.token.input.RestCheckTokenCommand;
import sso.demo.api.token.input.RestGenerateTokenCommand;
import sso.demo.api.token.output.TokenCommandOutput;

import javax.servlet.http.HttpServletRequest;


/**
 * feignClient继承此api后，与@RequestMapping冲突。因此类上不标注@RequestMapping，而将uri放在方法上
 * 考虑到依赖sso的应用可能会对feignClient传入自定义的configuration，因此sso不提供统一的feignClient，由集成sso的系统自己继承此接口自行实现
 */
@Api(value = "token操作接口")
public interface TokenApiService {

    @ApiOperation(value = "生成token")
    @PostMapping("/token/generate")
    SSOResponse<TokenCommandOutput> generateToken(RestGenerateTokenCommand restGenerateTokenCommand);

    @ApiOperation(value = "校验token")
    @PostMapping("/token/check")
    //feignClient继承此api后，方法签名只能有一个参数，因此此方法的参数可以通过HttpServletRequest来获取token，也可以通过实体来传输token
    SSOResponse<SSOResponseCodeEnum> checkToken(RestCheckTokenCommand restCheckTokenCommand);
}
