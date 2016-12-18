
import evg.testt.service.AdminService;
import evg.testt.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:application-config-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Autowired
    RoleService roleService;

    @Test
    public void test(){

    }

//   @Test
//    public void addAdminTest() throws SQLException {
//
//        Admin tester = new Admin();
//        Person person = new Person();
//        person.setFirstName("firstName1");
//        person.setLastName("lastName1");
//        person.setMiddleName("middleName1");
//        person.setEmail(new Email("test1@test.ru"));
//        User user = new User();
//        user.setLogin("tester");
//        user.setPassword("tester");
//        user.setRole(roleService.getById(1));
//        tester.setPerson(person);
//        tester.setUser(user);
//        adminService.insert(tester);
//
//        Assert.assertNotNull(tester.getId());
//    }
//
//    @Test
//    public void findByIdTest() throws SQLException {
//        Admin admin = adminService.getById(1);
//        Assert.assertNotNull(admin);
//    }
//
//    @Test
//    public void deleteAdmin() throws SQLException {
//
//        Admin admin;
//            admin = adminService.getById(5);
//            adminService.delete(admin);
//
//        Assert.assertEquals("DELETED", admin.getPerson().getState().getState());
//    }

}
