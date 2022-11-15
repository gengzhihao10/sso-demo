package sso.demo.api.utils;

import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;
import sso.demo.api.exception.NullInputException;

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
