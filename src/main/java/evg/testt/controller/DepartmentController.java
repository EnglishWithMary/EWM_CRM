package evg.testt.controller;

import evg.testt.oval.SpringOvalValidator;
import evg.testt.util.JspPath;
import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
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
    SpringOvalValidator validator;

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
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public ModelAndView addNewOne(@ModelAttribute("department") @Validated Department department,
                                  BindingResult bindingResult, Model model) {
        validator.validate(department, bindingResult);
        if (!bindingResult.hasErrors()) {
            try {
                departmentService.insert(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showAll();
        } else {
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
    public ModelAndView editExistOne(@ModelAttribute("department") @Validated Department department,
                                     BindingResult result) {
//        if, somehow, the department id is null
        if(department.getId()==null){
            return showAll();
        }
        validator.validate(department, result);
        if (!result.hasErrors()) {
            try {
                Department dep = departmentService.getById(department.getId());
                dep.setName(department.getName());
                departmentService.update(dep);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showAll();
        } else {
            return new ModelAndView(JspPath.DEPARTMENT_EDIT, "department", department);
        }
    }

    @RequestMapping(value = "/depDelete", method = RequestMethod.GET)
    public ModelAndView delExistOne(@RequestParam int id) {
        try {
            departmentService.delete(departmentService.getById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL);
    }
}
