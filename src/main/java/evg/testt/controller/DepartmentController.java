package evg.testt.controller;

import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.omg.PortableInterceptor.ForwardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import java.sql.SQLException;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/dep")
    public ModelAndView showAll() {
        List<Department> departments;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/depAdd")//, method = RequestMethod.GET)
    public ModelAndView showAdd(Model model) {
        model.addAttribute(new Department());
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@Validated Department department, Model model) {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(department);
        model.addAttribute(violations); /*  return "forward:/dep";*/
        if (violations.isEmpty()) {
            try {
                departmentService.insert(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "forward:/dep";
    }

    @RequestMapping(value = "/depEdit", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam(required = true) Integer id) {
        Department department;
        try {
            department = departmentService.getById(id);
        } catch (SQLException e) {
            department = null;
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_EDIT, "department", department);
    }

    @RequestMapping(value = "/depEditSave", method = RequestMethod.POST)
    public String editExistOne(@Validated Department department,
                               BindingResult bindingResult) {
//        if(bindingResult.hasErrors()){
//            return "/depEdit";
//        }
        try {
            Department dep = departmentService.getById(department.getId());
            dep.setName(department.getName());
            departmentService.update(dep);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "forward:/dep";
    }

    @RequestMapping(value = "/depDel", method = RequestMethod.GET)
    public ModelAndView showDel() {
        return new ModelAndView(JspPath.DEPARTMENT_DEL);
    }

    @RequestMapping(value = "/depDelete", method = RequestMethod.GET)
    public String delExistOne(@RequestParam(required = true) Integer id) {
        Department department;
        List<Employee> list;
        try {
            department = departmentService.getById(id);
            list = department.getEmployees();
            list.clear();
            departmentService.update(department);
            departmentService.delete(departmentService.getById(id));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "forward:/dep";
    }
}
