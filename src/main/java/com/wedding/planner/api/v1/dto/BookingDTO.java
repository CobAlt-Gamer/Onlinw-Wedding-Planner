package com.wedding.planner.api.v1.dto;

public record BookingDTO(Long bookingId, Double bookingPrice, String eventDate, String bookedService, String bookedBy) {

}
