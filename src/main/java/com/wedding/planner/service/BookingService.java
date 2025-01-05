package com.wedding.planner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.Booking;

public interface BookingService {

	/**
	 * Gets All the Bookings for vendor
	 *
	 * @return
	 */
	ResponseEntity<List<Booking>> getBookings(Optional<Long> user);

	/**
	 * Adds Booking
	 *
	 * @param bookingDto
	 * @return
	 */
	ResponseEntity<Booking> addBooking(Booking booking);

	/**
	 * Updates Booking
	 *
	 * @param bookingDto
	 * @return
	 */
	ResponseEntity<Booking> updatebooking(Booking booking);

	/**
	 * Deletes booking
	 *
	 * @param bookingId
	 * @return
	 */
	ResponseEntity<Boolean> deleteBooking(Long bookingId);

}
