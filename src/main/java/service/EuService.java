package service;

import model.RandomWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EuService {

    private static final String ANSI_WHITE = "\u001B[36m";
    private final static File allFile = new File("all.txt");
    private final static File newWordsFile = new File("new_words.txt");
    private final static File newPhrasesFile = new File("new_phrases.txt");
    private final static File newVerbForms = new File("new_verb_forms.txt");
    private final static File repetitionOfOldWords = new File("old_words.txt");
    private final static String REGEX = "-";
    private final Random random = new Random();

    public List<RandomWord> readingFileWithWords() {
        List<RandomWord> list = new ArrayList<>();
        try {
            try (var br = new BufferedReader(new FileReader(repetitionOfOldWords))) {
                br.lines().forEach(line -> {
                    convertingStringToRandomWord(list, line);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public RandomWord getRandomWord(List<RandomWord> list) {
        var randomWord = list.get(random.nextInt(list.size()));
        if (randomWord.isUsed()) {
            return getRandomWord(list);
        } else {
            randomWord.isNotUsed();
            return randomWord;        }
    }

    public boolean readingFromConsole(RandomWord randomWord) {
        System.out.println(ANSI_WHITE + "Напишите перевод слова: " + randomWord.getSecondWord());
        var scanner = new Scanner(System.in);
        var consoleText = scanner.nextLine();
        return randomWord.getFirstWord().equals(consoleText);
    }

    private void convertingStringToRandomWord(List<RandomWord> list, String text) {
        var translate = text.split(REGEX);
        list.add(new RandomWord(translate[0], translate[1]));
    }

}
