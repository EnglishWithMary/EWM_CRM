package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
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

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name) {
        Department addedDepartment = new Department();
        addedDepartment.setName(name);
        try {
            departmentService.insert(addedDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depEdit", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam(required = true) Integer id) {
        Department department = null;
        try {
            department = departmentService.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_EDIT, "department", department);
    }

    @RequestMapping(value = "/depEditSave", method = RequestMethod.POST)
    public String editExistOne(@RequestParam(required = true) Integer id, @RequestParam(required = true) String param) {
        Department department;
        try{
            department = departmentService.getById(id);
            department.setName(param);
            departmentService.update(department);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depDel", method = RequestMethod.GET)
    public ModelAndView showDel() {
        return new ModelAndView(JspPath.DEPARTMENT_DEL);
    }


    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String delExistOne(@RequestParam(required = true) Integer id) {
        List<Employee> list;
        List<Employee> deletedList = null;
        try{
            list = departmentService.getById(id).getEmployees();
            deletedList = list;
            list = null;
            departmentService.delete(departmentService.getById(id));
            for(Employee empl:deletedList){
                employeeService.delete(empl);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return "redirect:/dep";
    }

    /*@RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String delExistOne(@RequestParam(required = true) String name) {

        return "redirect:/dep";
    }*/


}
