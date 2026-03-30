import java.util.*;

// Custom Bogie Class (UC7)
class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // toString() for clean output
    @Override
    public String toString() {
        return name + " -> Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // UC1: Initialization
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // UC2: ArrayList Operations
        System.out.println("\n--- UC2: Managing Passenger Bogies ---");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("Bogies after addition: " + trainConsist);

        trainConsist.remove("AC Chair");
        System.out.println("After removing 'AC Chair': " + trainConsist);

        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists in the train.");
        }

        System.out.println("Final train consist: " + trainConsist);

        // UC3: HashSet (Uniqueness)
        System.out.println("\n--- UC3: Ensuring Unique Bogie IDs ---");

        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate

        System.out.println("Unique Bogie IDs: " + bogieIds);

        // UC4: LinkedList (Order)
        System.out.println("\n--- UC4: Maintaining Ordered Train Consist ---");

        LinkedList<String> linkedTrain = new LinkedList<>();
        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");
        linkedTrain.add("AC");
        linkedTrain.add("Cargo");
        linkedTrain.add("Guard");

        linkedTrain.add(2, "Pantry Car");
        linkedTrain.removeFirst();
        linkedTrain.removeLast();

        System.out.println("Final ordered train consist: " + linkedTrain);

        // UC5: LinkedHashSet (Order + Uniqueness)
        System.out.println("\n--- UC5: Ordered Unique Train Formation ---");

        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate ignored

        System.out.println("Final train formation: " + formation);

        // UC6: HashMap (Bogie → Capacity)
        System.out.println("\n--- UC6: Bogie Capacity Mapping ---");

        Map<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 50);
        bogieCapacity.put("First Class", 24);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }

        // UC7: Sort Bogies by Capacity (Comparator)
        System.out.println("\n--- UC7: Sort Passenger Bogies by Capacity ---");

        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 50));
        passengerBogies.add(new Bogie("First Class", 24));

        System.out.println("Before Sorting:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // Ascending order
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (Ascending):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // Descending order
        passengerBogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());

        System.out.println("\nAfter Sorting (Descending):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("\nSystem ready for further operations.");
    }
}