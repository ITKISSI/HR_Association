package ma.eheio.hr_association.service;

import lombok.Data;
import ma.eheio.hr_association.model.Employee;
import ma.eheio.hr_association.repository.EmployeeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public class EmployeeService {

    @Autowired
    EmployeeProxy employeeProxy;

    public Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }

    public Employee getEmployee(final int Id)
    {
        return employeeProxy.getEmployee(Id);
    }

    public Employee createEmployee(Employee employee)
    {
        Employee savedEmployee;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        employee.setLastName(employee.getLastName().toUpperCase());

        if(employee.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedEmployee = employeeProxy.createEmployee(employee);
        } else {
            savedEmployee = employeeProxy.updateEmployee(employee);
        }
        return savedEmployee;
    }

    public void deleteEmployee(int Id)
    {
        employeeProxy.deleteEmployee(Id);
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeProxy.updateEmployee(employee);
    }

}
