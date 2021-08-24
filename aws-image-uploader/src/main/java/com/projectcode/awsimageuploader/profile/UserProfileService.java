package com.projectcode.awsimageuploader.profile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.projectcode.awsimageuploader.bucket.BucketName;
import com.projectcode.awsimageuploader.filestore.FileStore;



@Service
public class UserProfileService {
	
	private UserProfileDataAccessSerrvice userProfileDataaccessService;
	// FileStore
	private FileStore filestrore;

	@Autowired
	public UserProfileService(UserProfileDataAccessSerrvice userProfileDataaccessService, FileStore filestrore) {
		super();
		this.userProfileDataaccessService = userProfileDataaccessService;
		this.filestrore = filestrore;
	}
	
	List<UserProfile> getUserProfiles(){
		return userProfileDataaccessService.getUserProfiles();
	}

	public void uploaduserProfileImage(UUID userProfileId, MultipartFile file) throws Exception {
		/*
		 * 1. User exists in database
		 * 2. If the file to be loaded not empty
		 * 3. If the file is an image
		 * 4. Store image in Amazon S3 and update with S3 image link
		 * 5. MetaData to pass in the FileStore
		 */
		if (file.isEmpty()) {
			throw new Exception("File is empty");
		}

		
		if (!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(), ContentType.IMAGE_PNG.getMimeType(), ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
			throw new Exception("File is not an image");
		}
		
		for (int i = 0 ; i < getUserProfiles().size(); i++) {
			
			UUID sampleId = getUserProfiles().get(i).getUserProfileId();
			
			if (!((userProfileId.toString().trim()).equals(sampleId.toString().trim()))) {
				throw new Exception("User doesnot exist");
			}
			else {
				break;
			}
		}
		//Metadata
		Map<String, String> metadata = new HashMap<>();
		metadata.put("Content-Type", file.getContentType());
		metadata.put("File-Size", String.valueOf(file.getSize()));
		metadata.put("File-Name", file.getName());
		
		//To store image in S3 and save
		String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), userProfileId);
		String fileName = String.format("%s-%s", file.getName(), UUID.randomUUID());
		
		filestrore.save(path, fileName, Optional.of(metadata), file.getInputStream());
				
	}

}
