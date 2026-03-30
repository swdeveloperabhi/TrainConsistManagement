import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

        // UC3: HashSet for Unique Bogie IDs
        System.out.println("\n--- UC3: Ensuring Unique Bogie IDs ---");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("Unique Bogie IDs: " + bogieIds);

        // UC4: LinkedList for Ordered Train Consist
        System.out.println("\n--- UC4: Maintaining Ordered Train Consist ---");

        LinkedList<String> linkedTrain = new LinkedList<>();

        // Add bogies
        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");
        linkedTrain.add("AC");
        linkedTrain.add("Cargo");
        linkedTrain.add("Guard");

        System.out.println("Initial train consist: " + linkedTrain);

        // Insert Pantry Car at position 2
        linkedTrain.add(2, "Pantry Car");
        System.out.println("After adding Pantry Car at position 2: " + linkedTrain);

        // Remove first and last bogie
        linkedTrain.removeFirst();
        linkedTrain.removeLast();

        System.out.println("After removing first and last bogie: " + linkedTrain);

        // Final state
        System.out.println("Final ordered train consist: " + linkedTrain);

        System.out.println("System ready for further operations.");
    }
}