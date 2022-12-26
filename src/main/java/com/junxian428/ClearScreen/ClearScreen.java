package com.junxian428.ClearScreen;

public class ClearScreen {

    public void clearscreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        }

        catch (final Exception e) {
            e.printStackTrace();
        }
    }
}