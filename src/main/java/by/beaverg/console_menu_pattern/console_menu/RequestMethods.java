package by.beaverg.console_menu_pattern.console_menu;

import static by.beaverg.console_menu_pattern.util.Printers.*;

import by.beaverg.console_menu_pattern.util.custom_exceptions.EmptyInputException;
import by.beaverg.console_menu_pattern.util.custom_exceptions.MenuItemOutOfBoundsException;

import java.util.Scanner;

public class RequestMethods {
    private static final Scanner scanner = new Scanner(System.in);

    public static int requestingInfoWithChoice(String text, int menuItemsNumber)
            throws EmptyInputException, NumberFormatException, MenuItemOutOfBoundsException {
        PRINT.info(text);
        String answer = scanner.nextLine();
        if (answer.isEmpty()) {
            throw new EmptyInputException("[EmptyInputException]: Entered data can not be empty!");
        }
        int numberFromAnswer = Integer.parseInt(answer);
        if (numberFromAnswer < 1 || numberFromAnswer > menuItemsNumber) {
            throw new MenuItemOutOfBoundsException("[MenuItemNumberOutOfBoundsException]: Entered data " +
                    "must be equal to some menu item!");
        }
        return numberFromAnswer;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
