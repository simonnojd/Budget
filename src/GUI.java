import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private final JTextField moneyThisMonthField = new JTextField();
    private final JTextField moneySpentOnFoodField = new JTextField();
    private final JTextField moneySpentOnBillsField = new JTextField();
    private final JTextField moneySpentOnJoyField = new JTextField();

    private final JLabel moneySpentThisMonth = new JLabel();
    private final JLabel totalMoneySpent = new JLabel();
    private final JLabel foodStatistics = new JLabel();
    private final JLabel billStatistics = new JLabel();
    private final JLabel joyStatistics = new JLabel();
    private final JLabel netWorthLabel = new JLabel();

    public GUI() {

        BudgetData bd = new BudgetData();

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        JButton calculateButton = new JButton("Räkna ut budget");
        bottomPanel.add(calculateButton, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4,2));
        JLabel moneyThisMonthLabel = new JLabel("Hur mycket pengar fick du denna månad?");
        topPanel.add(moneyThisMonthLabel);
        topPanel.add(moneyThisMonthField);
        JLabel moneySpentOnFoodLabel = new JLabel("Hur mycket pengar spenderade du på mat denna månad?");
        topPanel.add(moneySpentOnFoodLabel);
        topPanel.add(moneySpentOnFoodField);
        JLabel moneySpentOnBillsLabel = new JLabel("Hur mycket pengar spenderade du på livsviktiga saker?");
        topPanel.add(moneySpentOnBillsLabel);
        topPanel.add(moneySpentOnBillsField);
        JLabel moneySpentOnJoyLabel = new JLabel("Hur mycket pengar spenderade du på njutbara saker?");
        topPanel.add(moneySpentOnJoyLabel);
        topPanel.add(moneySpentOnJoyField);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6,1));
        centerPanel.add(moneySpentThisMonth);
        centerPanel.add(totalMoneySpent);
        centerPanel.add(foodStatistics);
        centerPanel.add(billStatistics);
        centerPanel.add(joyStatistics);
        centerPanel.add(netWorthLabel);

        JPanel mainPanel = new JPanel();
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