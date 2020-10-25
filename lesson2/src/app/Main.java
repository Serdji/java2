package app;

public class Main {

    public static void main(String[] args) {
        String matrix[][] = {
                {"1", "34", "2", "23"},
                {"3", "3", "78", "6" },
                {"123", "6", "22", "23"},
                {"123", "6", "22", "90"},
        };


        try {
            System.out.println( "Ответ = " + sumArr( matrix ) );
        } catch ( MyArraySizeException | MyArrayDataException e) {
            System.out.println( e.errorOutput() );
        }
    }

    public static int sumArr(String arr[][]) throws MyArraySizeException, MyArrayDataException {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if( arr.length != arr[i].length ) {
                    throw new MyArraySizeException( i, arr.length, arr[i].length );
                }
                if ( !isNumeric( arr[i][j] ) ) {
                    throw new MyArrayDataException(  arr[i][j], i + 1, j + 1 );
                }
                res += Integer.parseInt( arr[i][j] );
            }
        }
        return res;
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }
}
