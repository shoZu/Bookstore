import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Login {

    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, String> users = new HashMap<>();

    {
        users.put("admin", "admin123");
    }

    private void logIn() {
        System.out.println("Podaj login");
        String login = scanner.next();
        if (users.containsKey(login)) {
            System.out.println("Podaj haslo");
            String haslo = scanner.next();
            if (haslo.equals(users.get(login))) {
                Menu menu = new Menu();
                menu.chooseOption();
            } else {
                System.out.println("Chcesz sprobowac zalogowac sie jeszcze raz?");
                System.out.println("1. Tak");
                System.out.println("2. Nie");
                String option = scanner.next();
                if (option.equals("1")) {
                    logIn();
                }
            }
        } else {
            System.out.println("Nie ma uzytkownika o takiej nazwie");
            System.out.println("Chcesz sprobowac zalogowac sie jeszcze raz?");
            System.out.println("1. Tak");
            System.out.println("2. Nie");
            String option = scanner.next();
            if (option.equals("1")) {
                logIn();
            }

        }

    }
}