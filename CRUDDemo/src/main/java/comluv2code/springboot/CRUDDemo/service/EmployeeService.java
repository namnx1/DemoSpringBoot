package comluv2code.springboot.CRUDDemo.service;

import comluv2code.springboot.CRUDDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(long theId);

    void save(Employee theEmployee);

    void deleteById(long theId);

}
