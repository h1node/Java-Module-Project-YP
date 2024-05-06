import java.util.ArrayList;
import java.util.Scanner;

public class Calculated {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    double totalAmount = 0.0;

    public void countItems() {
        String answer;

        do {
            System.out.println("Введите название товара:");
            String name = readProductName();
            double price = readProductPrice();

            Product product = new Product(name, price);
            products.add(product);
            System.out.println("Товар \"" + product.name + "\" добавлен");

            totalAmount += price;
            System.out.println("Общая сумма всех товаров: " + String.format("%.2f", totalAmount) + " руб.");

            do {
                System.out.println("Хотите добавить еще один товар? (да/нет)");
                answer = scanner.nextLine();
                if (!answer.equalsIgnoreCase("да") && !answer.equalsIgnoreCase("нет")) {
                    System.out.println("Пожалуйста, введите 'да' или 'нет'.");
                }
            } while (!answer.equalsIgnoreCase("да") && !answer.equalsIgnoreCase("нет"));
        } while (!answer.equalsIgnoreCase("нет"));
    }

    private String readProductName() {
        String name;
        do {
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Название товара не может быть пустым. Пожалуйста, введите непустое название.");
            }
        } while (name.trim().isEmpty());
        return name;
    }

    private double readProductPrice() {
        double price;
        do {
            System.out.println("Введите стоимость товара в формате рубли,копейки");
            while (!scanner.hasNextDouble()) {
                System.out.println("Неверный формат. Пожалуйста, введите число в формате рубли,копейки.");
                scanner.nextLine();
            }
            price = scanner.nextDouble();
            scanner.nextLine();
        } while (price <= 0);
        return price;
    }

    public void displayProducts() {
        System.out.println("Список добавленных товаров:");
        for (Product item : products) {
            System.out.println("Название: " + item.name + ", Стоимость: " + item.price + " руб.");
        }
    }

    public void calculatePerPerson(int quantity) {
        TotalAmountSplitter.calculatePerPerson(totalAmount, quantity);
    }
}

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
