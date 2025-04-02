import comparators.WorkerSurnameComparator;
import controller.Manager;
import model.Worker;

import java.time.LocalDate;
import java.util.*;

public class Main {
    /**
     * 1) Написать компаратор по фамилии;
     * 2) Опишите класс руководителя (controller.Manager), наследник от сотрудника. Перенесите статический метод
     * повышения зарплаты в класс руководителя, модифицируйте метод таким образом, чтобы он мог поднять
     * заработную плату всем, кроме руководителей. В основной программе создайте руководителя и поместите
     * его в общий массив сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата
     * руководителя не повысилась;
     * 3) Добавить возможность сотрудникам брать на себя задачу (реализовать либо как String, либо объект
     * класса model.Task - например, метод assign(model.Task task). У руководителя должна быть возможность ставить задачу
     * сотруднику, используя перегрузку метода assign(...) и брать задачу себе**/
    public static void main(String[] args) {
    Worker[] workers = {
            new Worker("Ivanov", "Ivan", "Ivanovich",
            "backend-developer", "+7-950-640-76-89", 100,
            LocalDate.of(1940, 10, 17)),
         new Worker("Petrov", "Ivan", "Pavlovich",
                "manager", "+7-950-640-76-89", 200,
                LocalDate.of(1969, 10, 17)),
            new Worker("Pavlov", "Ivan", "Pavlovich",
                    "manager", "+7-950-643-76-89", 200,
                    LocalDate.of(1980, 10, 17)),
            new Worker("Denisov", "Ivan", "Pavlovich",
                    "manager", "+7-950-642-76-89", 200,
                    LocalDate.of(1962, 10, 17)),
            new Worker("Nosov", "Oleg", "Pavlovich",
                    "manager", "+7-950-641-76-89", 2000,
                    LocalDate.of(1970, 10, 17)),
            new Manager("Borisov", "Vasili", "Nikolaevich", // добавили начальника
                    "manager", "+7-950-633-76-89", 3000,
                    LocalDate.of(1968, 7, 6)),
        };

        System.out.println("Average age:" + getAverageAge(workers));
        System.out.println("Average salary:" + getAverageSalary(workers));

        Manager.addSalary(workers, 50);

        //System.out.println(Arrays.toString(workers));
        Arrays.stream(workers).forEach(System.out::println);

        List<Worker> workersList = Arrays.asList(workers);
        //workersList.sort(new comparators.WorkerSalaryComparator()); // такой вариант сортировки использует наш класс
//        workersList.sort(Comparator.comparing(o -> o.getSalary())); // такой вариант использует stream
        workersList.sort((o1, o2) -> o1.getSalary() - o2.getSalary()); // такой вариант сортировки с параметром

        System.out.println("---".repeat(5));
        System.out.println("Отсортирован по зарплате");
        workersList.stream().forEach(System.out::println);

        Collections.sort(workersList);

        System.out.println("---".repeat(5));
        System.out.println("Отсортирован по возрасту");
        workersList.stream().forEach(System.out::println);

        System.out.println(("---".repeat(5)));
        System.out.println("Осортирован по фамилии");
        workersList.sort(new WorkerSurnameComparator());
        workersList.stream().forEach(System.out::println);
    }
    public static double getAverageAge(Worker[] workers){
        int sumAge = 0;
        for (Worker worker : workers){
            sumAge += worker.getAge();
        }
        return (double) sumAge / workers.length;
    }

    public static double getAverageSalary(Worker[] workers){
        int sumSalary = 0;
        for (Worker worker : workers){
            sumSalary += worker.getSalary();
        }
        return (double) sumSalary / workers.length;
    }
}