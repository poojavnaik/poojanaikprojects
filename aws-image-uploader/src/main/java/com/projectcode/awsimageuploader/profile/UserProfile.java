package com.projectcode.awsimageuploader.profile;

import java.util.*;

public class UserProfile{
	
	private UUID uprofileId;
	private String username;
	private String uprofilelink;
	public UserProfile(UUID uprofileId, String username, String uprofilelink) {
		super();
		this.uprofileId = uprofileId;
		this.username = username;
		this.uprofilelink = uprofilelink;
	}
	public UUID getUprofileId() {
		return uprofileId;
	}
	public void setUprofileId(UUID uprofileId) {
		this.uprofileId = uprofileId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUprofilelink() {
		return uprofilelink;
	}
	public void setUprofilelink(String uprofilelink) {
		this.uprofilelink = uprofilelink;
	}
	@Override
	public int hashCode() {
		return Objects.hash(uprofileId, uprofilelink, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		return Objects.equals(uprofileId, other.uprofileId) && Objects.equals(uprofilelink, other.uprofilelink)
				&& Objects.equals(username, other.username);
	}
	
	
}
