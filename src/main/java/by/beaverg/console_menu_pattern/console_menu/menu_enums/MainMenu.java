package by.beaverg.console_menu_pattern.console_menu.menu_enums;

public enum MainMenu implements IMenu {
    DO_SOMETHING_AND_STAY_HERE("Do something and stay here"),
    DO_SOMETHING_AND_GO_TO_THE_SECONDARY_MENU_1("Do something and go to the Secondary Menu 1"),
    DO_SOMETHING_AND_GO_TO_THE_SECONDARY_MENU_2("Do something and go to the Secondary Menu 2"),
    EXIT("Exit");

    private final String title;

    MainMenu(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
