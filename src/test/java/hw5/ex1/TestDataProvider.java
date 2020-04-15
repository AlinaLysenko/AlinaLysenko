package hw5.ex1;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class TestDataProvider {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {new ArrayList<String>() {{
                    add("HOME");
                    add("CONTACT FORM");
                    add("SERVICE");
                    add("METALS & COLORS");
                }}
                ,
                new ArrayList<String>() {{
                    add("To include good practices\nand ideas from successful\nEPAM project");
                    add("To be flexible and\ncustomizable");
                    add("To be multiplatform");
                    add("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026");
                }}
                ,
                new ArrayList<String>() {{
                    add("Home");
                    add("Contact form");
                    add("Service");
                    add("Metals & Colors");
                    add("Elements packs");
                }}
                },

        };
    }
}
