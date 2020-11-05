package app;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        SyncComputation syncComputation = new SyncComputation( arr, size );
        syncComputation.run();

         Thread asyncComputation = new Thread( new AsyncComputation( arr, size, h ) );
         asyncComputation.start();

    }
}
