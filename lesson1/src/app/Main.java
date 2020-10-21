package app;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List< Action > participants = new ArrayList<>();

        participants.add( new Cat() );
        participants.add( new Human() );
        participants.add( new Robot() );

        Wall wall = new Wall();

        wall.run( participants );

    }
}
