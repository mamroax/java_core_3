package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Worker implements Comparable<Worker> {
    private String name;
    private String middleName;
    private String surname;
    private String position;
    private String phoneNumber;
    private int salary;
    private LocalDate dateOfBirth;

    public Worker(String surname, String name, String middleName,
                  String position, String phoneNumber, int salary, LocalDate dateOfBirth) {
        this(surname, name, middleName);
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        setDateOfBirth(dateOfBirth);
    }

    public Worker(String surname, String name, String middleName){
        this.surname = surname;
        this.middleName = middleName;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return this.dateOfBirth == null ? -1 : (int) this.dateOfBirth.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now().minusYears(14))) {
            System.out.println("Сотрудник имеет неподходящий возраст!");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    @Override
    public String toString() {
        return "model.Worker{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", age=" + this.getAge() +
                '}';
    }



    @Override
    public int compareTo(Worker o) {
        return this.getAge() - o.getAge();
    }
}
