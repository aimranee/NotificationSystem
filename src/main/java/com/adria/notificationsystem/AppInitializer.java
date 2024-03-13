package com.adria.notificationsystem;

import com.adria.notificationsystem.model.Event;
import com.adria.notificationsystem.model.Recipient;
import com.adria.notificationsystem.repository.EventRepository;
import com.adria.notificationsystem.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
//public class AppInitializer implements CommandLineRunner {
//
//    @Autowired
//    RecipientRepository recipientRepository;
//
//    @Autowired
//    EventRepository eventRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        //Save Recipients
//        recipientRepository.save(new Recipient("Alice", "Smith", "aimrane.essakhi@gmail.com", "9876543210", "xyz456"));
//        recipientRepository.save(new Recipient("John", "Doe", "aimrane2002@gmail.com", "1234567890", "abc123"));
//
//        //Save Events
//        eventRepository.save(new Event("IMPORTANT_TRANSACTION", true, "message important", "subject de message important"));
//        eventRepository.save(new Event("NEWS", true, "message new", "subject new"));
//        eventRepository.save(new Event("OTP", false, "message OTP", "subject OTP"));
//        eventRepository.save(new Event("NEW_OFFERS", true, "message NEW_OFFERS", "subject NEW_OFFERS"));
//        eventRepository.save(new Event("PASSWORD_CHANGED", false, "message PASSWORD_CHANGED", "subject PASSWORD_CHANGED"));
//
//    }
//}
