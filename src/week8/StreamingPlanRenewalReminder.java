package week8;

import java.time.LocalDate;

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {

        String[] types = {"BASIC", "STANDARD", "PREMIUM", "BASIC"};
        String[] names = {"Asha", "Ravi", "Neha", "Kiran"};
        String[] dates = {
                "2024-01-15",
                "2024-02-01",
                "2024-03-10",
                "2024-12-20"
        };

        int[] validity = {30, 90, 365, 30};

        for (int i = 0; i < types.length; i++) {

            LocalDate startDate = LocalDate.parse(dates[i]);

            LocalDate renewalDate =
                    startDate.plusDays(validity[i]);

            System.out.println(names[i] + ": " + renewalDate);
        }
    }
}