package week9;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

class StandardParcel {
    double weight;

    StandardParcel(double weight) {
        this.weight = weight;
    }

    double calculateCharge() {
        return 40 + (10 * weight);
    }
}

class ExpressParcel extends StandardParcel implements Insurable {
    ExpressParcel(double weight) {
        super(weight);
    }

    double calculateCharge() {
        return 80 + (15 * weight);
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends StandardParcel implements Insurable {
    FragileParcel(double weight) {
        super(weight);
    }

    double calculateCharge() {
        return super.calculateCharge() + 50;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {

        StandardParcel[] parcels = {
                new StandardParcel(3),
                new ExpressParcel(2),
                new FragileParcel(4)
        };

        String[] types = {"STANDARD", "EXPRESS", "FRAGILE"};
        double[] values = {500, 1000, 2000};

        double grandTotal = 0;

        for (int i = 0; i < parcels.length; i++) {

            double charge = parcels[i].calculateCharge();
            double insurance = 0;

            if (parcels[i] instanceof Insurable) {
                insurance = ((Insurable) parcels[i])
                        .calculateInsurance(values[i]);
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    types[i], charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}