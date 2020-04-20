package hw4.builder;

import hw4.enums.*;
import java.util.List;

public class TestData {

    private List<String> summary;
    private List<Elements> elements;
    private Colors colors;
    private Metals metals;
    private List<Vegetables> vegetables;

    private TestData(List<String> summary, List<Elements> elements, Colors colors,
                     Metals metals, List<Vegetables> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<String> getSummary() {
        return summary;
    }

    public List<Elements> getElements() {
        return elements;
    }

    public Colors getColors() {
        return colors;
    }

    public Metals getMetals() {
        return metals;
    }

    public List<Vegetables> getVegetables() {
        return vegetables;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private List<String> summary;
        private List<Elements> elements;
        private Colors colors;
        private Metals metals;
        private List<Vegetables> vegetables;

        private TestData testData;

        public Builder() {
        }

        public Builder setSummary(List<String> summary) {
            this.summary = summary;
            return this;
        }

        public Builder setElements(List<Elements> elements) {
            this.elements = elements;
            return this;
        }

        public Builder setColors(Colors colors) {
            this.colors = colors;
            return this;
        }

        public Builder setMetals(Metals metals) {
            this.metals = metals;
            return this;
        }

        public Builder setVegetables(List<Vegetables> vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public TestData build() {
            return new TestData(summary, elements, colors, metals, vegetables);
        }
    }
}