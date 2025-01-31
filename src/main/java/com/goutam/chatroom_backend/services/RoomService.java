package com.goutam.chatroom_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goutam.chatroom_backend.entity.Message;
import com.goutam.chatroom_backend.entity.Room;
import com.goutam.chatroom_backend.exception.DuplicateResourceException;
import com.goutam.chatroom_backend.exception.ResourceNotFoundException;
import com.goutam.chatroom_backend.repository.RoomRepository;
import com.goutam.chatroom_backend.sao.RoomSAO;
@Service
public class RoomService implements RoomSAO{
	@Autowired
	private RoomRepository roomRepository;
	@Override
	public String createChatRoom(String roomId, String username) {
		if(roomRepository.findByRoomId(roomId)!= null) {
			throw new DuplicateResourceException("Room is already created with room id %s".formatted(roomId));
		}
		Room userRoom= new Room();
		userRoom.setRoomId(roomId);
		userRoom.setUsername(username);
		roomRepository.save(userRoom);
		// TODO Auto-generated method stub
		return "Room created successfully !!";
	}

	@Override
	public Room getRoomIndivisual(String roomId, String username) {
		Room userRoom= roomRepository.findByRoomId(roomId);
		if(roomId==null) {
			throw new ResourceNotFoundException("Room id %s is not found".formatted(roomId));
		}
		userRoom.setGuest(List.of(username));
		roomRepository.save(userRoom);
		
		// TODO Auto-generated method stub
		
		return userRoom;
	}

	@Override
	public List<Message> getAllMessage(String roomid) {
		Room roomdetails=roomRepository.findByRoomId(roomid);
		if (roomdetails==null) {
			throw new ResourceNotFoundException("room id %s not found".formatted(roomid));
		}
		List<Message> usermessList =roomdetails.getMessages();
		
		
		return usermessList;
		
	}
	
	
	
	
}
