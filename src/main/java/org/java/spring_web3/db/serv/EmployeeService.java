package org.java.spring_web3.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_web3.db.pojo.Employee;
import org.java.spring_web3.db.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {

        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {

        return employeeRepo.findById(id);
    }

    public void save(Employee employee) {

        employeeRepo.save(employee);
    }

    public void delete(Employee employee) {

        employeeRepo.delete(employee);
    }
}
