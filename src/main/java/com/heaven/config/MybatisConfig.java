package com.heaven.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.heaven.dao")
public class MybatisConfig {

}
