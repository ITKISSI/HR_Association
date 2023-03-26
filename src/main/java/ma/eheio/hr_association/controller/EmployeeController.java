package ma.eheio.hr_association.controller;

import ma.eheio.hr_association.model.Employee;
import ma.eheio.hr_association.repository.EmployeeProxy;
import ma.eheio.hr_association.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String home(Model model)
    {
        Iterable<Employee> employees=employeeService.getEmployees();
        model.addAttribute("employees",employees);

        return "home";
    }
    @GetMapping("/addemp")
    public String addemp(Model model)
    {
        model.addAttribute("employee",new Employee());
        return "add";
    }

    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView delete(@PathVariable("id") final  int id)
    {
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/");
    }
    @PostMapping("/addEmployee")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.createEmployee(employee);
        return  new ModelAndView("redirect:/");
    }
    @GetMapping("/updateEmployeeForm/{id}")
    public String updateEmployeefrom(@PathVariable("id") int id,Model model)
    {
        Employee e = employeeService.getEmployee(id);
        model.addAttribute("employee",e);
        return "update";
    }

    @PostMapping("/updateEmployee")
    public ModelAndView updateEmployee(@ModelAttribute Employee employee)
    {
        employeeService.updateEmployee(employee);
        return new ModelAndView("redirect:/");
    }




}
