package org.java.spring_web3.web.controller;

import java.util.List;
import java.util.Optional;

import org.java.spring_web3.db.pojo.Employee;
import org.java.spring_web3.db.pojo.Role;
import org.java.spring_web3.db.serv.EmployeeService;
import org.java.spring_web3.db.serv.RoleService;
import org.java.spring_web3.web.data.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/employees")
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/test/add")
    public ResponseEntity<Void> addTestEntity() {

        Role role1 = new Role("Pirate");
        Role role2 = new Role("Governor");

        roleService.save(role1);
        roleService.save(role2);

        Employee emp1 = new Employee("Guybrush", "Threepwood", 1000, 100, role1);
        Employee emp2 = new Employee("Elaine", "Marley", 2000, 200, role2);
        Employee emp3 = new Employee("LeChuck", "LeChuck", 3000, 300, role1);

        employeeService.save(emp1);
        employeeService.save(emp2);
        employeeService.save(emp3);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getMethodName() {

        List<Employee> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    @PostMapping("")
    public ResponseEntity<Employee> addEmployee(
            @RequestBody EmployeeDto employeeDto) {

        Employee emp = new Employee(employeeDto);

        Optional<Role> optEmpRole = roleService.getRoleById(employeeDto.getRoleId());

        if (optEmpRole.isEmpty())
            return ResponseEntity.badRequest().build();

        Role empRole = optEmpRole.get();
        emp.setRole(empRole);

        employeeService.save(emp);

        return ResponseEntity.ok(emp);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable int id) {

        Optional<Employee> optEmp = employeeService.getEmployeeById(id);

        if (optEmp.isEmpty())
            return ResponseEntity.notFound().build();

        Employee emp = optEmp.get();
        employeeService.delete(emp);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable int id,
            @RequestBody EmployeeDto employeeDto) {

        Optional<Employee> optEmp = employeeService.getEmployeeById(id);

        if (optEmp.isEmpty())
            return ResponseEntity.notFound().build();

        Employee emp = optEmp.get();
        emp.update(employeeDto);

        Optional<Role> optEmpRole = roleService.getRoleById(employeeDto.getRoleId());

        if (optEmpRole.isEmpty())
            return ResponseEntity.badRequest().build();

        Role empRole = optEmpRole.get();
        emp.setRole(empRole);

        employeeService.save(emp);

        return ResponseEntity.ok(emp);
    }

}
