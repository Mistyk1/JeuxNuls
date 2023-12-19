package fr.mistyk1.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public abstract class MultiThreading{
    /**
     * Execute les méthodes en multithreading
     * 
     * <code>
     * MultiThreading.execute(e -> methode1(), e -> methode2());
     * </code>
     * 
     * @param methods Liste des méthodes à exécuter
     */
    public static void execute(Consumer<?>... methods){
        ExecutorService executor = Executors.newCachedThreadPool();
        try{
            for (Consumer<?> m : methods){
                executor.execute(() -> m.accept(null));
            }
        } catch (Exception e){
            System.out.println(Color.color("Erreur de multithreading (" + e.getMessage() + ")", Color.RED));
        } finally { executor.shutdown(); }
    }
}