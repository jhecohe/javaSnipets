import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnableAtomic {
    
    public static void main(String[] args) {
        
        ExecutorService service = null;

        AtomicInteger ai = new AtomicInteger(0);

        service = Executors.newSingleThreadExecutor();

        Runnable firsTask = () -> ai.set(ai.get() + new Random(1).nextInt(10));
        Runnable secondTask = () -> ai.set(ai.get() + new Random(1).nextInt(10));
        Runnable thirdTask = () ->ai.set(ai.get() + new Random(1).nextInt(10));
        
        try {

            service.execute(firsTask);
            service.execute(secondTask);
            service.execute(thirdTask);

            service.awaitTermination(1, TimeUnit.SECONDS);

            System.out.println(ai.get());

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
    }
}
