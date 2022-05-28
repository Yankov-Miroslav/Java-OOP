package trafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Color[] signals = Arrays.stream(in.nextLine().split("\\s+")).
                map(Color::valueOf).toArray(Color[]::new);

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (Color color : signals) {
            TrafficLight trafficLight = new TrafficLight(color);
            trafficLights.add(trafficLight);
        }

        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight + " ");
            }
            System.out.println();
        }

    }
}
