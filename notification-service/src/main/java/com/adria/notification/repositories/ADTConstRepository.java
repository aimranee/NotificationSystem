package com.adria.notification.repositories;

import com.adria.notification.models.entities.ADTConst;
import com.adria.notification.models.enums.ADTConstCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ADTConstRepository extends JpaRepository<ADTConst, UUID> {
    ADTConst save(ADTConst adtConst);
    Optional<ADTConst> findByCode(ADTConstCode code);
    boolean existsByCode(ADTConstCode code);
    Optional<ADTConst> findById(UUID id);
    List<ADTConst> findAllByCodeIn(List<ADTConstCode> codes);
    Optional<ADTConst> findADTConstByCode(ADTConstCode code);
}
