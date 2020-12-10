public class Database {

    BudgetData bd = new BudgetData();

    public double moneySpentThisMonth() {
        return bd.getMoneySpentOnFood() + bd.getMoneySpentOnbills() + bd.getMoneySpentOnJoy();
    }

    public double netWorth() {
        return bd.getMoneyThisMonth() - moneySpentThisMonth();
    }

    public double totalMoneySpent() {
        return moneySpentThisMonth() * bd.getMonths();
    }
}