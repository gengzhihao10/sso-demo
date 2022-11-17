package sso.demo.api.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sso.demo.api.base.SSOResponse;
import sso.demo.api.user.input.RestUserCommand;
import sso.demo.api.user.output.UserCommandOutput;

@Api(value = "用户操作接口")
public interface UserApiService {

    @ApiOperation(value = "新增用户")
    @PostMapping("/user/insert")
    SSOResponse<UserCommandOutput> insertUser(RestUserCommand restUserCommand);
}
