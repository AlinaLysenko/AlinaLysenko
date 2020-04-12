package hw4.ex2;

import hw4.builder.TestData;
import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import org.testng.annotations.DataProvider;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;

public class TestDataProvider {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {TestData.builder().setElements(Arrays.asList(Elements.Earth))
                        .setColors(Colors.Yellow).setMetals(Metals.Gold).build(),
                        new ArrayList<String>() {{
                            add("Summary: 3");
                            add("Elements: Earth");
                            add("Color: Yellow");
                            add("Metal: Gold");
                            add("Vegetables:");
                        }}
                },

        {
            TestData.builder().setSummary(Arrays.asList("3", "8"))
                    .setVegetables(Arrays.asList(Vegetables.Cucumber, Vegetables.Tomato)).build(),
                new ArrayList<String>() {{
                    add("Summary: 11");
                    add("Color: Colors");
                    add("Metal: Metals");
                    add("Vegetables: Cucumber, Tomato");
                }}
        },

        {
            TestData.builder().setSummary(Arrays.asList("3", "2"))
                    .setElements(Arrays.asList(Elements.Water, Elements.Wind, Elements.Fire))
                    .setMetals(Metals.Bronze).setVegetables(Arrays.asList(Vegetables.Onion)).build(),
                new ArrayList<String>() {{
                    add("Summary: 5");
                    add("Elements: Water, Wind, Fire");
                    add("Color: Colors");
                    add("Metal: Bronze");
                    add("Vegetables: Onion");
                }}
        },

        {
            TestData.builder().setSummary(Arrays.asList("6", "5"))
                    .setElements(Arrays.asList(Elements.Water))
                    .setColors(Colors.Green).setMetals(Metals.Selen)
                    .setVegetables(Arrays.asList
                            (Vegetables.Cucumber, Vegetables.Tomato, Vegetables.Vegetables, Vegetables.Onion)).build(),
                new ArrayList<String>() {{
                    add("Summary: 11");
                    add("Elements: Water");
                    add("Color: Green");
                    add("Metal: Selen");
                    add("Vegetables: Cucumber, Tomato, Vegetables, Onion");
                }}
        },

        {
            TestData.builder().setElements(Arrays.asList(Elements.Fire))
                    .setColors(Colors.Blue)
                    .setVegetables(Arrays.asList(
                            Vegetables.Cucumber, Vegetables.Tomato, Vegetables.Vegetables)).build(),
                new ArrayList<String>() {{
                    add("Summary: 3");
                    add("Elements: Fire");
                    add("Color: Blue");
                    add("Metal: Metals");
                    add("Vegetables: Cucumber, Tomato, Vegetables");
                }}
        }
        };
    }
}
