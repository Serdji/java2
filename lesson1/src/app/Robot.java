package app;

public class Robot implements Action {
    final double JUMP = 5.7;
    final double RUN = 45621.2;
    final String NAME = "Robot";

    @Override
    public void jump() {
        System.out.println( "Робот может прыгать на " + JUMP );
    }

    @Override
    public void run() {
        System.out.println( "Робот может пробежать " + RUN );
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
