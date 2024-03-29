package com.api.movies.repository;

import com.api.movies.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query("select n from Notification n where n.active = true")
    List<Notification> findActiveNotifications();
}
