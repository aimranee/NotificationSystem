package com.adria.notificationsystem.repository;

import com.adria.notificationsystem.model.entities.MailConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailConfigurationRepository extends JpaRepository<MailConfiguration, Long> {
}
