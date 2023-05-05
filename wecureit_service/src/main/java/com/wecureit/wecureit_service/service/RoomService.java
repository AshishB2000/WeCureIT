package com.wecureit.wecureit_service.service;

import com.wecureit.wecureit_service.model.Room;
import com.wecureit.wecureit_service.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoom(int id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }
}
