package ru.spsuace.projects.hotels;

public class HotelNumber {

    private int places;
    private boolean isFree;
    private Date orderTill;
    private boolean breakfast;
    private int breakfastPrice;
    private int price;

    public HotelNumber(int places, int breakfastPrice, boolean breakfast) {
        this.places = places;
        this.breakfastPrice = breakfastPrice;
        this.breakfast = breakfast;
        this.isFree = true;
    }

    public int getPlaces() {
        return places;
    }

    public boolean getBreakfast() {
        return breakfast;
    }

    public int getPrice() {
        return price;
    }

    public Date getOrderTill() {
        return orderTill;
    }

    public int booking(int places, Date orderTill) {
        if (places > this.places) {
            return 0;
        }

        isFree = false;
        this.places -= places;
        this.orderTill = orderTill;
        this.price = countPrice(this.places, this.breakfast);
        return  this.price;
    }

    private int countPrice(int placeAmount, boolean breakfast) {
        if (breakfast) {
            return placeAmount * 3000 + breakfastPrice;
        }
        return placeAmount * 3000;
    }
}