package com.adria.notification.repository;

import com.adria.notification.model.entities.MailConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailConfigurationRepository extends JpaRepository<MailConfiguration, Long> {
}
