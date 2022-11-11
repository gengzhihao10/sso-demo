package sso.demo.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sso.demo.DO.UserDO;
import sso.demo.api.base.RestResponse;
import sso.demo.api.token.input.RestTokenCommand;
import sso.demo.api.token.output.TokenCommandOutput;
import sso.demo.api.token.output.param.UserInfoParam;
import sso.demo.consts.enums.ResponseCodeEnum;
import sso.demo.converter.UserConverter;
import sso.demo.repository.UserRepository;
import sso.demo.utils.JWTUtil;
import sso.demo.utils.JsonUtil;
import sso.demo.utils.RedisUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Component
public class TokenService {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${jwt.data.expiration}")
    private Integer expiration;

    @Autowired
    private UserConverter userConverter;

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

        //构造响应
        TokenCommandOutput tokenCommandOutput = new TokenCommandOutput();
        UserInfoParam userInfoParam = userConverter.convert(userDO);
        tokenCommandOutput.setUserInfoParam(userInfoParam);
        tokenCommandOutput.setToken(token);
        log.info("当前token信息为 {}", JsonUtil.obj2Str(tokenCommandOutput));

        return RestResponse.ok(tokenCommandOutput);
    }


    public RestResponse<ResponseCodeEnum> checkToken(String token,String userName){
        Claims claims = jwtUtil.parseToken(token);
        //判断是否过期
        if (ObjectUtil.isNull(claims) || jwtUtil.judgeTokenExpiration(claims.getExpiration())){
            log.info("token已过期，token为 {}",token);
            return RestResponse.fail(ResponseCodeEnum.TOKEN_OUT_OF_DATE);
        }
        //校验用户是否存在
        Long userId = Long.valueOf((String) claims.get("sub"));
        UserDO userDO = userRepository.queryUserByIdAndName(userId,userName);
        if (ObjectUtil.isNull(userDO)){
            log.error("token错误，用户查无此人，token为 {}，ID为 {}，用户名为 {}",token,userId,userName);
            return RestResponse.fail(ResponseCodeEnum.TOKEN_USER_NOT_EXIST);
        }

        return RestResponse.ok();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String data = URLEncoder.encode("橘子君3", "utf-8");
        log.info(data);
    }
}
