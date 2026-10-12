package week10;
import java.util.Arrays;

public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] rotated = new String[n];

        int shift = k % n;

        for (int i = 0; i < n; i++) {
            int newIndex = (i + shift) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};

        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}