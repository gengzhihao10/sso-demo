package sso.demo.converter;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import sso.demo.DO.UserDO;
import sso.demo.api.user.input.RestUserCommand;

@Component
@Mapper(componentModel = "spring")
public interface UserConverter {

//    UserCommand convert1(RestUserCommand restUserCommand);

    UserDO convert(RestUserCommand restUserCommand);
}
