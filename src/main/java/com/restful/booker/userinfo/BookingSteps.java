package com.restful.booker.userinfo;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.model.BookingDatesPojo;
import com.restful.booker.model.BookingPojoFinal;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class BookingSteps {
    static GetToken getToken = new GetToken();
    static String token = getToken.getToken();

    @Step("Get all bookings information")
    public ValidatableResponse getAllBooking() {
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_BOOKING)
                .then();
    }

    @Step("Create Booking")
    public ValidatableResponse createBooking(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkIn,
                                          String checkOut, String additionalNeed) {

        BookingPojoFinal bookingPojoFinal = new BookingPojoFinal();
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo();

        bookingDatesPojo.setCheckIn(checkIn);
        bookingDatesPojo.setCheckOut(checkOut);

        bookingPojoFinal.setFirstName(firstName);
        bookingPojoFinal.setLastName(lastName);
        bookingPojoFinal.setTotalPrice(totalPrice);
        bookingPojoFinal.setDepositPaid(depositPaid);
        bookingPojoFinal.setBookingDatesPojo(bookingDatesPojo);
        bookingPojoFinal.setAdditionalNeeds(additionalNeed);

        return  SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .when()
                .body(bookingPojoFinal)
                .post(EndPoints.CREATE_BOOKING)
                .then();
    }

    @Step("Verify Newly Create Booking")
    public ValidatableResponse VerifyBooking(int bookingId){
        System.out.println(bookingId);
        return  SerenityRest.given().log().all()
                //.header("Authorization","Bearer f4a966cfb8b1f8762386c84c483edfe3e4d73f9b92bd3e88426ca701e310525b")
                .pathParam("bookingID",bookingId)
                .when()
                .get(EndPoints.GET_BOOKING_BY_ID)
                .then();
    }

    @Step("Update Booking")
    public ValidatableResponse updateBooking(int bookingId, String firstName, String lastName, int totalPrice, boolean depositPaid, String checkIn,
                                             String checkOut, String additionalNeed){

        BookingPojoFinal bookingPojoFinal = new BookingPojoFinal();
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo();

        bookingDatesPojo.setCheckIn(checkIn);
        bookingDatesPojo.setCheckOut(checkOut);

        bookingPojoFinal.setFirstName(firstName);
        bookingPojoFinal.setLastName(lastName);
        bookingPojoFinal.setTotalPrice(totalPrice);
        bookingPojoFinal.setDepositPaid(depositPaid);
        bookingPojoFinal.setBookingDatesPojo(bookingDatesPojo);
        bookingPojoFinal.setAdditionalNeeds(additionalNeed);

        return  SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingID",bookingId)
                .when()
                .body(bookingPojoFinal)
                .put(EndPoints.UPDATE_BOOKING_BY_ID)
                .then();
   }

    @Step("Delete Booking")
    public ValidatableResponse deleteBooking(int bookingId){
        return  SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingID",bookingId)
                .when()
                .delete(EndPoints.DELETE_BOOKING_BY_ID)
                .then();
    }
}