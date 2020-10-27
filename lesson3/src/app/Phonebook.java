package app;

import java.util.*;

public class Phonebook {

    private final Map< String, Set> PHONEBOOK = new HashMap<>();

    public void add( String surname, String[] telephones ) {
        Set< String > setTelephones = new HashSet<>( Arrays.asList( telephones ) );
        PHONEBOOK.put( surname, setTelephones );
    }

    public void get(String surname) {
        System.out.println("\n======================================================\n");
        System.out.println("Контакт: " + surname + "\nНомер/а телефон/ов :" + PHONEBOOK.get(surname));
        System.out.println("\n======================================================\n");
    }

}
