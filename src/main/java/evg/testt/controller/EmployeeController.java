package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
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

    @RequestMapping(value = "empl", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView showAll(@RequestParam int id){
        Department department;
        try{
            department = departmentService.getById(id);
        }catch (Exception e){
            department = null;
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
    }

    @RequestMapping(value = "/emplAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam Integer id) {
        return new ModelAndView(JspPath.EMPLOYEE_ADD, "id", id);
    }

    @RequestMapping(value = "/saveEmpl", method = RequestMethod.POST)
    public ModelAndView saveEmloyee(
            @RequestParam Integer id,
            @RequestParam String firstName,
            @RequestParam String secondName) {

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

    @RequestMapping(value = "/emplDelete", method = RequestMethod.GET)
    public ModelAndView delExistOne(@RequestParam(required = true) Integer id) {
        Department department;
        Employee employee;
        List<Employee> list;

        try{
            employee = employeeService.getById(id);
            department = employee.getDepartment();
            list = department.getEmployees();
            list.remove(employee);
            departmentService.update(department);

        }catch (SQLException e){
            department = null;
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
    }

    @RequestMapping(value = "/emplEditSave", method = RequestMethod.POST)
    public ModelAndView saveEditedEmployee(@Validated Employee employee) {

        Employee newEmployee;

//        List<Employee> list;
        Department department;

        try {
            newEmployee = employeeService.getById(employee.getId());
            newEmployee.setFirstName(employee.getFirstName());
            newEmployee.setSecondName(employee.getSecondName());

            employeeService.update(newEmployee);
            department = newEmployee.getDepartment();

        } catch (SQLException e) {
            department = null;
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
    }

    @RequestMapping(value = "/emplEdit", method = RequestMethod.GET)
    public ModelAndView editEmployee(@RequestParam(required = true) Integer id) {
        Employee employee;
        try {
            employee = employeeService.getById(id);
        } catch (SQLException e) {
            employee = null;
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_EDIT, "employee", employee);
    }

}
