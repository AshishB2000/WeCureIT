package com.wecureit.wecureit_service.controller;

import com.wecureit.wecureit_service.model.Facility;
import com.wecureit.wecureit_service.model.Room;
import com.wecureit.wecureit_service.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        return ResponseEntity.ok().body(roomService.createRoom(room));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(roomService.getRoom(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") int id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok().body("Deleted room id: "+id);
    }

    @PutMapping
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        return ResponseEntity.ok().body(roomService.updateRoom(room));
    }
}
