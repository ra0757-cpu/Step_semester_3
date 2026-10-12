
package week9;

interface SaverMode {
    double reduceUnits(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return getPower() * hours / 1000;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {

        String[] types = {"FRIDGE", "AC", "TV", "WASHER"};
        double[] hours = {10, 4, 5, 2};
        boolean[] saver = {false, true, true, true};

        double totalCost = 0;

        for (int i = 0; i < types.length; i++) {
            Appliance appliance;

            switch (types[i]) {
                case "FRIDGE":
                    appliance = new Fridge(hours[i]);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours[i]);
                    break;
                case "TV":
                    appliance = new Television(hours[i]);
                    break;
                default:
                    appliance = new WashingMachine(hours[i]);
            }

            if (saver[i] && !(appliance instanceof SaverMode)) {
                System.out.println(types[i] + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver[i]) {
                units = ((SaverMode) appliance).reduceUnits(units);
            }

            double cost = appliance.calculateCost(units);
            totalCost += cost;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    types[i], units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
