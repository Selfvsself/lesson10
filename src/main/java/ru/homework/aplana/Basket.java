package ru.homework.aplana;

import java.util.ArrayList;

public class Basket {
    private static ArrayList<Product> arrayBasket;
    private static Basket basket;

    private Basket() {
        arrayBasket = new ArrayList<>();
    }

    public static Basket getBasket() {
        if (basket == null) {
            basket = new Basket();
        }
        return basket;
    }

    public static Product getProduct(int index) {
        return arrayBasket.get(index);
    }

    public static void putProduct(Product product) {
        arrayBasket.add(product);
    }

    public static void clean() {
        arrayBasket.clear();
    }

    public int getSize() {
        return arrayBasket.size();
    }

    public boolean equals(ArrayList<Product> array) {
        boolean answer = true;
        if (arrayBasket.size() != array.size()) {
            answer = false;
        }
        for (Product product : array) {
            if (!checkPresence(product)) {
                answer = false;
            }
        }
        return answer;
    }

    private boolean checkPresence(Product product) {
        for (Product pr : arrayBasket) {
            if (pr.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public Product getMaxPice() {
        Product maxPrice = new Product("maxPrice", 0);
        for (Product product : arrayBasket) {
            if (maxPrice.getPrice() < product.getPrice()) {
                maxPrice = product;
            }
        }
        return maxPrice;
    }

    public String getAllInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Product product : arrayBasket) {
            stringBuilder.append(product.getInfo()).append("\n");
        }
        stringBuilder.append("\nМаксимальная цена: ").append(getMaxPice().getInfo());
        return stringBuilder.toString();
    }

}
