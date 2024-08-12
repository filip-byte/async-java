import java.util.concurrent.CompletableFuture;

public class Main {

    //test

    public static void main(String[] args) {

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("World!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        future.join();
        future1.join();

    }


}




