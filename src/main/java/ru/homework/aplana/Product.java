package ru.homework.aplana;

public class Product {
    private String name;
    private double price;

    public Product() {
        this.name = "";
        this.price = 0;
    }

    public Product(String name, double price) {
        this.name = "";
        this.price = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPrice(String price) {
        try {
            this.price = Double.parseDouble(getNormalText(price));
        } catch (IllegalArgumentException e) {
            this.price = 0;
        }
    }

    private String getNormalText(String str) {
        StringBuilder answer = new StringBuilder();
        char[] arrayChar = str.toCharArray();
        for (char ch : arrayChar) {
            if (Character.isLetterOrDigit(ch)) {
                answer.append(ch);
            }
        }
        return answer.toString();
    }

    public boolean equals(Product product) {
        if (getName().equals(product.getName()) && getPrice() == product.getPrice()) {
            return true;
        }
        return false;
    }

    public String getInfo() {
        return "Товар " + getName() + ". По цене: " + getPrice() + "р";
    }
}
