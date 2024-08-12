import java.util.Random;
import java.util.concurrent.*;

public class Main {

    //test

    public static void main(String[] args) throws TimeoutException {

        Random random;
//        var test = random.nextInt(1, 10);
//        System.out.println(test);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(1, 10) * 1000L);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return "Hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(1, 10) * 1000L);
//                future1.orTimeout(test, TimeUnit.MILLISECONDS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return "World";
        });


        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + " " + result2).orTimeout(10, TimeUnit.SECONDS);

        try {
            System.out.println(combinedFuture.join());
        } catch (CompletionException e) {
            if (e.getCause() instanceof TimeoutException) {
                System.out.println("Operation timed out: exceeded 10 seconds total");
            }


//        CompletableFuture<Void> future = CompletableFuture.runAsync( () ->{
//            try{
//                future2.get(15, TimeUnit.MILLISECONDS);
//            } catch(RuntimeException | InterruptedException | ExecutionException | TimeoutException e){
//                throw new RuntimeException("detailed message", e);
//            }
//        });

        }

    }
}




