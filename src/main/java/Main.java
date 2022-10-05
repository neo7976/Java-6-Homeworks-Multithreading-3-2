import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int I = 1000;

    public static void main(String[] args) throws InterruptedException {

        ReportThread report = new ReportThread();
        Random random = new Random();

        int[] array1 = new int[I];
        int[] array2 = new int[I];
        int[] array3 = new int[I];

        for (int i = 0; i < I; i++) {
            array1[i] = random.nextInt(1500);
            array2[i] = random.nextInt(450);
            array3[i] = random.nextInt(200);
        }

        Thread thread1 = new Thread(() -> report.tax(array1), "Магазин-1");
        Thread thread2 = new Thread(() -> report.tax(array2), "Магазин-2");
        Thread thread3 = new Thread(() -> report.tax(array3), "Магазин-3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.printf("Всего на балансе: %.2f руб.\n", report.getMoney());
    }
}
