public class balances {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        SavingsAccount.modifyInterestRate(0.04);
        saver1.setSavingsBalance(2000.0);
        saver2.setSavingsBalance(3000.0);

        System.out.println("4% annual interest rate per month:");
        System.out.println("     Saver 1   Saver 2");

        for (int i = 0; i < 12; i++) {
            System.out.print((i + 1) + ":  $");
            System.out.printf("%.2f", saver1.calculateMonthlyInterest());
            System.out.print("  $");
            System.out.printf("%.2f\n", saver2.calculateMonthlyInterest());
        }

        System.out.println();
        SavingsAccount.modifyInterestRate(0.05);
        saver1.setSavingsBalance(2000.0);
        saver2.setSavingsBalance(3000.0);

        System.out.println("5% annual interest rate for next month:");
        System.out.print("Saver 1: $");
        System.out.printf("%.2f", saver1.calculateMonthlyInterest());
        System.out.print("\nSaver 2: $");
        System.out.printf("%.2f", saver2.calculateMonthlyInterest());

    }
}
