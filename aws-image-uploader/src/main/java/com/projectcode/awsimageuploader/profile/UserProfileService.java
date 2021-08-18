package com.projectcode.awsimageuploader.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
	
	private UserProfileDataAccessSerrvice userProfileDataaccessService;

	@Autowired
	public UserProfileService(UserProfileDataAccessSerrvice userProfileDataaccessService) {
		super();
		this.userProfileDataaccessService = userProfileDataaccessService;
	}
	
	List<UserProfile> getUserProfiles(){
		return userProfileDataaccessService.getUserProfiles();
	}

}
