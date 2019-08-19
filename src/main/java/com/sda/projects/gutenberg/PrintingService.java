package com.sda.projects.gutenberg;

import java.util.Comparator;

import static java.util.Map.Entry.comparingByValue;

public class PrintingService {
    private String text;
    GutenbergService gutenbergService;

    public PrintingService(String text, GutenbergService gutenbergService) {
        this.text = text;
        this.gutenbergService = gutenbergService;
    }

    public void showStatisticsOfChars() {
        gutenbergService.numberOfChars(text).entrySet().stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .forEach(v -> System.out.println(v.getKey() + ": " + v.getValue()));
    }
    public void showTopTenWords(){
        gutenbergService.topWords(text).entrySet().stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(w-> System.out.println(w.getKey()+": "+w.getValue()));
    }
    public void showNumberOfSentences(){
        System.out.println("Liczba zdań : "+gutenbergService.numberOfSentences(text));
    }
    public void showNumberOfWhitespaces(){
        System.out.println("Liczba białych znaków : "+gutenbergService.countWhiteSpaces(text));
    }
    public void showNumberOfMarks(){
        System.out.println("Liczba wszystkich znaków : "+gutenbergService.countMarks(text));
    }
    public void  showNumberOfNonAlfabeticMarks(){
        System.out.println("Liczba znaków niealfabetycznych :  "+gutenbergService.countNonAlfabetic(text));
    }
}
