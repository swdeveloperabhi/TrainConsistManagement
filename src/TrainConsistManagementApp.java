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

    // ===== UC18: Linear Search =====
    public static boolean linearSearch(String[] arr, String key) {
        for (String val : arr) {
            if (val.equals(key)) return true;
        }
        return false;
    }

    // ===== UC19: Binary Search =====
  public static boolean binarySearch(String[] arr, String key) {

    // ===== UC20: Fail-Fast Validation =====
    if (arr == null || arr.length == 0) {
        throw new IllegalStateException("No bogies available in the train. Cannot perform search.");
    }

    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {

        int mid = (low + high) / 2;

        int cmp = key.compareTo(arr[mid]);

        if (cmp == 0) {
            return true;
        } 
        else if (cmp < 0) {
            high = mid - 1;
        } 
        else {
            low = mid + 1;
        }
    }

    return false;
}

 public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("=========================================");
    System.out.println(" UC20 - Fail Fast Search ");
    System.out.println("=========================================\n");

    // Try EMPTY array to test exception
    String[] bogieIds = {};  

    // Uncomment below to test normal flow
    // String[] bogieIds = {"BG101","BG205","BG309"};

    try {
        // Sort before binary search
        Arrays.sort(bogieIds);

        System.out.println("Bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        System.out.print("\nEnter Bogie ID to search: ");
        String key = sc.nextLine();

        boolean found = binarySearch(bogieIds, key);

        if (found) {
            System.out.println("Bogie ID " + key + " FOUND.");
        } else {
            System.out.println("Bogie ID " + key + " NOT FOUND.");
        }

    } catch (IllegalStateException e) {
        // Fail-fast message
        System.out.println("Error: " + e.getMessage());
    }

    System.out.println("\nUC20 execution completed...");
    sc.close();
}
}