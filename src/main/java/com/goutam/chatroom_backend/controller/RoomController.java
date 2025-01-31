package com.goutam.chatroom_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goutam.chatroom_backend.entity.Message;
import com.goutam.chatroom_backend.entity.Room;
import com.goutam.chatroom_backend.services.RoomService;

@RestController
@RequestMapping("v1/api/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;
	// create rooms
	@PostMapping("/create-room")
	public ResponseEntity<String> createRoom(@RequestParam("roomId")String roomId,
			@RequestParam("username") String username){
		
		String roomRequest= roomService.createChatRoom(roomId,username);
		
		return new ResponseEntity<>(roomRequest,HttpStatus.CREATED);

		
	}
	// getRoom
	@GetMapping("/join-room")
	public ResponseEntity<Room> chatroomDetails(@RequestParam("roomId") String roomId,
			@RequestParam("usernamre") String username
			){
		Room userRoom=roomService.getRoomIndivisual(roomId, username);
		return new ResponseEntity<>(userRoom,HttpStatus.OK);
	}
	
	//getMessagesOfRoom
	@GetMapping("/user-messages")
	public ResponseEntity<List<Message>> getRoomMessage(@RequestParam("roomid") String roomid){
		List<Message> usermsg=roomService.getAllMessage(roomid);
		return new ResponseEntity<>(usermsg,HttpStatus.OK);
	}
}
