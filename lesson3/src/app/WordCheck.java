package app;

import java.util.*;

public class WordCheck {
    private final List<String> WORD = new ArrayList<>(Arrays.asList(
            "тащить",
            "пожилой",
            "известный",
            "молитва",
            "сын",
            "комплекс",
            "финансовый",
            "учащийся",
            "сохранять",
            "низкий",
            "пожилой",
            "учащийся",
            "сын",
            "известный",
            "низкий",
            "тащить",
            "сохранять",
            "низкий",
            "молитва",
            "комплекс",
            "пожилой",
            "сохранять",
            "учащийся",
            "финансовый",
            "форт"
            ));

    private final Set<String> UNIQUE = new HashSet<>(WORD);
    private final Map<String, Integer> REPETITIONS = new HashMap<>();

    public void run() {
        for (String s : WORD) {
            Integer counter = REPETITIONS.getOrDefault(s, 0);
            REPETITIONS.put(s, counter + 1);
        }

        System.out.println("\n======================================================\n");
        System.out.println(WORD);
        System.out.println("Уникальный слов " + UNIQUE.size());
        for (Map.Entry<String, Integer> entry : REPETITIONS.entrySet()) {
            System.out.println("Слово: ( " + entry.getKey() + " ) повторяеться: " + entry.getValue() + " раз");
        }
        System.out.println("\n======================================================\n");
    }
}
