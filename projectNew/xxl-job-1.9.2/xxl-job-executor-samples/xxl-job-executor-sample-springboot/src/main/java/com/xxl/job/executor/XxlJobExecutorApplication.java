package com.xxl.job.executor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.xxl.job.executor.dao")
@EnableTransactionManagement
public class XxlJobExecutorApplication {
	public static void main(String[] args) {
		SpringApplication.run(XxlJobExecutorApplication.class, args);
	}
}