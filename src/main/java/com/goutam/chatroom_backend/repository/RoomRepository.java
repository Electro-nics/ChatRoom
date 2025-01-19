package com.goutam.chatroom_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.goutam.chatroom_backend.entity.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
	Room findByRoomId(String roomId);
}
