package com.goutam.chatroom_backend.sao;

import com.goutam.chatroom_backend.entity.Message;
import com.goutam.chatroom_backend.recorder.MessageRequestPayload;

public interface MessageSAO {
	Message userMassagesend(String roomId, MessageRequestPayload messageRequestPayload);
}
