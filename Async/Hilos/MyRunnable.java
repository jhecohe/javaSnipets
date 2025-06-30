
public class MyRunnable {
    
    public static void main(String[] args) {

        // Runnable miHilo = () -> {
        //     for (int i = 0; i < 4; i++) {
        //         System.out.println("number " + i);
        //     }
        // };

        System.out.println("start");

        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println(i);
            }
        }).start();

        System.out.println("end");
    }
}
