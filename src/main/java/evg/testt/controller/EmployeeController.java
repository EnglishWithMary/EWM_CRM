package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    SpringOvalValidator validator;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "empl", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView showAll(@RequestParam int id){
        Department department;
        try{
            department = departmentService.getById(id);
        }catch (SQLException e){
            department = null;
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
    }

    @RequestMapping(value = "/emplAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(Model model, @RequestParam int id) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("id", id);
        return new ModelAndView(JspPath.EMPLOYEE_ADD);
    }

    @RequestMapping(value = "/saveEmpl", method = RequestMethod.POST)
    public ModelAndView saveEmloyee(@ModelAttribute("employee") @Validated Employee employee,
                                    BindingResult result,
                                    @ModelAttribute("id") Integer id, Model model) throws SQLException{
//      @Validated doesn't work
        Department department = departmentService.getById(id);
        validator.validate(employee, result);
        if(department!=null){
            if(!result.hasErrors()){
                employee.setDepartment(department);
                employeeService.insert(employee);
                return showAll(id);
            }else{
                return new ModelAndView(JspPath.EMPLOYEE_ADD);
            }
        }else{
            return new ModelAndView(JspPath.DEPARTMENT_ALL);
        }
//        Employee employee = new Employee();
//        employee.setFirstName(firstName);
//        employee.setSecondName(secondName);
//        List<Employee> list;
//        Department department;
//
//        try {
//            department = departmentService.getById(id);
//            employee.setDepartment(department);
//            list = department.getEmployees();
//            list.add(employee);
//            employeeService.update(employee);
//            departmentService.update(department);
//        } catch (SQLException e) {
//            department = null;
//            e.printStackTrace();
//        }
//        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
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
