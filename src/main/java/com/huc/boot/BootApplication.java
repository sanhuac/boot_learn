package com.huc.boot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
//@EnableScheduling
@EnableSwagger2
@Slf4j
@MapperScan("com.huc.boot.dao")
public class BootApplication {

	public static void main(String[] args) {
	    log.info("springboot启动开始");
		SpringApplication.run(BootApplication.class, args);
	}


}
