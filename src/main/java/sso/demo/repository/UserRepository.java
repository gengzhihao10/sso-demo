package sso.demo.repository;


import com.baomidou.mybatisplus.extension.service.IService;
import sso.demo.DO.UserDO;

import java.util.List;

/**
 * @author gengzhihao
 * @date 2022/11/1 11:52
 * @description User用户仓库类
**/

public interface UserRepository extends IService<UserDO> {

    List<UserDO> queryUserByNameAndSecret(String userName, String passWord);

    UserDO queryUserByIdAndName(Long id, String userName);
}
