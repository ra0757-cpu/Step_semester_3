
package week9;

interface NightService {
    double addNightCharge(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateFare();

    double minimumFare(double fare) {
        return Math.max(100, fare);
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double calculateFare() {
        return minimumFare(km * 10);
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double calculateFare() {
        return minimumFare(km * 14);
    }

    public double addNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double calculateFare() {
        return minimumFare(km * 18);
    }

    public double addNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        String[] types = {"MINI", "SEDAN", "SUV", "MINI"};
        double[] distances = {8, 10, 20, 5};
        String[] times = {"DAY", "NIGHT", "DAY", "NIGHT"};

        double total = 0;

        for (int i = 0; i < types.length; i++) {
            Cab cab;

            switch (types[i]) {
                case "MINI":
                    cab = new Mini(distances[i]);
                    break;
                case "SEDAN":
                    cab = new Sedan(distances[i]);
                    break;
                default:
                    cab = new SUV(distances[i]);
            }

            if (times[i].equals("NIGHT")) {
                if (!(cab instanceof NightService)) {
                    System.out.println(
                            types[i] + ": night service not available");
                    continue;
                }

                double fare = ((NightService) cab)
                        .addNightCharge(cab.calculateFare());

                System.out.printf("%s: %.2f%n", types[i], fare);
                total += fare;
            } else {
                double fare = cab.calculateFare();
                System.out.printf("%s: %.2f%n", types[i], fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
