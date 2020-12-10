import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private JPanel topPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel mainPanel = new JPanel();

    private JTextField moneyThisMonthField = new JTextField();
    private JTextField moneySpentOnFoodField = new JTextField();
    private JTextField moneySpentOnBillsField = new JTextField();
    private JTextField moneySpentOnJoyField = new JTextField();

    private JLabel moneyThisMonthLabel = new JLabel("Hur mycket pengar fick du denna månad?");
    private JLabel moneySpentOnFoodLabel = new JLabel("Hur mycket pengar spenderade du på mat denna månad?");
    private JLabel moneySpentOnBillsLabel = new JLabel("Hur mycket pengar spenderade du på livsviktiga saker?");
    private JLabel moneySpentOnJoyLabel = new JLabel("Hur mycket pengar spenderade du på njutbara saker?");

    private JLabel moneySpentThisMonth = new JLabel();
    private JLabel totalMoneySpent = new JLabel();
    private JLabel foodStatistics = new JLabel();
    private JLabel billStatistics = new JLabel();
    private JLabel joyStatistics = new JLabel();
    private JLabel netWorthLabel = new JLabel();

    private JButton calculateButton = new JButton("Räkna ut budget");

    public GUI() {

        Database db = new Database();
        BudgetData bd = new BudgetData();

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(calculateButton, BorderLayout.CENTER);

        topPanel.setLayout(new GridLayout(4,2));
        topPanel.add(moneyThisMonthLabel);
        topPanel.add(moneyThisMonthField);
        topPanel.add(moneySpentOnFoodLabel);
        topPanel.add(moneySpentOnFoodField);
        topPanel.add(moneySpentOnBillsLabel);
        topPanel.add(moneySpentOnBillsField);
        topPanel.add(moneySpentOnJoyLabel);
        topPanel.add(moneySpentOnJoyField);

        centerPanel.setLayout(new GridLayout(6,1));
        centerPanel.add(moneySpentThisMonth);
        centerPanel.add(totalMoneySpent);
        centerPanel.add(foodStatistics);
        centerPanel.add(billStatistics);
        centerPanel.add(joyStatistics);
        centerPanel.add(netWorthLabel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        calculateButton.addActionListener(e->{

            if (moneyThisMonthField != null && moneySpentOnFoodField != null
                    && moneySpentOnBillsField != null && moneySpentOnJoyField != null) {

                bd.setMoneyThisMonth(moneyThisMonthField.getText());
                bd.setMoneySpentOnFood(moneySpentOnFoodField.getText());
                bd.setMoneySpentOnbills(moneySpentOnBillsField.getText());
                bd.setMoneySpentOnJoy(moneySpentOnJoyField.getText());

                double temp = Double.parseDouble(bd.getMoneySpentOnFood())
                        + Double.parseDouble(bd.getMoneySpentOnbills())
                        + Double.parseDouble(bd.getMoneySpentOnJoy());

                moneySpentThisMonth.setText("Du spenderade: " + temp + "kr denna månad");
                totalMoneySpent.setText("Du har spenderat " + temp + "kr totalt");

                double foodStat = Double.parseDouble(moneySpentOnFoodField.getText())
                        / temp * 100;

                double billStat = Double.parseDouble(moneySpentOnBillsField.getText())
                        / temp * 100;

                double joyStat = Double.parseDouble(moneySpentOnJoyField.getText()) /
                        temp * 100;

                foodStatistics.setText("Du spenderade: " + bd.getMoneySpentOnFood() + "kr på mat (" + foodStat + "%)");

                billStatistics.setText("Du spenderade: " + bd.getMoneySpentOnbills() + "kr på livsviktiga saker (" + billStat + "%)");

                joyStatistics.setText("Du spenderade: " + bd.getMoneySpentOnJoy() + "kr på njutfulla saker (" + joyStat + "%)");

                double netWorthTemp = Double.parseDouble(moneyThisMonthField.getText())
                        - Double.parseDouble(moneySpentOnFoodField.getText())
                        - Double.parseDouble(moneySpentOnBillsField.getText())
                        - Double.parseDouble(moneySpentOnJoyField.getText());

                netWorthLabel.setText("Såhär mycket pengar har du kvar: " + netWorthTemp);
            }
        });
    }
}