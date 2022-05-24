package com.example.demo.dto;

import com.example.demo.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
public class BookingDTO {

    private String bookingStatus;

    private String amount;

    private String pickupLocation;

    private String dropLocation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDateTime;


    public static BookingDTO fromBooking(Booking booking) {
        return new BookingDTO(
                booking.getBookingStatus(),
                booking.getAmount()+"",
                booking.getPickupLocation(),
                booking.getDropLocation(),
                booking.getStartDateTime(),
                booking.getEndDateTime()
        );
    }
}
