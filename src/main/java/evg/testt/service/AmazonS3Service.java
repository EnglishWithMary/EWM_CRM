package evg.testt.service;

import com.amazonaws.AmazonClientException;

import java.io.File;
import java.io.IOException;

public interface AmazonS3Service {

    public String uploadFileToAmazoneS3(File file, String newFileName) throws IOException, AmazonClientException;

    public void deleteFileFromAmazonS3(String fileName) throws IOException;

    public void createFolderOnAmazonS3(String folderName);

    public void deleteFolderOnAmazonS3(String folderName);
}
