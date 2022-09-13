package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

/*@SpringBootApplication(exclude = GsonAutoConfiguration.class)
@EnableConfigurationProperties
@ImportResource(locations = {"classpath:spring/spring-root.xml"})
public class DemoApplication {
	public static void main(String[] args) {
		// 启动pandora容器
		PandoraBootstrap.run(args);
		// 启动Spring Boot
		SpringApplication.run(Application.class, args);
		// 标记服务启动完成
		PandoraBootstrap.markStartupAndWait();
	}
}*/
