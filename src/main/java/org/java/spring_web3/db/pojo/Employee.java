package org.java.spring_web3.db.pojo;

import org.java.spring_web3.web.data.dto.EmployeeDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 128)
    private String name;
    @Column(nullable = false, length = 128)
    private String surname;

    @Column(nullable = false)
    private int salary;
    @Column(nullable = false)
    private int bonus;

    public Employee() {
    }

    public Employee(
            String name, String surname,
            int salary, int bonus) {

        setName(name);
        setSurname(surname);
        setSalary(salary);
        setBonus(bonus);
    }

    public Employee(EmployeeDto employeeDto) {

        update(employeeDto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void update(EmployeeDto employeeDto) {

        setName(employeeDto.getName());
        setSurname(employeeDto.getSurname());
        setSalary(employeeDto.getSalary());
        setBonus(employeeDto.getBonus());
    }

    @Override
    public String toString() {

        return "Employee{\n" +
                "\tid=" + id + ",\n" +
                "\tname='" + name + '\'' + ",\n" +
                "\tsurname='" + surname + '\'' + ",\n" +
                "\tsalary=" + salary + ",\n" +
                "\tbonus=" + bonus + "\n" +
                "}";
    }
}
