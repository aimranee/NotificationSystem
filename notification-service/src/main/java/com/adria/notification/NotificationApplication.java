package com.adria.notification;

import com.adria.notification.config.runner.ADTConstCommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificationApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}
}
