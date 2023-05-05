package com.wecureit.wecureit_service.repository;

import com.wecureit.wecureit_service.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository  extends JpaRepository<Room, Integer> {
}
