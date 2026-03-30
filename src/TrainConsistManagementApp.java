import java.util.*;
import java.util.stream.Collectors;

// ================= Bogie Class =================
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

        // ================= UC1 =================
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // ================= UC2 =================
        System.out.println("\n--- UC2 ---");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        trainConsist.remove("AC Chair");

        // ================= UC3 =================
        System.out.println("\n--- UC3 ---");
        Set<String> ids = new HashSet<>(Arrays.asList("BG1","BG2","BG1"));
        System.out.println(ids);

        // ================= UC4 =================
        System.out.println("\n--- UC4 ---");
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Engine","Sleeper","Cargo"));
        list.add(1,"Pantry");

        // ================= UC5 =================
        System.out.println("\n--- UC5 ---");
        Set<String> formation = new LinkedHashSet<>(Arrays.asList("Engine","Sleeper","Sleeper"));
        System.out.println(formation);

        // ================= UC6 =================
        System.out.println("\n--- UC6 ---");
        Map<String,Integer> map = Map.of("Sleeper",72,"AC",50,"First",24);
        map.forEach((k,v)-> System.out.println(k+" -> "+v));

        // ================= UC7 =================
        System.out.println("\n--- UC7 ---");
        List<Bogie> bogies = new ArrayList<>(List.of(
                new Bogie("Sleeper",72),
                new Bogie("AC Chair",56),
                new Bogie("First Class",24),
                new Bogie("General",90)
        ));

        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        bogies.forEach(System.out::println);

        // ================= UC8 =================
        System.out.println("\n--- UC8 ---");
        List<Bogie> filtered = filterBogiesByCapacity(bogies,60);
        filtered.forEach(System.out::println);

        // ================= UC9 =================
        System.out.println("\n--- UC9 ---");
        Map<String,List<Bogie>> grouped = groupBogiesByType(bogies);
        grouped.forEach((k,v)->{
            System.out.println(k);
            v.forEach(b-> System.out.println("  "+b.capacity));
        });

        // ================= UC10 =================
        System.out.println("\n--- UC10 ---");
        int total = calculateTotalCapacity(bogies);
        System.out.println("Total Capacity: " + total);
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
}