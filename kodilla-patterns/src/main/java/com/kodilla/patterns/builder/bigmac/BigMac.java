package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {
    public static final boolean YES = true;
    public static final boolean NO = false;
    public static final String STANDARD = "STANDARD";
    public static final String THOUSAND_ISLAND = "THOUSAND_ISLAND";
    public static final String BARBECUE = "BARBECUE";
    public static final String SALAD = "SALAD";
    public static final String ONION = "ONION";
    public static final String BACON = "BACON";
    public static final String CUCUMBER = "CUCUMBER";
    public static final String CHILLI = "CHILLI";
    public static final String MUSHROOMS = "MUSHROOMS";
    public static final String SHRIMP = "SHRIMP";
    public static final String CHEESE = "CHEESE";
    private final boolean roll;
    private final int burgers ;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigMacBuilder {
        private boolean roll;
        private int burgers = 2;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigMacBuilder giveRoll(boolean isSesame) {
            this.roll = isSesame;
            return this;
        }

        public BigMacBuilder giveBurgers(int burgers) {
            if (burgers >= 2) {
                this.burgers = burgers;
            } else {
                throw new IllegalStateException("Quantity of burgers must be greather than two or equal!");
            }
            return this;
        }

        public BigMacBuilder giveSauce(String sauce) {
            if (sauce == STANDARD || sauce == THOUSAND_ISLAND || sauce == BARBECUE) {
                this.sauce = sauce;
            } else {
                throw new IllegalStateException("Unavailable value for the sauce field!");
            }
            return this;
        }

        public BigMacBuilder giveIngredients(String ingedients) {
            if (ingedients == SALAD || ingedients == ONION || ingedients == BACON || ingedients == CHILLI || ingedients == MUSHROOMS || ingedients == SHRIMP || ingedients == CHEESE || ingedients == CUCUMBER) {
                ingredients.add(ingedients);
            } else {
                throw new IllegalStateException("Unavailable value for the ingredients field!");
            }
            return this;
        }

        public BigMac build() {
            return new BigMac(roll, burgers, sauce, ingredients);
        }
    }

    private BigMac(final boolean isSesame, final int burgers, final String sauce, List<String> ingredients) {
        this.roll = isSesame;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public boolean isSesame() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "withSesame=" + roll +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                "\ningredients=" + ingredients +
                '}';
    }
}
