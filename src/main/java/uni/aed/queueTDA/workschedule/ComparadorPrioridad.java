package uni.aed.queueTDA.workschedule;

import java.util.Comparator;

public class ComparadorPrioridad implements Comparator<Trabajo>{
    @Override
    public int compare(Trabajo t1, Trabajo t2) {
        return Integer.compare(t2.getPrioridad(), t1.getPrioridad());
    }
}
