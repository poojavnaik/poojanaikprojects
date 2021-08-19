package com.projectcode.awsimageuploader.profile;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public void uploaduserProfileImage(UUID userProfileId, MultipartFile file) {
		/*
		 * 1. User exists in database
		 * 2. If the file to be loaded not empty
		 * 3. If the file is an image
		 * 4. Store image in Amazon S3 and update with S3 image link
		 */
		
	}

}
