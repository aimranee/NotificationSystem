package com.adria.notification.repositories;

import com.adria.notification.models.entities.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TemplateRepository extends JpaRepository<Template, UUID>{
    Optional<Template> findById(UUID id);
    Template findByType(String type);
    boolean existsByType(String type);
    boolean existsById(UUID id);
    List<Template> findAllByType(String type);
}