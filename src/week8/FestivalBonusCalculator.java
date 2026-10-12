package week8;

public class FestivalBonusCalculator {

    public static void main(String[] args) {

        String[] types = {"FULLTIME", "PARTTIME", "INTERN"};
        String[] names = {"Asha", "Ravi", "Neha"};
        double[] salaries = {50000, 30000, 15000};

        double total = 0;

        for (int i = 0; i < types.length; i++) {

            double bonus = 0;

            if (types[i].equals("FULLTIME")) {
                bonus = salaries[i] * 0.10;
            } else if (types[i].equals("PARTTIME")) {
                bonus = salaries[i] * 0.05;
            } else if (types[i].equals("INTERN")) {
                bonus = 2000;
            }

            System.out.printf("%s: %.2f%n", names[i], bonus);

            total = total + bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}