package ru.spsuace.projects.bank;

import java.util.Calendar;

public class Deposit {

    private double depositAmount;
    private double percent;
    private int period;
    private Calendar startDate;
    private Calendar endDate;
    private double depositBalance;

    public Deposit(double depositAmount, int period, Calendar startDate) {

        this.depositAmount = depositAmount;

        if (this.depositAmount < 500000) {
            this.percent = 5;
        } else if (this.depositAmount < 1000000) {
            this.percent = 7.5;
        } else {
            this.percent = 10;
        }

        this.period = period;
        this.startDate = startDate;
        this.endDate = startDate;
        endDate.roll(Calendar.MONTH, period);
        this.depositBalance = depositAmount * (this.percent * 0.01);

    }

    public double closeDeposit(Calendar closeDate) {

        if (closeDate.before(endDate)) {
            return 0;
        } else {
            return depositBalance;
        }
    }

    public double potentialDeposit() {
        return depositBalance;
    }

    public double depositIncome() {
        return depositBalance - depositAmount;
    }

}
