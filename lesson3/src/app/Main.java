package app;

public class Main {
    public static void main(String[] args) {
        WordCheck wordCheck = new WordCheck();
        wordCheck.run();

        Phonebook phonebook = new Phonebook();
        phonebook.add("Петров", new String[]{"89053214598", "89263574597", "89263574594"});
        phonebook.add("Иванов", new String[]{"89512365489"});
        phonebook.add("Сидоров", new String[]{"89751235845", "89261598726"});

        phonebook.get("Сидоров");
    }
}
