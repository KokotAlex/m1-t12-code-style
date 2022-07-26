import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getRound(pay,2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRound(amount + amount * yearRate * depositPeriod,2);
    }

    double getRound(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateDeposit() {
        int period;
        int action;
        int amount;

        Scanner sumOfDeposit = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = sumOfDeposit.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = sumOfDeposit.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = sumOfDeposit.nextInt();

        double sumOfDepositInFuture = 0;
        if (action == 1) {
            sumOfDepositInFuture = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            sumOfDepositInFuture = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в "
                + sumOfDepositInFuture);
    }

    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.calculateDeposit();
    }
}