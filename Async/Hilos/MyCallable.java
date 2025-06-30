import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable {
    
    public static void main(String[] args) {
        
        ExecutorService service = null;

        service = Executors.newSingleThreadExecutor();

        Callable<Integer> myCallable = () -> 15 +35;

        Future<Integer> sum = service.submit(myCallable);

        try {
            System.out.println(sum.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
