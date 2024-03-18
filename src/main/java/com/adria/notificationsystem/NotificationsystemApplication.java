package com.adria.notificationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MailProperties.class)
public class NotificationsystemApplication{
	public static void main(String[] args) {
		SpringApplication.run(NotificationsystemApplication.class, args);
	}
}
