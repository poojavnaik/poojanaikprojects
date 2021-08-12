package com.projectcode.awsimageuploader.filestore;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.s3.AmazonS3;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

public class FileStore {
	
	private final AmazonS3 s3;

	@Autowired
	public FileStore(AmazonS3 s3) {
		super();
		this.s3 = s3;
	}
	
	//InputStream path goes and saves to Amazon S3 Bucket
	public void save(String path, String fileName, Optional<Map<String, String>> optionalMetaData, InputStream input) {
		
		try {
			
			s3.putObject(path, fileName, input, metadata)
		}
		
	}

}
