package evg.testt.service;

import evg.testt.exception.BadAvatarNameException;
import evg.testt.model.Person;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public interface AvatarService {

    public void changePersonAvatar(MultipartFile avatarFile, Person person)
            throws IOException, SQLException, BadAvatarNameException;

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException;
}
