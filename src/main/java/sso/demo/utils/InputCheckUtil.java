package sso.demo.utils;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import sso.demo.exception.NullInputException;

public class InputCheckUtil {


    public static void checkInput(Object input,String message){
        if (ObjectUtil.isEmpty(input)){
            throw new NullInputException(message);
        }
    }

    public static void checkInput(String input,String message){
        if (StringUtils.isBlank(input)){
            throw new NullInputException(message);
        }
    }
}
