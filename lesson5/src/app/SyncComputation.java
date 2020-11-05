package app;

import java.util.Arrays;

public class SyncComputation {

    private float[] arr;
    private int size;

    public SyncComputation(float[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    public void run() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a + "  Статический метод");
    }
}
