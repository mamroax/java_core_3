package controller;

import model.Task;
import model.Worker;

import java.time.LocalDate;
import java.util.HashMap;


public class Manager extends Worker {
    HashMap<Task, Worker> имя = new HashMap<Task, Worker>(); // для хранения задач и сотрудников,
    // которые над ними работают

    public Manager(String surname, String name, String middleName, String position, String phoneNumber, int salary, LocalDate dateOfBirth) {
        super(surname, name, middleName, position, phoneNumber, salary, dateOfBirth);
    }

    public Manager(String surname, String name, String middleName) {
        super(surname, name, middleName);
    }

    public static void addSalary(Worker[] workers, int addAmount){
        for (Worker worker : workers){
            if (!(worker instanceof Manager)){
                worker.setSalary(worker.getSalary() + addAmount);
                System.out.println("Зарплата повышена " + worker.getSurname() + " " + worker.getName()
                        + " " + worker.getMiddleName());
            }
            else {
                System.out.println("Не могу повысить зарплату руководителю");
            }
        }
    }

    public static void assign(Worker worker, Task task){

    }
}
