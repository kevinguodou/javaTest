package com.example.demo;

import com.example.demo.annotation.spring.ServiceClzz;
import com.example.demo.servicApi.RemoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ServiceClzz serviceClzz;

	@Autowired
	private RemoteService remoteService;

	@Test
	void springAnnotation() {
		serviceClzz.operate();
	}

	@Test
	void beanAnnotation() {
		remoteService.oprate();
	}

}
