package sso.demo.api.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sso.demo.api.base.RestResponse;
import sso.demo.api.user.input.RestUserCommand;
import sso.demo.api.user.output.UserCommandOutput;

@Api(value = "用户操作接口")
@RequestMapping("/user")
public interface UserApiService {

    @ApiOperation(value = "新增用户")
    @PostMapping("/insert")
    RestResponse<UserCommandOutput> insertUser(RestUserCommand restUserCommand);
}
