package com.projectcode.awsimageuploader.Data;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.projectcode.awsimageuploader.profile.UserProfile;

@Repository
public class InMemoryDataStore {

	private static ArrayList<UserProfile> userprofiles = new ArrayList<UserProfile>();
	static {
		userprofiles.add(new UserProfile(UUID.randomUUID(), "James", ""));
		userprofiles.add(new UserProfile(UUID.randomUUID(), "Hagred", ""));
		userprofiles.add(new UserProfile(UUID.randomUUID(), "Mona", ""));
	}
	public static ArrayList<UserProfile> getUserprofiles() {
		return userprofiles;
	}
	
	
	
	
}
