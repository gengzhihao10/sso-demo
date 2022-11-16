package sso.demo.web.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sso.demo.web.DO.UserDO;
import sso.demo.web.mapper.UserMapper;
import sso.demo.web.repository.UserRepository;

import java.util.List;

@Component
public class UserRepositoryImpl extends ServiceImpl<UserMapper, UserDO> implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDO> queryUserByNameAndSecret(String userName, String passWord) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserDO::getUsername,userName);
        wrapper.eq(UserDO::getPassword,passWord);
        return userMapper.selectList(wrapper);
    }

    @Override
    public UserDO queryUserByIdAndName(Long id, String userName) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserDO::getId,id);
        wrapper.eq(UserDO::getUsername,userName);
        return userRepository.getOne(wrapper);
    }
}
