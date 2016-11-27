package evg.testt.service.impl;

import evg.testt.exception.BadAvatarNameException;
import evg.testt.model.Person;
import evg.testt.service.AmazonS3Service;
import evg.testt.service.AvatarService;
import evg.testt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@Service
public class AvatarServiceImpl implements AvatarService {

    @Autowired
    AmazonS3Service amazonS3Service;
    @Autowired
    PersonService personService;

    public void changePersonAvatar(MultipartFile avatarFile, Person person)
            throws IOException, SQLException, BadAvatarNameException {

        String newFileName = person.getRegistrationDate().getTime() + "." +avatarFile.getOriginalFilename().toString().split("\\.")[1];

        //Get Image old URL. It will be deleted the next step
        String oldImgFile = person.getAvatarURL();

        File file = multipartToFile(avatarFile);

        String linkToFile;
        //Delete old Avatar to Amazon
        if (oldImgFile != null && !oldImgFile.isEmpty()) {

            amazonS3Service.deleteFileFromAmazonS3(oldImgFile);

            linkToFile = amazonS3Service.uploadFileToAmazoneS3(file, newFileName);

            person.setAvatarURL(linkToFile);

            //Update Person in DB
            personService.update(person);
        }
        return;
    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
}
