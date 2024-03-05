package com.adria.notificationsystem;

import com.adria.notificationsystem.models.Event;
import com.adria.notificationsystem.models.EventType;
import com.adria.notificationsystem.models.Recipient;
import com.adria.notificationsystem.repository.EventRepository;
import com.adria.notificationsystem.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MailProperties.class)
public class NotificationsystemApplication implements CommandLineRunner {

	@Autowired
	RecipientRepository recipientRepository;

	@Autowired
	EventRepository eventRepository;
	public static void main(String[] args) {
		SpringApplication.run(NotificationsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Save Recipients
		recipientRepository.save(new Recipient(1, "Alice", "Smith", "aimrane.essakhi@gmail.com", "9876543210", "xyz456"));
		recipientRepository.save(new Recipient(2, "John", "Doe", "aimrane2002@gmail.com", "1234567890", "abc123"));
		recipientRepository.save(new Recipient(3, "Bob", "Johnson", "aimrane2002@gmail.com", "5555555555", "123xyz"));

		//Save Events
		eventRepository.save(new Event(1, EventType.IMPORTANT_TRANSACTION, true));
		eventRepository.save(new Event(2, EventType.NEWS, true));
		eventRepository.save(new Event(3, EventType.OTP, false));
		eventRepository.save(new Event(4, EventType.NEW_OFFERS, true));
		eventRepository.save(new Event(5, EventType.PASSWORD_CHANGED, false));

	}
}
