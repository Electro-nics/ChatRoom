package com.goutam.chatroom_backend.recorder;

public record MessageRequestPayload(
		String content,
		String sender,
		String roomId
		) {

}
