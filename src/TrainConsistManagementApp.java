import java.util.*;
import java.util.stream.Collectors;

// ================= Bogie =================
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ================= UC10 Example =================
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );

        int total = calculateTotalCapacity(bogies);
        System.out.println("\nTotal Capacity: " + total);

        // ================= UC11 =================
        System.out.println("\n--- UC11 Validation ---");

        String trainId = "TRN-6524";
        String cargoCode = "PET-FH";

        System.out.println("Train ID Valid: " + isValidTrainID(trainId));
        System.out.println("Cargo Code Valid: " + isValidCargoCode(cargoCode));
    }

    // ================= UC8 =================
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .toList();
    }

    // ================= UC9 =================
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    // ================= UC10 =================
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // ================= UC11 =================
    public static boolean isValidTrainID(String trainId) {
        return java.util.regex.Pattern.matches("TRN-\\d{4}", trainId);
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return java.util.regex.Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }
}