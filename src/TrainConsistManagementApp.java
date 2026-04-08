import java.util.*;

public class TrainConsistManagementApp {

    // ===== CUSTOM EXCEPTIONS =====
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class UnsafeCargoException extends Exception {
        public UnsafeCargoException(String message) {
            super(message);
        }
    }

    // ===== Passenger Bogie =====
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> Capacity: " + capacity;
        }
    }

    // ===== Goods Bogie =====
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargo) throws UnsafeCargoException {
            if (shape.equalsIgnoreCase("Rectangular") &&
                cargo.equalsIgnoreCase("Petroleum")) {

                throw new UnsafeCargoException(
                    "Unsafe Cargo! Petroleum cannot be loaded in Rectangular Bogie"
                );
            }
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return shape + " -> Cargo: " + (cargo == null ? "Not Assigned" : cargo);
        }
    }

    // ===== UC16: Bubble Sort =====
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("=========================================\n");

        List<PassengerBogie> passengerBogies = new ArrayList<>();
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        // ===== UC14 =====
        try {
            passengerBogies.add(new PassengerBogie("Sleeper", 72));
            passengerBogies.add(new PassengerBogie("AC Chair", 56));
            passengerBogies.add(new PassengerBogie("General", 60));
            passengerBogies.add(new PassengerBogie("Luxury", 40));

            // Invalid example
            passengerBogies.add(new PassengerBogie("First Class", 0));

        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught (Capacity): " + e.getMessage());
        }

        // ===== Goods Bogies =====
        GoodsBogie g1 = new GoodsBogie("Rectangular");
        GoodsBogie g2 = new GoodsBogie("Cylindrical");

        goodsBogies.add(g1);
        goodsBogies.add(g2);

        // ===== UC15 =====
        for (GoodsBogie g : goodsBogies) {
            try {
                if (g.shape.equals("Rectangular")) {
                    g.assignCargo("Petroleum"); // Unsafe
                } else {
                    g.assignCargo("Water"); // Safe
                }

                System.out.println("Cargo assigned successfully.");

            } catch (UnsafeCargoException e) {
                System.out.println("Exception Caught (Cargo): " + e.getMessage());

            } finally {
                System.out.println("Finalizing cargo assignment for: " + g.shape);
            }
        }

        // ===== Display Passenger Bogies =====
        System.out.println("\nPassenger Bogies:");
        for (PassengerBogie b : passengerBogies) {
            System.out.println(b);
        }

        // ===== UC16: Sort Capacities =====
        int[] capacities = new int[passengerBogies.size()];
        for (int i = 0; i < passengerBogies.size(); i++) {
            capacities[i] = passengerBogies.get(i).capacity;
        }

        bubbleSort(capacities);

        System.out.println("\nSorted Passenger Capacities (Bubble Sort):");
        for (int cap : capacities) {
            System.out.print(cap + " ");
        }

        // ===== UC17: Sort Bogie Names using Arrays.sort() =====
        String[] bogieNames = new String[passengerBogies.size()];
        for (int i = 0; i < passengerBogies.size(); i++) {
            bogieNames[i] = passengerBogies.get(i).type;
        }

        // Built-in sorting
        Arrays.sort(bogieNames);

        // Display sorted names
        System.out.println("\n\nSorted Bogie Names (Arrays.sort):");
        System.out.println(Arrays.toString(bogieNames));

        // ===== Goods Bogies =====
        System.out.println("\nGoods Bogies:");
        for (GoodsBogie g : goodsBogies) {
            System.out.println(g);
        }

        System.out.println("\nUC17 execution completed...");
    }
}