import java.util.*;
import java.util.stream.*;

public class TrainConsistManagementApp {

    // ================= GoodsBogie Class =================
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("==============================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Display bogies
        System.out.println("Goods Bogies:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b);
        }

        // ===== SAFETY CHECK USING STREAM =====
        boolean isSafe = goodsBogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical") ||
                                b.cargo.equalsIgnoreCase("Petroleum")
                );

        // Display result
        System.out.println("\nSafety Compliance Status: " + isSafe);

        System.out.println("\nUC12 safety validation completed...");
    }

    // ================= METHOD FOR TEST CASES =================
    public static boolean isSafeComposition(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical") ||
                                b.cargo.equalsIgnoreCase("Petroleum")
                );
    }
}