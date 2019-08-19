package com.sda.projects.gutenberg;

public class Main {
    public static void main(String[] args) {

        ConnectionService service=new ConnectionService();
        String text=service.connect();
        GutenbergService gutenbergService=new GutenbergService();
        PrintingService printingService=new PrintingService(text,gutenbergService);

        printingService.showTopTenWords();
        printingService.showStatisticsOfChars();
        printingService.showNumberOfMarks();
        printingService.showNumberOfNonAlfabeticMarks();
        printingService.showNumberOfSentences();
        printingService.showNumberOfWhitespaces();

    }
}
