package app;

public class MyArraySizeException extends IndexOutOfBoundsException implements MyArrayException {
    int rowSize;
    int colSize;
    int index;

    public MyArraySizeException(int index, int rowSize, int colSize) {
        super(index);
        this.index = index;
        this.rowSize = rowSize;
        this.colSize = colSize;
    }


    @Override
    public boolean errorOutput() {
        index += 1;
        System.err.println( "Массив не равнозначный в строке " + index + " | " +  rowSize + " X " + colSize );
        return false;
    }
}
