package com.wedding.planner.api.v1.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.BookingDTO;
import com.wedding.planner.entity.Booking;

public interface ApiBookingService {

	/**
	 * Converts {@link Booking} to {@link BookingDTO}
	 *
	 * @param booking
	 * @return
	 */
	default BookingDTO convertToDTO(Booking booking) {
		return new BookingDTO(booking.getBookingId(), booking.getBookingPrice(),
				booking.getEventDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm")),
				booking.getBookedService().getServiceItemId().toString(), booking.getBookedBy().getUserId().toString());
	}

	/**
	 * Converts {@link List} of {@link Booking} to {@link List} of
	 * {@link BookingDTO}
	 *
	 * @param bookings
	 * @return
	 */
	default List<BookingDTO> convertToDTO(List<Booking> bookings) {
		return bookings.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Gets All the Bookings
	 *
	 * @return
	 */
	ResponseEntity<List<BookingDTO>> getBookings(Optional<Long> user);

	/**
	 * Adds Booking
	 *
	 * @param bookingDto
	 * @return
	 */
	ResponseEntity<BookingDTO> addBooking(BookingDTO bookingDto);

	/**
	 * Updates Booking
	 *
	 * @param bookingDto
	 * @return
	 */
	ResponseEntity<BookingDTO> updatebooking(BookingDTO bookingDto);

	/**
	 * Deletes booking
	 *
	 * @param bookingId
	 * @return
	 */
	ResponseEntity<Boolean> deleteBooking(Long bookingId);

}
