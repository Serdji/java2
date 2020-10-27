package app;

public class MyArrayDataException extends IllegalArgumentException implements MyArrayException {

    String s;
    int row;
    int col;

    public MyArrayDataException(String s, int row, int col) {
        super(s);
        this.s = s;
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean errorOutput() {
        System.err.println("Это не чслоко в строке " + row + " колонке " + col + " | " + s);
        return false;
    }
}
