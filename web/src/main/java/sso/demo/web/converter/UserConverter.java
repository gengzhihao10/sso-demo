package sso.demo.web.converter;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import sso.demo.api.token.output.param.UserInfoParam;
import sso.demo.api.user.input.RestUserCommand;
import sso.demo.web.DO.UserDO;

@Component
@Mapper(componentModel = "spring")
public interface UserConverter {

//    UserCommand convert1(RestUserCommand restUserCommand);

    UserDO convert(RestUserCommand restUserCommand);

    UserInfoParam convert(UserDO userDO);
}
