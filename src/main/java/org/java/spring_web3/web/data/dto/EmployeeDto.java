package org.java.spring_web3.web.data.dto;

public class EmployeeDto {

    private String name;
    private String surname;

    private int salary;
    private int bonus;

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

    @Override
    public String toString() {

        return "EmployeeDto{\n" +
                "\tname: " + name + "\n" +
                "\tsurname: " + surname + "\n" +
                "\tsalary: " + salary + "\n" +
                "\tbonus: " + bonus + "\n" +
                "}";
    }
}
