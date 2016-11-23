package evg.testt.controller.dashboard;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.*;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.*;
import evg.testt.model.*;
import evg.testt.service.*;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.Principal;
import java.sql.SQLException;

@Controller
@PropertySource(value = "classpath:amazon.properties")
public class AvatarUploadController {

    @Value("${amazonAccessKeyID}")
    private String amazonAccessKeyID;
    @Value("${amazonBacketName}")
    private String amazonBacketName;
    @Value("${amazonYourSecretAccessKey}")
    private String amazonYourSecretAccessKey;

    private Person updatePerson;
    private StringBuilder amazonBacket = new StringBuilder();
    private String newFileName;

    @Autowired
    UserService userService;

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
    public ModelAndView updateAvatar(@RequestParam(required = false) MultipartFile image, Principal principal) throws SQLException, IOException {
        this.amazonBacket = new StringBuilder("http://" + amazonBacketName + ".s3.amazonaws.com/");
        if (!image.isEmpty()) {
            this.updatePerson = personService.getPersonByUserLogin(principal.getName());
            if (!this.updatePerson.equals(null)) {
                changeAvatar(image,principal.getName());
            }
        }
        return new ModelAndView(JspPath.MANAGER_ADD);
    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }

    public void changeAvatar(MultipartFile avatarFile, String login) throws IOException, SQLException {
        //Convert Multipart To File for Amazon
        File newImgFile = multipartToFile(avatarFile);
        try {
            newFileName = updatePerson.getRegistrationDate().getTime() + "." + newImgFile.getName().split("\\.")[1];
        }
        catch (Exception exc){
            exc.printStackTrace();
            return;
        }
        //Get Image old URL. It will be deleted the next step
        String oldImgFile = updatePerson.getAvatarURL();
        //Delete old Avatar to Amazon
        if (oldImgFile != null && !oldImgFile.isEmpty()) {
            oldImgFile.replace(amazonBacket.toString(),"");
            if (!oldImgFile.isEmpty()){
                try {
                    deleteFromS3(oldImgFile);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                    /**
                     * TODO custom AmazonNotFindFileException
                     * */
                }
            }
        }
        //Upload new Avatar to Amazon
        uploadOnS3(newImgFile);
        //Set to person new Avatar Image URL
        updatePerson.setAvatarURL(amazonBacket.toString().concat(newFileName));
        //Update Person in DB
        personService.update(updatePerson);
        return;
    }

    public void uploadOnS3(File file) throws IOException, AmazonClientException {
        //Get access to Amazone S3
        AWSCredentials credentials = new BasicAWSCredentials(amazonAccessKeyID, amazonYourSecretAccessKey);
        AmazonS3 s3client = new AmazonS3Client(credentials);
        //Upload file
        try {
            s3client.putObject(
                    new PutObjectRequest(amazonBacketName, newFileName, file)
                            .withCannedAcl(CannedAccessControlList.PublicRead));
        }
        catch (Exception exc){
            exc.printStackTrace();
            /*
            * TODO custom AmazonFileUploadException
            * */
        }
        return;
    }

    public void deleteFromS3(String oldfile) throws IOException {
        //Get access to Amazone S3
        AWSCredentials credentials = new BasicAWSCredentials(amazonAccessKeyID, amazonYourSecretAccessKey);
        AmazonS3 s3client = new AmazonS3Client(credentials);
        //Delete file
        s3client.deleteObject(amazonBacketName, oldfile);
        return;
    }
}


