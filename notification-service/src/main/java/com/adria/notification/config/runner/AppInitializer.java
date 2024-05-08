package com.adria.notification.config.runner;

//import com.adria.notification.models.entities.ADTConst;
//import com.adria.notification.models.entities.EmailProvider;
//import com.adria.notification.models.entities.Event;
//import com.adria.notification.models.entities.Recipient;
//import com.adria.notification.models.enums.ADTConstCode;
//import com.adria.notification.repositories.ADTConstRepository;
//import com.adria.notification.repositories.EmailProviderRepository;
//import com.adria.notification.repositories.EventRepository;
//import com.adria.notification.repositories.RecipientRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class AppInitializer implements CommandLineRunner {
//
//    private final RecipientRepository recipientRepository;
//    private final EventRepository eventRepository;
//    private final EmailProviderRepository emailProviderRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
////        Save Recipients
//        recipientRepository.save(new Recipient("Alice", "Smith", "aimrane.essakhi@gmail.com", "9876543210", "xyz456"));
//        recipientRepository.save(new Recipient("John", "Doe", "aimrane2002@gmail.com", "1234567890", "abc123"));
//
////        Save Events
////        eventRepository.save(new Event("IMPORTANT_TRANSACTION", true, "email"));
////        eventRepository.save(new Event("NEWS", true, "email"));
////        eventRepository.save(new Event("OTP", false, "sms"));
////        eventRepository.save(new Event("NEW_OFFERS", true, "email"));
////        eventRepository.save(new Event("PASSWORD_CHANGED", false, "email"));
//
//        emailProviderRepository.save(new EmailProvider("primary", "smtp.gmail.com", "587", "instaaimrane@gmail.com", "vqypgfgwqexsumxp", "smtp", true, true, "smtp.gmail.com"));
//    }
//}
