package com.restful.booker.booker.testsuite;

import com.restful.booker.booker.testbase.TestBase;
import com.restful.booker.userinfo.BookingSteps;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class BookingCRUDTest extends TestBase {
    String firstName = "Abc" + TestUtils.getRandomValue();
    String lastName = "Xyz" + TestUtils.getRandomValue();
    int totalPrice = 500;
    boolean depositPaid = true;

    String checkIn = "2018-01-01";
    String checkOut = "2019-01-01";
    String additionalNeed = "No Needs";

    static int newBookingId;

    @Steps
    BookingSteps bookingSteps;

    @Title("Get all Booking Details")
    @Test
    public void test01() {
        ValidatableResponse response = bookingSteps.getAllBooking();
        response.log().all().statusCode(200);
    }

    @Title("Create New Booking")
    @Test
    public void test02() {
        ValidatableResponse response = bookingSteps.createBooking(firstName, lastName, totalPrice, depositPaid, checkIn, checkOut, additionalNeed);
        response.log().all().statusCode(200);
        newBookingId = response.extract().path("bookingid");
        System.out.println("NEWLY CREATED STORE ID IS:" + newBookingId);

    }

    @Title("Verify Newly Created Booking")
    @Test
    public void test03() {
        ValidatableResponse response = bookingSteps.VerifyBooking(newBookingId);
        response.log().all().statusCode(200);
    }

    @Title("Update Booking")
    @Test
    public void test04() {
        firstName = "Abc" + TestUtils.getRandomValue();
        lastName = "Xyz" + TestUtils.getRandomValue();
        ValidatableResponse response = bookingSteps.updateBooking(newBookingId, firstName, lastName, totalPrice, depositPaid, checkIn, checkOut, additionalNeed);
        response.log().all().statusCode(200);

    }

    @Title("Delete Booking")
    @Test
    public void test05() {
        ValidatableResponse response = bookingSteps.deleteBooking(newBookingId);
        response.log().all().statusCode(201);
    }
}
