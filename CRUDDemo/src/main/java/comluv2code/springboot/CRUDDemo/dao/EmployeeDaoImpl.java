package comluv2code.springboot.CRUDDemo.dao;

import comluv2code.springboot.CRUDDemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // get the current hibanate sessipon
        Session currentSession =
                entityManager.unwrap(Session.class);

        // Create a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee", Employee.class);

        // execute query
        List<Employee> employees = theQuery.getResultList();

        //
        return employees;
    }

    @Override
    public Employee findById(long theId) {
        // get the current hibanate sessipon
        Session currentSession =
                entityManager.unwrap(Session.class);

        // get the employee
        Employee employee =
                currentSession.get(Employee.class,theId);

        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        // get the current hibanate sessipon
        Session currentSession =
                entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(long theId) {
        // get the current hibanate sessipon
        Session currentSession =
                entityManager.unwrap(Session.class);

        //delete
        // Create a query
        Query theQuery =
                currentSession.createQuery("delete from Employee where id = :employeeId",Employee.class);


        // set para
        theQuery.setParameter("employeeId",theId);

        // executy
        theQuery.executeUpdate();

    }
}
