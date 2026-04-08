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

    // ===== UC16: Bubble Sort Method =====
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Optimization: track if swap happens
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {

                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps → already sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("=========================================\n");

        List<PassengerBogie> passengerBogies = new ArrayList<>();
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        // ===== UC14 Logic =====
        try {
            passengerBogies.add(new PassengerBogie("Sleeper", 72));
            passengerBogies.add(new PassengerBogie("AC Chair", 56));
            passengerBogies.add(new PassengerBogie("General", 60));

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

        // ===== UC15 Logic =====
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

        // ===== UC16: Extract capacities into array =====
        int[] capacities = new int[passengerBogies.size()];
        for (int i = 0; i < passengerBogies.size(); i++) {
            capacities[i] = passengerBogies.get(i).capacity;
        }

        // ===== Apply Bubble Sort =====
        bubbleSort(capacities);

        // ===== Display Sorted Capacities =====
        System.out.println("\nSorted Passenger Capacities (Bubble Sort):");
        for (int cap : capacities) {
            System.out.print(cap + " ");
        }

        // ===== Goods Bogies =====
        System.out.println("\n\nGoods Bogies:");
        for (GoodsBogie g : goodsBogies) {
            System.out.println(g);
        }

        System.out.println("\nUC16 execution completed...");
    }
}