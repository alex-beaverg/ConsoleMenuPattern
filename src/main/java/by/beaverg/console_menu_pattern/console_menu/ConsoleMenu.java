package by.beaverg.console_menu_pattern.console_menu;

import by.beaverg.console_menu_pattern.console_menu.menu_enums.*;
import by.beaverg.console_menu_pattern.util.custom_exceptions.*;
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

    private int drawAnyMenuAndChooseMenuItem(String title, IMenu[] menuItems) {
        int index = 1;
        PRINT2LN.info(title);
        for (IMenu item : menuItems) {
            PRINTLN.info("[" + index + "] - " + item.getTitle());
            index++;
        }
        int answer;
        do {
            try {
                answer = RequestMethods.menuItemRequest("Enter the menu item number: ", index - 1);
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
        int answer = drawAnyMenuAndChooseMenuItem("Main menu:", MainMenu.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("Do something and stay in the Main Menu");
                return runMainMenu();
            }
            case (2) -> {
                PRINT2LN.info("Do something and go to the Secondary Menu 1");
                return runSecondaryMenu1();
            }
            case (3) -> {
                PRINT2LN.info("Do something and go to the Secondary Menu 2");
                return runSecondaryMenu2();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private ConsoleMenu runSecondaryMenu1() {
        int answer = drawAnyMenuAndChooseMenuItem("Secondary menu 1:", SecondaryMenu1.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("Do something and stay in the Secondary Menu 1");
                return runSecondaryMenu1();
            }
            case (2) -> {
                PRINT2LN.info("Do something and go to the Main Menu");
                return runMainMenu();
            }
            case (3) -> {
                // Do nothing
                return runMainMenu();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private ConsoleMenu runSecondaryMenu2() {
        int answer = drawAnyMenuAndChooseMenuItem("Secondary menu 2:", SecondaryMenu2.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("Do something and stay in the Secondary Menu 2");
                return runSecondaryMenu2();
            }
            case (2) -> {
                PRINT2LN.info("Do something and go to the Main Menu");
                return runMainMenu();
            }
            case (3) -> {
                // Do nothing
                return runMainMenu();
            }
            default -> {
                return tearDown();
            }
        }
    }
}
