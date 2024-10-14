public class Office extends Building {

    @Override
    public double getPricePerMonth() {
        return 2000;
    }

    @Override
    public double estimateExpense(int months) {
        return 200 * months;
    }
}
