package ru.spsuace.projects.bank;

import java.util.Calendar;

public class Credit {

    private double creditAmount;
    private double percent;
    private int period;
    private int payPeriod;
    private Calendar startDate;
    private Calendar endDate;
    private Calendar nextDateOfPay;
    private double peni;
    private double monthPay;
    private double creditBalance;

    public Credit(double creditAmount, double percent, int period, int payPeriod, Calendar startDate) {

        this.creditAmount = creditAmount;
        this.percent = percent;
        this.period = period;
        this.payPeriod = payPeriod;
        this.startDate = startDate;
        this.endDate = startDate;
        this.nextDateOfPay = startDate;
        endDate.roll(Calendar.MONTH, period);
        nextDateOfPay.roll(Calendar.MONTH, payPeriod);
        this.peni = 0;
        this.creditBalance = this.creditAmount * (this.percent * 0.01);
        this.monthPay = this.creditBalance / (this.period / this.payPeriod);

    }

    public double payCredit(double payAmount, Calendar payDate) {

        if (payDate.after(nextDateOfPay)) {
            peni += monthPay * (percent * 0.01);
        }

        if (creditBalance < payAmount) {

            double rest = payAmount - creditBalance;
            creditBalance = 0;
            if (peni > rest) {
                peni -= rest;
                return peni;
            } else {
                peni = 0;
                return 0;
            }

        } else {

            creditBalance -= payAmount;
            return creditBalance;
        }
    }

    public double potentialCredit() {
        return creditAmount * (percent * 0.01);
    }

    public double creditIncome() {
        return creditAmount * (percent * 0.01) - creditAmount;
    }

}
