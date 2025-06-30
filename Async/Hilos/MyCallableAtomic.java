import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallableAtomic {
    
    public static void main(String[] args) {
        
        ExecutorService service = null;

        Integer sum = 0;

        service = Executors.newSingleThreadExecutor();

        Callable<Integer> firsTask = () -> sum + new Random(1).nextInt(10);
        Callable<Integer> secondTask = () -> sum + new Random(1).nextInt(10);
        Callable<Integer> thirdTask = () -> sum + new Random(1).nextInt(10);
        
        try {

            List<Future<Integer>> tasks = service.invokeAll(List.of(firsTask, secondTask, thirdTask));
            for (Future<Integer> future : tasks) {
                System.out.println(future.get());
            }

            System.out.println(sum);

        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
    }
}
