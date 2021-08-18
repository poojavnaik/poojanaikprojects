package com.projectcode.awsimageuploader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {
	
	@Bean
	public AmazonS3 s3() {
		
		AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAZOSBJU6PFPIZT4QP", "EOixAcM/w00/v3GUejsWw1VT/ps1WPCe+pBesh0A");
		return AmazonS3ClientBuilder
				.standard()
				.withRegion("us-east-1")///code fix for AWS File error
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
		
	}
	

}
