package sso.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sso.demo.DO.UserDO;
import sso.demo.api.base.RestResponse;
import sso.demo.api.user.input.RestUserCommand;
import sso.demo.api.user.output.UserCommandOutput;
import sso.demo.converter.UserConverter;
import sso.demo.enums.ResponseCodeEnum;
import sso.demo.repository.UserRepository;
import sso.demo.utils.IDUtil;
import sso.demo.utils.RedisUtil;

import java.util.Date;

@Slf4j
@Component
public class UserServcie {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RedisUtil redisUtil;

    public RestResponse<UserCommandOutput> insertUser(RestUserCommand restUserCommand){

        UserDO userDO = userConverter.convert(restUserCommand);


        //雪花算法生成id
        userDO.setId(IDUtil.getId(null,null));
        userDO.setCreateTime(new Date());
        userDO.setUpdateTime(new Date());

        boolean result = userRepository.save(userDO);
        if (!result){
            log.error("新增用户信息失败，用户名为 {}", userDO.getUsername());
            return RestResponse.fail(ResponseCodeEnum.FAILED);
        }
        return RestResponse.ok();
    }

}
