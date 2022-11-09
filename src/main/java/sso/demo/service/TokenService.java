package sso.demo.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sso.demo.DO.UserDO;
import sso.demo.api.base.RestResponse;
import sso.demo.api.token.input.RestTokenCommand;
import sso.demo.api.token.output.TokenCommandOutput;
import sso.demo.enums.ResponseCodeEnum;
import sso.demo.repository.UserRepository;
import sso.demo.utils.JWTUtil;

import java.util.List;

@Slf4j
@Component
public class TokenService {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    public RestResponse<TokenCommandOutput> generateToken(RestTokenCommand restTokenCommand){
        List<UserDO> userDOS = userRepository.queryUserByNameAndSecret(restTokenCommand.getUsername(),restTokenCommand.getPassword());
        //查不到用户，说明没有注册
        if (CollectionUtils.isEmpty(userDOS)){
            log.info("没有此用户，无法获取token，用户名为 {}",restTokenCommand.getUsername());
            return RestResponse.fail(ResponseCodeEnum.USER_IS_NOT_EXIST);
        }
        //查出多个用户，说明数据有问题
        if (userDOS.size() > 1){
            log.error("查出用户为多个，无法获取token，用户名为 {}",restTokenCommand.getUsername());
            return  RestResponse.fail(ResponseCodeEnum.USER_DATA_WRONG);
        }

        //获取token
        UserDO userDO = userDOS.get(0);
        String token = jwtUtil.createToken(userDO.getId());

        TokenCommandOutput tokenCommandOutput = new TokenCommandOutput();
        tokenCommandOutput.setToken(token);

        return RestResponse.ok(tokenCommandOutput);
    }
}
