public class TotalAmountSplitter {

    public static void calculatePerPerson(double totalAmount, int quantity) {
        double perPersonAmount = totalAmount / quantity;

        String formattedAmount;
        if (perPersonAmount == Math.floor(perPersonAmount)) {
            formattedAmount = String.format("%.0f рубль", perPersonAmount);
        } else {
            formattedAmount = String.format("%.2f рубля", perPersonAmount).replace(".", ",");
        }

        System.out.println("Каждый человек должен заплатить: " + formattedAmount);
    }
}
