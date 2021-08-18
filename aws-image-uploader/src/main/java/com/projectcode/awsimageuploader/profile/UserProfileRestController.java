package com.projectcode.awsimageuploader.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
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
}
