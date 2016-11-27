package evg.testt.service.impl;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import evg.testt.service.AmazonS3Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@PropertySource(value = "classpath:amazon.properties")
public class AmazonS3ServiceImpl implements AmazonS3Service {

    @Value("${amazonAccessKeyID}")
    private String amazonAccessKeyID;
    @Value("${amazonBacketName}")
    private String amazonBacketName;
    @Value("${amazonYourSecretAccessKey}")
    private String amazonYourSecretAccessKey;

    private final String SUFFIX = "/";

    @Override
    public String uploadFileToAmazoneS3(File file, String newFileName) throws IOException, AmazonClientException {

        AWSCredentials credentials = new BasicAWSCredentials(amazonAccessKeyID, amazonYourSecretAccessKey);
        AmazonS3 s3client = new AmazonS3Client(credentials);

        StringBuilder amazonBacket = new StringBuilder("http://" + amazonBacketName + ".s3.amazonaws.com/");

        s3client.putObject(
                new PutObjectRequest(amazonBacketName, newFileName, file)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonBacket.append(newFileName).toString();
    }

    @Override
    public void deleteFileFromAmazonS3(String fileName) throws IOException, AmazonClientException{

        AWSCredentials credentials = new BasicAWSCredentials(amazonAccessKeyID, amazonYourSecretAccessKey);
        AmazonS3 s3client = new AmazonS3Client(credentials);

        StringBuilder amazonBacket = new StringBuilder("http://" + amazonBacketName + ".s3.amazonaws.com/");

        if (fileName != null && !fileName.isEmpty()) {

            //Delete from file path amazon part fileName
            fileName = fileName.replace(amazonBacket.toString(), "");

            s3client.deleteObject(amazonBacketName, fileName);
        }
    }

    @Override
    public void createFolderOnAmazonS3(String folderName) throws AmazonClientException{

        AWSCredentials credentials = new BasicAWSCredentials(amazonAccessKeyID, amazonYourSecretAccessKey);
        AmazonS3 s3client = new AmazonS3Client(credentials);

        StringBuilder amazonBacket = new StringBuilder("http://" + amazonBacketName + ".s3.amazonaws.com/");

        // create meta-data for your folder and set content-length to 0
        ObjectMetadata metadata = new ObjectMetadata();

        metadata.setContentLength(0);

        // create empty content
        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

        PutObjectRequest putObjectRequest = new PutObjectRequest(amazonBacketName,
                folderName + SUFFIX, emptyContent, metadata);

        // send request to S3 to create folder
        s3client.putObject(putObjectRequest);

    }

    @Override
    public void deleteFolderOnAmazonS3(String folderName) throws AmazonClientException {

        AWSCredentials credentials = new BasicAWSCredentials(amazonAccessKeyID, amazonYourSecretAccessKey);
        AmazonS3 s3client = new AmazonS3Client(credentials);

        StringBuilder amazonBacket = new StringBuilder("http://" + amazonBacketName + ".s3.amazonaws.com/");

        List<S3ObjectSummary> fileList= s3client.listObjects(amazonBacketName, folderName).getObjectSummaries();

        for (S3ObjectSummary file : fileList) {
            s3client.deleteObject(amazonBacketName, file.getKey());
        }

        s3client.deleteObject(amazonBacketName, folderName);
    }
}
