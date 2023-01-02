package com.example.a3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

@ComponentScan({"com.example.a3","com.example.a3.Employees"})
@EnableAutoConfiguration
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class A3Application {

    public static void main(String[] args) {
        SpringApplication.run(A3Application.class, args);
    }

}
