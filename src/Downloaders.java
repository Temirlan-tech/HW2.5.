import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class Downloaders extends Thread {

    private int id;
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private CountDownLatch countDownLatch1;

    public Downloaders(int id, Semaphore semaphore, CountDownLatch countDownLatch, CountDownLatch countDownLatch1) {
        this.id = id;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.countDownLatch1 = countDownLatch1;
    }

    public void run() {
        try {
            countDownLatch1.await();
            semaphore.acquire();
            System.out.println("\nФайл скачивает " + id);
            sleep(3000);
            System.out.println("\nФайл скачал " + id);
            semaphore.release();
            countDownLatch.countDown();

        } catch (Exception error) {

        }
    }
}

