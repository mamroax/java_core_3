package comparators;

import java.util.Comparator;
import model.Worker;

public class WorkerSurnameComparator implements Comparator<Worker> {
    public int compare(Worker w1, Worker w2){
        return w1.getSurname().compareTo(w2.getSurname());
    }
}
