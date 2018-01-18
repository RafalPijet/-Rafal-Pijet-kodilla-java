package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args){
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String exampleText = "Jestem sobie wesoły Romek i mam na przedmieściu domek.";
        System.out.println("Oryginalny tekst: " + exampleText);
        System.out.println();
        poemBeautifier.beautify(exampleText, text -> text.toUpperCase());
        poemBeautifier.beautify(exampleText, text -> text.toLowerCase());
        poemBeautifier.beautify(exampleText, text -> text.concat("\b\b\b\b\b\b\b chatę."));
        poemBeautifier.beautify(exampleText, text -> text.substring(13, 25).concat(" ma domek"));
        poemBeautifier.beautify(exampleText, text -> text.replace("Jestem", "Byłem").replace("mam", "miałem"));
        poemBeautifier.beautify(exampleText, text -> text.replaceFirst("m", "ś").substring(0, 28).concat("już!"));

    }
}
