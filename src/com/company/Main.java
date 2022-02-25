package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      System.out.println("Please write your sentense!");
      String sentence = sc.nextLine();
        String[] sentenceWords = sentence.split(" ");
        System.out.println(sentenceWords.length + " words");
        System.out.println(sentence.length() + " characters");

        List<WordOccurrence> results = OrderedWordOccurrences(sentenceWords);

        results.stream().forEach(occurrence -> {
            System.out.println(occurrence.toString());
        });
    }

    private static List<WordOccurrence> OrderedWordOccurrences(String[] sentenceWords)
    {
        ArrayList sentenceWordList = new ArrayList<String>(Arrays.asList(sentenceWords));
        List<WordOccurrence> results = new ArrayList<WordOccurrence>();

        sentenceWordList.stream().distinct().forEach(word -> {
            int count = (int) sentenceWordList.stream().filter(x -> x.equals(word.toString())).count();

            WordOccurrence wordOccurrence = new WordOccurrence();
            wordOccurrence.setWord(word.toString());
            wordOccurrence.setCount(count);
            results.add(wordOccurrence);
        });

        Collections.sort(results);
        return  results;
    }
}

class WordOccurrence implements Comparable<WordOccurrence> {
    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    //Desc
    @Override
    public int compareTo(WordOccurrence o) {
        return o.getCount() - this.Count;
    }

    @Override
    public String toString() {
      return  this.getWord() + " " + this.getCount();
    }
    private String Word;
    private int Count;
}
