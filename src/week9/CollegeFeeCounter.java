package week9;

interface BusUser {
    boolean usesBus();
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    public boolean usesBus() {
        return true;
    }

    double calculateFee() {
        return 40000 + 12000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    public boolean usesBus() {
        return true;
    }

    double calculateFee() {
        return 20000 + 12000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {

        Student[] students = {
                new DayScholar("Asha"),
                new Hosteller("Ravi"),
                new Scholar("Neha")
        };

        double total = 0;

        for (Student student : students) {
            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n",
                    student.name, fee);

            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}