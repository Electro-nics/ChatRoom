package com.goutam.chatroom_backend.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goutam.chatroom_backend.entity.Message;
import com.goutam.chatroom_backend.entity.Room;
import com.goutam.chatroom_backend.exception.ResourceNotFoundException;
import com.goutam.chatroom_backend.recorder.MessageRequestPayload;
import com.goutam.chatroom_backend.repository.RoomRepository;
import com.goutam.chatroom_backend.sao.MessageSAO;
@Service
public class ChatService  implements MessageSAO{
	
	@Autowired
	RoomRepository roomRepository ;

	@Override
	public Message userMassagesend(String roomId, MessageRequestPayload messageRequestPayload) {
		Room userRoom= roomRepository.findByRoomId(messageRequestPayload.roomId());
		if(userRoom==null) {
			throw new ResourceNotFoundException("Room id %s is not found!!".formatted(messageRequestPayload.roomId()));
		}
		Message message = new Message();
		message.setContent(messageRequestPayload.content());
		message.setSender(messageRequestPayload.sender());
		message.setTimeStamp(LocalDateTime.now());
		userRoom.getMessages().add(message);
		roomRepository.save(userRoom);
		
		return message;
	}

}
