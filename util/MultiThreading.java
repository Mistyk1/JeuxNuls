package util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class MultiThreading{
    public static void execute(Consumer<?>... methods){
        ExecutorService executor = Executors.newCachedThreadPool();
        try{
            for (Consumer<?> m : methods){
                executor.execute(() -> m.accept(null));
            }
            executor.shutdown();
        } catch (Exception e){
            System.out.println(Color.RED + "Erreur du multithreading (" + e.getMessage() + ")" + Color.RESET);
            executor.shutdown();
        }
    }
}

//---- Utilisation de MultiThreading ----
//MultiThreading.execute(e -> methode1(), e -> methode2());
//MultiThreading.execute(e -> methode3());