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
        String shape;   // Rectangular / Cylindrical
        String cargo;   // Assigned later

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Runtime cargo assignment
        public void assignCargo(String cargo) throws UnsafeCargoException {
            // Unsafe rule:
            // Petroleum should NOT go into Rectangular bogie
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

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("=========================================\n");

        List<PassengerBogie> passengerBogies = new ArrayList<>();
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        // ===== UC14 Logic (Constructor Validation) =====
        try {
            passengerBogies.add(new PassengerBogie("Sleeper", 72));
            passengerBogies.add(new PassengerBogie("AC Chair", 56));

            // Invalid example
            passengerBogies.add(new PassengerBogie("First Class", 0));

        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught (Capacity): " + e.getMessage());
        }

        // ===== Create Goods Bogies =====
        GoodsBogie g1 = new GoodsBogie("Rectangular");
        GoodsBogie g2 = new GoodsBogie("Cylindrical");

        goodsBogies.add(g1);
        goodsBogies.add(g2);

        // ===== UC15 Logic (Runtime Safety Handling) =====
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

        // ===== Display Results =====
        System.out.println("\nPassenger Bogies:");
        for (PassengerBogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("\nGoods Bogies:");
        for (GoodsBogie g : goodsBogies) {
            System.out.println(g);
        }

        System.out.println("\nUC15 execution completed...");
    }
}