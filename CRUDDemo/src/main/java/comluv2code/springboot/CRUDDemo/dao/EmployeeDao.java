package comluv2code.springboot.CRUDDemo.dao;

import comluv2code.springboot.CRUDDemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(long theId);

    void save(Employee theEmployee);

    void deleteById(long theId);


}
