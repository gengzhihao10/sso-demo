package sso.demo.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import sso.demo.DO.UserDO;
import sso.demo.mapper.UserMapper;
import sso.demo.repository.UserRepository;

@Component
public class UserRepositoryImpl extends ServiceImpl<UserMapper, UserDO> implements UserRepository {
}
