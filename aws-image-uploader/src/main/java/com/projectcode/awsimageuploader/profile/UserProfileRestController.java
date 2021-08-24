package com.projectcode.awsimageuploader.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.PageAttributes.MediaType;
import java.util.*;

@RestController
@CrossOrigin("*")// to remove CORS error - not a good practice to do in prod environment
@RequestMapping("api/u1/user-profile")
public class UserProfileRestController {
	
	private UserProfileService userprofileservice;
	
	
	@Autowired
	public UserProfileRestController(UserProfileService userprofileservice) {
		super();
		this.userprofileservice = userprofileservice;
	}

	@GetMapping
	public List<UserProfile> getUserProfiles(){
		return userprofileservice.getUserProfiles();
	}
	
	@PostMapping(
				path = "{userProfileId}/image/download",
				consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE,
				produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE
			)
	public void uploaduserProfileImage(@PathVariable("userProfileId") UUID userProfileId,
			@RequestParam("file") MultipartFile file) {
		try {
			userprofileservice.uploaduserProfileImage(userProfileId, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
