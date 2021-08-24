package com.projectcode.awsimageuploader.filestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Component
public class FileStore {
	
	private final AmazonS3 s3;

	@Autowired
	public FileStore(AmazonS3 s3) {
		super();
		this.s3 = s3;
	}
	
	//InputStream path goes and saves to Amazon S3 Bucket
	public void save(String path, String fileName, Optional<Map<String, String>> optionalMetaData, InputStream input) {
		ObjectMetadata metadata = new ObjectMetadata();
		optionalMetaData.ifPresent(map -> {
			if (!map.isEmpty()) {
				map.forEach(metadata::addUserMetadata);
			}
		});
		try {
			s3.putObject(path, fileName, input, metadata);
		}
		catch(AmazonServiceException e) {
			throw new IllegalStateException("Failed to store file to S3", e);
		}
	}
}
