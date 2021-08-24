package com.projectcode.awsimageuploader.profile;

import java.util.*;

public class UserProfile{
	
	private UUID userProfileId;
	private String username;
	private String uprofilelink;
	public UserProfile(UUID userProfileId, String username, String uprofilelink) {
		
		this.userProfileId = userProfileId;
		this.username = username;
		this.uprofilelink = uprofilelink;
	}
	public UUID getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(UUID userProfileId) {
		this.userProfileId = userProfileId;
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
		return Objects.hash(userProfileId, uprofilelink, username);
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
		return Objects.equals(userProfileId, other.userProfileId) && Objects.equals(uprofilelink, other.uprofilelink)
				&& Objects.equals(username, other.username);
	}
	
	
}
