public class TotalAmountSplitter {

    public static void calculatePerPerson(double totalAmount, int quantity) {
        double perPersonAmount = totalAmount / quantity;

        double roundedAmount = Math.floor(perPersonAmount * 100) / 100;

        String formattedAmount;
        boolean isSpecialCase = Math.floor(roundedAmount * 100) % 100 >= 11 && Math.floor(roundedAmount * 100) % 100 <= 19;

        if (!isSpecialCase) {
            int lastDigit = (int) (roundedAmount * 100 % 10);
            switch (lastDigit) {
                case 1:
                    formattedAmount = String.format("%.2f рубль", roundedAmount);
                    break;
                case 2:
                case 3:
                case 4:
                    formattedAmount = String.format("%.2f рубля", roundedAmount);
                    break;
                default:
                    formattedAmount = String.format("%.2f рублей", roundedAmount);
            }
        } else {
            formattedAmount = String.format("%.2f рублей", roundedAmount);
        }

        System.out.println("Каждый человек должен заплатить: " + formattedAmount);
    }
}
