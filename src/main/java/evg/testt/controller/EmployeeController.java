package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.apache.log4j.Logger;
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

@Controller
public class EmployeeController {

    Logger log = Logger.getLogger(EmployeeController.class);
    @Autowired
    SpringOvalValidator validator;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "empl")
    public ModelAndView showAll(@RequestParam int id) {
        Department department;
        try {
            department = departmentService.getById(id);
        } catch (SQLException e) {
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
                                    @ModelAttribute("id") Integer id, Model model) throws SQLException {
//      @Validated doesn't work
//        if, somehow, there is no such department
        if (!departmentService.isExists(id)) {
            return new ModelAndView(JspPath.HOME);
        }
        Department department = departmentService.getById(id);
        validator.validate(employee, result);
        if (!result.hasErrors()) {
            employee.setDepartment(department);
            employeeService.insert(employee);
            return showAll(id);
        } else {
            model.addAttribute("id", id);
            return new ModelAndView(JspPath.EMPLOYEE_ADD);
        }
    }

    @RequestMapping(value = "/emplEditSave", method = RequestMethod.POST)
    public ModelAndView saveEditedEmployee(@ModelAttribute("employee") @Validated Employee employee,
                                           BindingResult result, Model model) throws SQLException {
//        if, somehow, there is no such department, so:
        if (!employeeService.isExists(employee.getId())) {
            return new ModelAndView(JspPath.HOME);
        }
        validator.validate(employee, result);
        Department department = employeeService.getById(employee.getId()).getDepartment();
        if (!result.hasErrors()) {
            employee.setDepartment(department);
            employeeService.update(employee);
            return showAll(department.getId());
        } else {
            return new ModelAndView(JspPath.EMPLOYEE_EDIT);
        }
    }

    @RequestMapping(value = "/emplEdit", method = RequestMethod.GET)
    public ModelAndView editEmployee(@RequestParam Integer id) throws SQLException {
        if (employeeService.isExists(id)) {
            return new ModelAndView(JspPath.EMPLOYEE_EDIT, "employee", employeeService.getById(id));
        } else {
            return new ModelAndView(JspPath.HOME);
        }
    }

    @RequestMapping(value = "/emplDelete", method = RequestMethod.GET)
    public ModelAndView delExistOne(@RequestParam Integer id) throws SQLException {
        if (!employeeService.isExists(id)) {
            return new ModelAndView(JspPath.HOME);
        }
        Employee employee = employeeService.getById(id);
        Department department = employee.getDepartment();
        department.getEmployees().remove(employee);
        departmentService.update(department);
        return showAll(department.getId());
    }
}
