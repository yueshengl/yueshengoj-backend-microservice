package com.yuesheng.yueshengojbackendjudgeservice;

import com.yuesheng.yueshengojbackendjudgeservice.rabbitmq.InitRabbitMq;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

// todo 如需开启 Redis，须移除 exclude 中的内容(exclude = {RedisAutoConfiguration.class})
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.yuesheng.yueshengojbackendserviceclient.service"})
@ComponentScan("com.yuesheng")
public class YueshengojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        //初始化消息队列
        InitRabbitMq.doInit();
        SpringApplication.run(YueshengojBackendJudgeServiceApplication.class, args);
    }

}
