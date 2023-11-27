package by.beaverg.console_menu_pattern.console_menu;

import by.beaverg.console_menu_pattern.console_menu.menu_enums.IMenu;
import by.beaverg.console_menu_pattern.console_menu.menu_enums.MainMenu;
import by.beaverg.console_menu_pattern.console_menu.menu_enums.SecondaryMenu1;
import by.beaverg.console_menu_pattern.console_menu.menu_enums.SecondaryMenu2;
import by.beaverg.console_menu_pattern.util.custom_exceptions.EmptyInputException;
import by.beaverg.console_menu_pattern.util.custom_exceptions.MenuItemOutOfBoundsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.beaverg.console_menu_pattern.util.Printers.*;

public class ConsoleMenu {
    private static final Logger LOGGER = LogManager.getLogger(ConsoleMenu.class);

    public void runApp() {
        PRINT2LN.info("Application with console menu");
        runMainMenu();
    }

    private ConsoleMenu tearDown() {
        RequestMethods.closeScanner();
        PRINTLN.info("Good bye!");
        return null;
    }

    private int runAnyMenu(String title, IMenu[] menuItems) {
        int index = 1;
        PRINT2LN.info(title);
        for (IMenu item : menuItems) {
            PRINTLN.info("[" + index + "] - " + item.getTitle());
            index++;
        }
        int answer;
        do {
            try {
                answer = RequestMethods.requestingInfoWithChoice("Enter the menu item number: ", index - 1);
                break;
            } catch (EmptyInputException | MenuItemOutOfBoundsException e) {
                LOGGER.error(e.getMessage());
            } catch (NumberFormatException e) {
                LOGGER.error("[NumberFormatException]: Entered data is not a number!");
            }
        } while (true);
        return answer;
    }

    private ConsoleMenu runMainMenu() {
        int answer = runAnyMenu("Main menu:", MainMenu.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("Do something");
                return runSecondaryMenu1();
            }
            case (2) -> {
                PRINT2LN.info("Do something");
                return runSecondaryMenu2();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private ConsoleMenu runSecondaryMenu1() {
        int answer = runAnyMenu("Secondary menu 1:", SecondaryMenu1.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("Do something");
                return runSecondaryMenu1();
            }
            case (2) -> {
                PRINT2LN.info("Do something");
                return runMainMenu();
            }
            case (3) -> {
                return runMainMenu();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private ConsoleMenu runSecondaryMenu2() {
        int answer = runAnyMenu("Secondary menu 2:", SecondaryMenu2.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("Do something");
                return runSecondaryMenu2();
            }
            case (2) -> {
                PRINT2LN.info("Do something");
                return runMainMenu();
            }
            case (3) -> {
                return runMainMenu();
            }
            default -> {
                return tearDown();
            }
        }
    }
}