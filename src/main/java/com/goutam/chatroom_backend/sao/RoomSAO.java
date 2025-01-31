package com.goutam.chatroom_backend.sao;

import java.util.List;

import com.goutam.chatroom_backend.entity.Message;
import com.goutam.chatroom_backend.entity.Room;

public interface RoomSAO {
// create room
	String createChatRoom(String roomId, String username);
	
	// Get Room
	Room getRoomIndivisual(String roomId, String username);
	List<Message> getAllMessage(String roomId);
	
}
