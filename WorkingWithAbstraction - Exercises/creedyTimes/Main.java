package creedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long input = Long.parseLong(in.nextLine());
        String[] safe = in.nextLine().split("\\s+");

        Map<String, Map<String, Long>> bag = new LinkedHashMap<>();

        for (int i = 0; i < safe.length; i += 2) {

            String name = safe[i];
            long number = Long.parseLong(safe[i + 1]);

            String currentItem = "";

            if (name.length() == 3) {
                currentItem = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                currentItem = "Gem";
            } else if (name.equalsIgnoreCase("gold")) {
                currentItem = "Gold";
            }

            if (currentItem.equals("")) {
                continue;
            } else if (input < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + number) {
                continue;
            }

            switch (currentItem) {
                case "Gem":
                    if (!bag.containsKey(currentItem)) {
                        if (bag.containsKey("Gold")) {
                            if (number > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(currentItem).values().stream().mapToLong(e -> e).sum() + number > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(currentItem)) {
                        if (bag.containsKey("Gem")) {
                            if (number > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(currentItem).values()
                            .stream().mapToLong(e -> e)
                            .sum() + number > bag.get("Gem").values()
                            .stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(currentItem)) {
                bag.put((currentItem), new LinkedHashMap<>());
            }

            if (!bag.get(currentItem).containsKey(name)) {
                bag.get(currentItem).put(name, 0L);
            }

            bag.get(currentItem).put(name, bag.get(currentItem).get(name) + number);

        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}