public class House extends Building {

    @Override
    public double getPricePerMonth() {
        return 1000;
    }

    @Override
    public double estimateExpense(int months) {
        return 100 * months;
    }
}
