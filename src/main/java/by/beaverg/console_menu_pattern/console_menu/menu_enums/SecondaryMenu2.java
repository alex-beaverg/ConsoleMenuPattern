package by.beaverg.console_menu_pattern.console_menu.menu_enums;

public enum SecondaryMenu2 implements IMenu {
    DO_SOMETHING_AND_STAY_HERE("Do something and stay here"),
    DO_SOMETHING_AND_GO_TO_MAIN_MENU("Do something and go to the Main Menu"),
    RETURN_TO_THE_MAIN_MENU("Return to the Main Menu"),
    EXIT("Exit");

    private final String title;

    SecondaryMenu2(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
