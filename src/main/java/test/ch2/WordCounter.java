package test.ch2;

public class WordCounter {

    public int countWords(String sentence){
        return sentence.split(" ").length;
    }
}
