import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
            Thread.sleep(5000);
            System.out.println("Hello World!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        });

        future.join();

    }



}




