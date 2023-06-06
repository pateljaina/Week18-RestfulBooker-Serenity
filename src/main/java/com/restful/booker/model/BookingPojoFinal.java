package com.restful.booker.model;

public class BookingPojoFinal {

    private String firstName;
    private String lastName;
    private Integer totalPrice;
    private Boolean depositPaid;
    private BookingDatesPojo bookingDatesPojo;
    private String additionalNeeds;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(Boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public BookingDatesPojo getBookingDatesPojo() {
        return bookingDatesPojo;
    }

    public void setBookingDatesPojo(BookingDatesPojo bookingDatesPojo) {
        this.bookingDatesPojo = bookingDatesPojo;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }
}



