package hw_jdi;


import hw_jdi.pages.HomePage;
import hw_jdi.pages.MetalsAndColorsPage;

public class JdiSite {

    public static HomePage homePage;
    public static MetalsAndColorsPage metalAndColorsPage;

    public static void open() {
        homePage.open();
    }
}
