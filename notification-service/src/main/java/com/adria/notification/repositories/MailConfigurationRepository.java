package com.adria.notification.repositories;

import com.adria.notification.models.entities.MailConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailConfigurationRepository extends JpaRepository<MailConfiguration, Long> {
}
