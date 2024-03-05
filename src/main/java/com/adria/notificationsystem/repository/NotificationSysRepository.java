package com.adria.notificationsystem.repository;

import com.adria.notificationsystem.models.NotificationSys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationSysRepository extends JpaRepository<NotificationSys,Integer> {
}
