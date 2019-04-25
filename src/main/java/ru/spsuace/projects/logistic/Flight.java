package ru.spsuace.projects.logistic;


public class Flight { //рейс

    private final float salary; //стоимость рейса
    private final float payment; //оплата рейса
    private final Direction direction; //путь
    private final int flightDuration = 1; // продолжительность рейса
    private final int expenses; // затраты ресурсов
    private Machine machine;

    public Flight(float salary, float payment, Direction direction, int expenses, Machine machine) {
        this.salary = salary;
        this.payment = payment;
        this.direction = direction;
        this.expenses = expenses;
        this.machine = machine;
    }

    public float getSalary() {
        return salary;
    }

    public Machine getMachine() {
        return machine;
    }

    public int getExpenses() {
        return expenses;
    }

    public float getPayment() {
        return payment;
    }

    public void setExpenses(){

    }
}

