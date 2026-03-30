import java.util.*;
import java.util.stream.*;

public class TrainConsistManagementApp {

    // ================= Bogie =================
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("=========================================\n");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", i % 100));
        }

        int threshold = 50;

        // ===== LOOP FILTER =====
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies, threshold);
        long endLoop = System.nanoTime();

        // ===== STREAM FILTER =====
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies, threshold);
        long endStream = System.nanoTime();

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("\nLoop Time: " + (endLoop - startLoop) + " ns");
        System.out.println("Stream Time: " + (endStream - startStream) + " ns");

        System.out.println("\nUC13 performance comparison completed...");
    }

    // ================= LOOP METHOD =================
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // ================= STREAM METHOD =================
    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .toList();
    }
}