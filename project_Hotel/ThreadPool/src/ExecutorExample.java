import java.util.concurrent.*;

public class ExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);



        String senderCard = "8600***1";
        String receiverCard = "9860***2";

        Callable<Boolean> checkSenderCardCallable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return checkSenderCard(senderCard);
            }
        };

        Callable<Boolean> checkReceiverCardCallable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return checkReceiverCard(receiverCard);
            }
        };

        Future<Boolean> senderValidFuture = executorService.submit(checkSenderCardCallable);
        Future<Boolean> receiverValidFuture = executorService.submit(checkReceiverCardCallable);

        Boolean senderValid = senderValidFuture.get();
        Boolean receiverValid = receiverValidFuture.get();

        if (senderValid && receiverValid) {
            transfer(senderCard, receiverCard, 800_000);
        }


    }

    private static void transfer(String senderCard, String receiverCard, int amount) {

        try {
            Thread.sleep(500);
            System.out.printf("money send from %s to %s amount: %s\n", senderCard, receiverCard, amount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean checkSenderCard(String senderCard) {

        try {
            System.out.println("Started checking ...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Completed checking ...");
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean checkReceiverCard(String receiverCard) {

        try {
            System.out.println("Started checking ...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Completed checking ...");
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
