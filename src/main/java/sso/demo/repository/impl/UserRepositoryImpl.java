package sso.demo.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sso.demo.DO.UserDO;
import sso.demo.mapper.UserMapper;
import sso.demo.repository.UserRepository;

import java.util.List;

@Component
public class UserRepositoryImpl extends ServiceImpl<UserMapper, UserDO> implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDO> queryUserByNameAndSecret(String userName, String passWord) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserDO::getUsername,userName);
        wrapper.eq(UserDO::getPassword,passWord);
        List<UserDO> userDOS = userMapper.selectList(wrapper);
        return userDOS;
    }
}
