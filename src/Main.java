import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3, true);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CountDownLatch countDownLatch1 = new CountDownLatch(1);

        Uploader uploader = new Uploader(countDownLatch1);
        uploader.start();

        for (int i = 1; i < 11; i++) {
            new Downloaders(i, semaphore, countDownLatch, countDownLatch1).start();
            Thread.sleep(100);
        }

        countDownLatch.await();

        System.out.println("\nФайл удален с сервера ");


    }

}
