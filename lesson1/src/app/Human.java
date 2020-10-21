package app;

public class Human implements Action{
    final double JUMP = 1.8;
    final double RUN = 110.9;
    final String NAME = "Human";

    @Override
    public void jump() {
        System.out.println( "Человек прытает на " + JUMP );
    }

    @Override
    public void run() {
        System.out.println( "Человек может пробежать " + RUN );
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
