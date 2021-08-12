package com.hjj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @author huangjj24
* @date 2021-7-20 20:46
**/
@SpringBootApplication
@Slf4j
public class AppStarter {

   public static void main(String[] args) {
       SpringApplication.run(AppStarter.class, args);

       log.info("#########  SpringBoot 启动成功  #########");
   }
}
