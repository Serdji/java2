package app;

public class Cat implements Action {
    final double JUMP = 2.5;
    final double RUN = 37.2;
    final String NAME = "Cat";

    @Override
    public void jump() {
        System.out.println( "Кот прыгает на " + JUMP  );
    }

    @Override
    public void run() {
        System.out.println( "Кот может пробежать " + RUN  );
    }

    public double getJUMP() {
        return JUMP;
    }

    public double getRUN() {
        return RUN;
    }

    @Override
    public String getNAME() {
        return NAME;
    }
}
