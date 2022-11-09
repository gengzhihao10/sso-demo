package sso.demo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * @author gengzhihao
 * @date 2022/11/8 17:26
 * @description 启动类
**/

@SpringBootApplication(scanBasePackages = {"sso.demo.*"})
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 7200)
//@EnableConfigurationProperties
public class SSOApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SSOApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
