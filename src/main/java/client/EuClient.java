package client;

import service.EuService;

public class EuClient {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public void programLogic() {
        var countCorrectAnswer = 0;
        var countIncorrectAnswer = 0;
        var euService = new EuService();
        var words = euService.readingFileWithWords();
        for (int i = 0; i < words.size(); i++) {
            if (euService.readingFromConsole(euService.getRandomWord(words))) {
                ++countCorrectAnswer;
                System.out.println(ANSI_GREEN + "Правильно!");
            } else {
                ++countIncorrectAnswer;
                System.out.println(ANSI_RED + "Неправильно!");
            }
        }
        System.out.println(ANSI_GREEN + "Правильных ответов: " + countCorrectAnswer);
        System.out.println(ANSI_RED + "Неправильных ответов: " + countIncorrectAnswer);
    }

}
