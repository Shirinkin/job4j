package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    public int ask (String question,int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value =  super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please input validate data.");
            } catch (MenuOutException moe) {
            System.out.println("ERROR. Select Key from Menu");
        }
        } while (invalid);
        return value;
    }
}