package FinanceAccountingSystem.financeEntities;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeEntities.Gender;
import EmployeeAccountingSystem.EmployeeEntities.Job;

import java.time.LocalDate;

public class FinanceAccount extends Employee {
    Long id;
    String nameOfCard;
    int numberOfCard;
    String nameOfThePotentialCost;
    String currentCostName;
    int potentialCost;
    int currentCost;
    String namePotentialIncome;
    int potentialIncome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setDepartment(Department department) {
        super.setDepartment(department);
    }

    @Override
    public Department getDepartment() {
        return super.getDepartment();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public void setPatronymic(String patronymic) {
        super.setPatronymic(patronymic);
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        super.setDateOfBirth(dateOfBirth);
    }

    @Override
    public void setGender(Gender gender) {
        super.setGender(gender);
    }

    @Override
    public void setPhone(String phone) {
        super.setPhone(phone);
    }

    @Override
    public void setJobTitle(Job jobTitle) {
        super.setJobTitle(jobTitle);
    }

    @Override
    public void setSurnameOfTheChief(String surnameOfTheChief) {
        super.setSurnameOfTheChief(surnameOfTheChief);
    }

    @Override
    public void setEmploymentDate(LocalDate employmentDate) {
        super.setEmploymentDate(employmentDate);
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public String getPatronymic() {
        return super.getPatronymic();
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public Gender getGender() {
        return super.getGender();
    }

    @Override
    public String getPhone() {
        return super.getPhone();
    }

    @Override
    public Job getJobTitle() {
        return super.getJobTitle();
    }

    @Override
    public String getSurnameOfTheChief() {
        return super.getSurnameOfTheChief();
    }

    @Override
    public LocalDate getEmploymentDate() {
        return super.getEmploymentDate();
    }

    @Override
    public int getSalary() {
        return super.getSalary();
    }

    public String getNamePotentialIncome() {
        return namePotentialIncome;
    }

    public void setNamePotentialIncome(String namePotentialIncome) {
        this.namePotentialIncome = namePotentialIncome;
    }

    public int getPotentialIncome() {
        return potentialIncome;
    }

    public void setPotentialIncome(int potentialIncome) {
        this.potentialIncome = potentialIncome;
    }

    public String getNameOfThePotentialCost() {
        return nameOfThePotentialCost;
    }

    public void setNameOfThePotentialCost(String nameOfThePotentialCost) {
        this.nameOfThePotentialCost = nameOfThePotentialCost;
    }

    public String getCurrentCostName() {
        return currentCostName;
    }

    public void setCurrentCostName(String currentCostName) {
        this.currentCostName = currentCostName;
    }

    public int getPotentialCost() {
        return potentialCost;
    }

    public void setPotentialCost(int potentialCost) {
        this.potentialCost = potentialCost;
    }

    public int getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(int currentCost) {
        this.currentCost = currentCost;
    }

    public String getNameOfCard() {
        return nameOfCard;
    }

    public void setNameOfCard(String nameOfCard) {
        this.nameOfCard = nameOfCard;
    }

    public int getNumberOfCard() {
        return numberOfCard;
    }

    public void setNumberOfCard(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    @Override
    public String toString() {
        return id + "\n" + nameOfCard + " : " + numberOfCard + "\n" + nameOfThePotentialCost + " : " + potentialCost + "\n" +
                currentCostName + " : " + currentCost + "\n" + namePotentialIncome + " : " + potentialIncome;
    }
}
