package com.goutam.chatroom_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.goutam.chatroom_backend.entity.Message;
import com.goutam.chatroom_backend.recorder.MessageRequestPayload;

import com.goutam.chatroom_backend.sao.MessageSAO;

@Controller
public class Chatcontroller {
	@Autowired
	private MessageSAO messageSAO;
	
	@MessageMapping("/sendMessage/{roomId}")
	@SendTo("/topic/room/{roomId}")
	public Message sendMessage(
			@DestinationVariable String roomId,
			@RequestBody MessageRequestPayload messageRequestPayload
			) {
		Message userMessage = messageSAO.userMassagesend(roomId, messageRequestPayload);
		return userMessage;
	}

}
