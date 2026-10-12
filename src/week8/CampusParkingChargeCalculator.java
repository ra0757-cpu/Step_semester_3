package week8;

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {

        String[] types = {"BIKE", "CAR", "TRUCK", "CAR"};
        int[] hours = {3, 4, 1, 1};

        double total = 0;

        for (int i = 0; i < types.length; i++) {

            double charge = 0;

            if (types[i].equals("BIKE")) {
                charge = hours[i] * 10.0;
            } else if (types[i].equals("CAR")) {
                charge = 30 + (hours[i] - 1) * 20.0;
            } else if (types[i].equals("TRUCK")) {
                charge = Math.max(100, hours[i] * 50.0);
            }

            System.out.printf("%s: %.2f%n", types[i], charge);

            total = total + charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}