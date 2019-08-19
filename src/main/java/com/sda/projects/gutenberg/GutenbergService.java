package com.sda.projects.gutenberg;

import java.util.*;

public class GutenbergService {


    public long numberOfSentences(String text) {
        return text.split("[.!?]").length;
    }

    public Map<Character, Long> numberOfChars(String text) {
        Map<Character, Long> map = new HashMap<>();
        text.chars().filter(Character::isAlphabetic)
                .forEach(val -> map.put((char)val, map.get((char)val) == null ? 1 : map.get((char)val) + 1));
        return map;
    }

    public Map<String, Integer> topWords(String text) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.asList(text.toLowerCase().split("[\\W ,;.!?:]")).stream()
                .filter(w -> w.length() > 5)
                .forEach(w -> map.put(w, map.get(w) == null ? 1 : map.get(w) + 1));
        return map;
    }

    public int countMarks(String text) {
        return text.length();
    }

    public int countWhiteSpaces(String text) {
        return (int) text.chars()
                .filter(ch -> Character.isWhitespace(ch))
                .count();
    }

    public int countNonAlfabetic(String text) {
        return (int) text.chars().filter(codePoint -> !(Character.isAlphabetic(codePoint)))
                .count()-countWhiteSpaces(text);
    }
}

