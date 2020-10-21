package app;

import java.util.List;

public class Track implements Run {
    final double LENGTH = 100;


    @Override
    public void run(List<Action> participants) {
        for (Action p : participants) {
            if( LENGTH <= p.getRUN() ) {
                p.run();
            } else {
                System.out.println( "Выбыл " + p.getNAME() );
            }
        }
        System.out.println("\n---------------------------");
    }
}
