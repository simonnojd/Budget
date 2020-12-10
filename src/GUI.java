import javax.swing.*;

public class GUI extends JFrame {

    private JPanel panel = new JPanel();

    private JTextField moneyThisMonthField = new JTextField("Hur mycket pengar fick du denna månad?");
    private JTextField moneySpentOnFoodField = new JTextField("Hur mycket pengar spenderade du på mat denna månad?");
    private JTextField moneySpentOnBillsField = new JTextField("Hur mycket pengar spenderade du på livsviktiga saker?");
    private JTextField moneySpentOnJoyField = new JTextField("Hur mycket pengar spenderade du på njutbara saker?");

    private JLabel moneySpentThisMonth = new JLabel();
    private JLabel totalMoneySpent = new JLabel();
    private JLabel statistics = new JLabel();

    private JButton calculateButton = new JButton();

    public GUI() {




    }

}
