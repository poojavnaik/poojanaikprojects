package com.projectcode.awsimageuploader.bucket;

public enum BucketName {

	PROFILE_IMAGE("proj1-image-upload-1");
	private final String bucketName;
	
	 BucketName(String bucketName) {
		 this.bucketName = bucketName;
	}

	public String getBucketName() {
		return bucketName;
	}

	 
	
	 
	
}
