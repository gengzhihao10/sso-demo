package sso.demo.utils;

import cn.hutool.core.util.ObjectUtil;
import sso.demo.exception.NullInputException;

public class InputCheckUtil {


    public static void checkInput(Object input,String message){
        if (ObjectUtil.isEmpty(input)){
            throw new NullInputException(message);
        }
    }
}
