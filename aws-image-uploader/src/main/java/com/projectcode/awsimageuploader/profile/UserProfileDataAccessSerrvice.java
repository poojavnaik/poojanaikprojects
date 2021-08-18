package com.projectcode.awsimageuploader.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projectcode.awsimageuploader.Data.InMemoryDataStore;

@Repository
public class UserProfileDataAccessSerrvice {
	
	private InMemoryDataStore data;
	
	@Autowired
	public UserProfileDataAccessSerrvice(InMemoryDataStore data) {
		this.data = data;
	}
	
	List<UserProfile> getUserProfiles(){
		return data.getUserprofiles();
	}
	

}
