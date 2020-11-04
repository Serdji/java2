package app;

public class AsyncComputation implements Runnable {

    private float[] arr;
    private int size;
    private int h;
    private final Object mon = new Object();

    public AsyncComputation(float[] arr, int size, int h) {
        this.arr = arr;
        this.size = size;
        this.h = h;
    }

    @Override
    public void run() {
        unite();
    }

    private float[] splitA1() {
        synchronized (mon) {
            long t = System.currentTimeMillis();
            float[] newArr = new float[h];
            float[] a1 = new float[h];
            System.arraycopy(a1, 0, arr, 0, h);
            newArr = computation( a1 );
            System.out.println(System.currentTimeMillis() - t + " Ассинхронный метод раздития и вычисления a1");
            return newArr;
        }
    }

    private float[] splitA2() {
        synchronized (mon) {
            long t = System.currentTimeMillis();
            float[] newArr = new float[h];
            float[] a2 = new float[h];
            System.arraycopy(a2, 0, arr, h, h);
            newArr = computation( a2 );
            System.out.println(System.currentTimeMillis() - t + " Ассинхронный метод раздития и вычисления a2");
            return newArr;
        }
    }

    private float[] computation( float[] newArr ) {
        for (int i = 0; i < h; i++) {
            newArr[i] = (float)(newArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return newArr;
    }

    private void unite() {
        long t = System.currentTimeMillis();
        System.arraycopy(splitA1(), 0, arr, 0, h);
        System.arraycopy( splitA2(), 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - t + " Ассинхронный метод сборки двух массивов");
    }

}
