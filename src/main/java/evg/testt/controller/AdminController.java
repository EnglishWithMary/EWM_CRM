package evg.testt.controller;

import evg.testt.model.Role;
import evg.testt.model.User;
import evg.testt.service.RoleService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class AdminController {

    @RequestMapping(value = "/admin")
    public String adminPage(){
        return "admin";
    }
/*
    @RequestMapping(value = "/studentAdd", method = RequestMethod.GET) // Entrance when "Add Student" button clicked
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.STUDENT_ADD); // Redirect to STUDENT_ADD page
    }

    // add /studentSave
    @RequestMapping(value = "/studentSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name,
                            @RequestParam(required = false) Integer id) {
        if (id == null) {

            Department addedDepartment = new Department(); // создается объект
            addedDepartment.setName(name); // присваевается имя
            try {
                departmentService.insert(addedDepartment); // добавляется в БД
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        else {
            Department depedit = null;
            try {
                depedit = departmentService.getById(id);
                depedit.setName(name);
                departmentService.update(depedit); // обновляет обїект в БД
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/dep"; // обновляет страницу со списком
    }
*/
}

