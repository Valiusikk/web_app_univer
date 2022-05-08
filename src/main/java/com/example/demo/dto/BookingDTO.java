package com.example.demo.dto;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Client;
import com.example.demo.entity.Discount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private String bookingStatus;

    private float amount;

    private String pickupLocation;

    private String dropLocation;

    private CarDTO car;

    @JoinColumn(name = "client_id")
    @ManyToOne(targetEntity = Client.class)
    private Client client;

    private Set<Discount> discounts;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private InsuranceDTO insurance;

    public static BookingDTO fromBooking(Booking booking) {
        return new BookingDTO(
                booking.getBookingStatus(),
                booking.getAmount(),
                booking.getPickupLocation(),
                booking.getDropLocation(),
                CarDTO.fromCar(booking.getCar()),
                booking.getClient(),
                booking.getDiscounts(),
                booking.getStartDateTime(),
                booking.getEndDateTime(),
                InsuranceDTO.fromInsurance(booking.getInsurance())
        );
    }
}
