import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {

    private CountDownLatch cld;

    public Uploader(CountDownLatch cld) {
        this.cld = cld;

    }

    public void run() {
        try {
            for (int i = 0; i < 25 ; i++) {

                System.out.print("- ");
                sleep(50);
            }
            System.out.println(" Файл загружен на сервер ");
            cld.countDown();
        } catch (Exception e){

        }

    }
}