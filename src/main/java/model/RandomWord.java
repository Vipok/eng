package model;

public class RandomWord {

    public String firstWord;
    public String secondWord;
    private boolean isNotUsed;

    public RandomWord(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public boolean isUsed() {
        return isNotUsed;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void isNotUsed() {
        this.isNotUsed = true;
    }

}
