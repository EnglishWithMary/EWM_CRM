package evg.testt.controller;

import evg.testt.oval.SpringOvalValidator;
import evg.testt.util.JspPath;
import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
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

    @RequestMapping(value = "/depAdd")
    public ModelAndView showAdd(Model model) {
        model.addAttribute(new Department());
        model.addAttribute("violations", Collections.EMPTY_LIST);
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public ModelAndView addNewOne(@ModelAttribute("department") @Validated Department department,
                                  BindingResult bindingResult, Model model) {
//        Making custom validator helps
        Validator validator = new SpringOvalValidator();
        validator.validate(department, bindingResult);
        if (!bindingResult.hasErrors()) {
            try {
                departmentService.insert(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showAll();
        } else {
//            model.addAttribute(department);
//            model.addAttribute("violations", violations);
            return new ModelAndView(JspPath.DEPARTMENT_ADD);
        }
    }

    @RequestMapping(value = "/depEdit", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam int id) {
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
    public String delExistOne(@RequestParam int id) {
//        Department department;
//        List<Employee> list;
        try {
//            department = departmentService.getById(id);
//            list = department.getEmployees();
//            list.clear();
//            departmentService.update(department);
            departmentService.delete(departmentService.getById(id));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "forward:/dep";
    }
}
