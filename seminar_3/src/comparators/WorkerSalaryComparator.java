package comparators;

import java.util.Comparator;
import model.Worker;

public class WorkerSalaryComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.getSalary() - o2.getSalary();
    }
}
