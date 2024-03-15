package EmployeeAccountingSystem.EmployeeEntities;

import java.time.LocalDate;

public class Employee {
    Long id; // id
    String name; // имя
    String surname; // фамилия
    String patronymic; // отчество
    LocalDate dateOfBirth; // дата рождения
    Gender gender; // пол
    String phone; // телефон
    Job jobTitle; // должность
    Department department; //название отдела
    String surnameOfTheChief; // фамилия начальника
    LocalDate employmentDate; // дата приема на работу
    int salary; // зарплата

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setJobTitle(Job jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSurnameOfTheChief(String surnameOfTheChief) {
        this.surnameOfTheChief = surnameOfTheChief;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public Job getJobTitle() {
        return jobTitle;
    }

    public String getSurnameOfTheChief() {
        return surnameOfTheChief;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return  "\nid = " + id +
                "| name = " + name +
                "| surname = " + surname +
                "| patronymic = " + patronymic +
                "| dateOfBirth = " + dateOfBirth +
                "| gender = " + gender +
                "| phone = " + phone +
                "| jobTitle = " + jobTitle +
                "| surnameOfTheChief = " + surnameOfTheChief +
                "| employmentDate = " + employmentDate +
                "| salary = " + salary;
    }
}
