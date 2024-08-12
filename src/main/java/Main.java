import javax.naming.TimeLimitExceededException;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.BiFunction;

public class Main {

    //test

    public static void main(String[] args) throws TimeoutException {

        Random random = new Random();
        var test = random.nextInt(1, 20);
//        System.out.println(test);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(test * 1000L);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return "Hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(test * 1000L);
//                future1.orTimeout(test, TimeUnit.MILLISECONDS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return "World";
        });




        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + " " + result2);
        combinedFuture.thenAccept(result -> System.out.println("Combined result: " + result)).orTimeout(10, TimeUnit.SECONDS).join();



    }


}




