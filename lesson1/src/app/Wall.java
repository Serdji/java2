package app;

import java.util.ArrayList;
import java.util.List;

public class Wall implements Run {
    final double HEIGHT = 1.9;


    @Override
    public void run(List<Action> participants) {
        Track track = new Track();
        List< Action > remaining = new ArrayList<>();
        for (Action p  : participants) {
            if( HEIGHT <= p.getJUMP() ) {
                p.jump();
                remaining.add( p );
            } else {
                System.out.println( "Выбыл " + p.getNAME() );
            }
        }
        System.out.println("\n---------------------------");
        track.run( remaining );
    }
}
