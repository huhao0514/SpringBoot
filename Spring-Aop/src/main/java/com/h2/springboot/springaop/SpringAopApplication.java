package com.h2.springboot.springaop;

import com.h2.springboot.springaop.aspect.UserAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopApplication {
    //在UserAspect中添加@Component代替
  /*  @Bean(name="userAspect")
    public UserAspect initUserAspect(){
        return new UserAspect();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

}
