package sso.demo.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import sso.demo.web.DO.UserDO;

@Mapper
@Component
public interface UserMapper extends BaseMapper<UserDO> {

}
