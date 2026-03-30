import java.util.*;

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

        // UC4: LinkedList (Order + Flexibility)
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

        // Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Add duplicate intentionally
        formation.add("Sleeper");

        // Display final formation
        System.out.println("Final train formation (no duplicates, ordered): " + formation);

        System.out.println("System ready for further operations.");
    }
}