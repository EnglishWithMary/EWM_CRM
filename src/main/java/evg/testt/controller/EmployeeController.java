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

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by clay on 25.09.16.
 */

@Controller
public class EmployeeController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/empl", method = RequestMethod.POST)
    public ModelAndView showAll(@RequestParam (required = true) Integer id){
        Department department;
        try{
            department = departmentService.getById(id);
        }catch (Exception e){
            department = null;
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
    }

    @RequestMapping(value = "/emplAdd", method = RequestMethod.POST)
    public ModelAndView showAdd(@RequestParam(required = true) Integer id) {
        return new ModelAndView(JspPath.EMPLOYEE_ADD, "id", id);
    }

    @RequestMapping(value = "/saveEmpl", method = RequestMethod.POST)
    public ModelAndView saveEmloyee(
            @RequestParam(required = true) Integer id,
            @RequestParam(required = true) String firstName,
            @RequestParam(required = true) String secondName) {

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        List<Employee> list;
        Department department;

        try {
            department = departmentService.getById(id);
            employee.setDepartment(department);
            list = department.getEmployees();
            list.add(employee);
            employeeService.update(employee);
            departmentService.update(department);
        } catch (SQLException e) {
            department = null;
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
    }

    @RequestMapping(value = "/emplDelete", method = RequestMethod.POST)
    public String delExistOne(@RequestParam(required = true) Integer id, @RequestParam(required = true) Integer dep) {
        Department department;
        Employee employee;
        List<Employee> list;
        try{
            employee = employeeService.getById(id);
            department = departmentService.getById(dep);
            list = department.getEmployees();
            list.remove(employee);
//            employeeService.delete(employee);
//            employeeService.removeById(id);
//            employeeService.update(employee);
            departmentService.update(department);
            employeeService.delete(employee);
        }catch (SQLException e){
            e.printStackTrace();
        }

//        try{
//            department = departmentService.getById(dep);
//        }catch (SQLException e){
//            department = null;
//            e.printStackTrace();
//        }
        return "redirect:/dep";
    }


}
