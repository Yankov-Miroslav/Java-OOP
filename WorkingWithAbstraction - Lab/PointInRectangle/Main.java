package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] coordinates = readArray(in);
        Point pointA = new Point(coordinates[0], coordinates[1]);
        Point pointC = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(pointA, pointC);

        int n = Integer.parseInt(in.nextLine());

        while (n-- > 0) {
            int[] tokens = readArray(in);

            Point p = new Point(tokens[0], tokens[1]);

            boolean isInside = rectangle.isInside(p);

            System.out.println(isInside);
        }
    }

    public static int[] readArray(Scanner in) {
        return Arrays.stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
