import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);


    public void quantityOfPeople() {
        Calculated calculated = new Calculated();

        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            if (scanner.hasNextInt()) {
                int quantity = scanner.nextInt();
                if (quantity <= 1) {
                    System.out.println("Количество людей должно быть больше 1.");
                } else {
                    scanner.nextLine();
                    calculated.countItems();

                    System.out.println("Все товары добавлены. Показать список и посчитать счет? (да/нет)");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("да")) {
                        calculated.displayProducts();
                        calculated.calculatePerPerson(quantity);
                    }
                    return;
                }
            } else {
                System.out.println("Введите целое число.");
                scanner.next();
            }
        }
    }
}
