package com.adria.notificationsystem;

import com.adria.notificationsystem.models.Event;
import com.adria.notificationsystem.models.EventType;
import com.adria.notificationsystem.models.Recipient;
import com.adria.notificationsystem.repository.EventRepository;
import com.adria.notificationsystem.repository.EventTypeRepository;
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

	@Autowired
	EventTypeRepository eventTypeRepository;
	public static void main(String[] args) {
		SpringApplication.run(NotificationsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Save Recipients
		recipientRepository.save(new Recipient("Alice", "Smith", "aimrane.essakhi@gmail.com", "9876543210", "xyz456"));
		recipientRepository.save(new Recipient("John", "Doe", "aimrane2002@gmail.com", "1234567890", "abc123"));
		recipientRepository.save(new Recipient("Bob", "Johnson", "aimrane2002@gmail.com", "5555555555", "123xyz"));

		//Save Event types
		EventType eventType1 = eventTypeRepository.save(new EventType("IMPORTANT_TRANSACTION"));
		EventType eventType2 = eventTypeRepository.save(new EventType("NEWS"));
		EventType eventType3 = eventTypeRepository.save(new EventType("OTP"));
		EventType eventType4 = eventTypeRepository.save(new EventType("NEW_OFFERS"));
		EventType eventType5 = eventTypeRepository.save(new EventType("PASSWORD_CHANGED"));

		//Save Events
		eventRepository.save(new Event(eventType1, true));
		eventRepository.save(new Event(eventType2, true));
		eventRepository.save(new Event(eventType3, false));
		eventRepository.save(new Event(eventType4, true));
		eventRepository.save(new Event(eventType5, false));

	}
}
