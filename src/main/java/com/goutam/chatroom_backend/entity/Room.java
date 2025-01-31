package com.goutam.chatroom_backend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Document(collection = "room")

public class Room {
	@Id
	private String id;
	
	private String roomId;
	private String username;
	
	
	
	public Room() {
	}
	List<String> guest= new ArrayList<String>();
	
//	@OneToMany(
//			mappedBy = "chatroom",
//			cascade = CascadeType.ALL,
//			fetch = FetchType.LAZY
//			)
	List<Message> messages= new ArrayList<Message>();
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getGuest() {
		return guest;
	}
	public void setGuest(List<String> guest) {
		this.guest = guest;
	}
	@Override
	public int hashCode() {
		return Objects.hash(guest, messages, roomId, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(guest, other.guest) && Objects.equals(messages, other.messages)
				&& Objects.equals(roomId, other.roomId) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", username=" + username + ", guest=" + guest + ", messages=" + messages
				+ "]";
	}
	
	
	
	
}

