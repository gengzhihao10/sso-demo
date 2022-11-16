package sso.demo.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sso.demo.api.base.RestResponse;
import sso.demo.api.consts.enums.ResponseCodeEnum;
import sso.demo.api.user.input.RestUserCommand;
import sso.demo.api.user.output.UserCommandOutput;
import sso.demo.api.utils.IDUtil;
import sso.demo.api.utils.RedisUtil;
import sso.demo.web.DO.UserDO;
import sso.demo.web.converter.UserConverter;
import sso.demo.web.repository.UserRepository;

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
