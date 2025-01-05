package com.wedding.planner.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.Booking;
import com.wedding.planner.repository.BookingRepository;
import com.wedding.planner.service.BookingService;
import com.wedding.planner.service.UserService;
import com.wedding.planner.utils.UtilityService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private UtilityService utility;

	@Override
	public ResponseEntity<List<Booking>> getBookings(Optional<Long> userId) {

		List<Booking> bookings = bookingRepo.findAll().stream()
				.filter(booking -> booking.getBookedService().getService().getCreatedBy().getUser().getUserId()
						.equals(userId.isPresent() ? userId.get()
								: userService.getUser(utility.getCurrentUsername()).getBody().getUserId()))
				.collect(Collectors.toUnmodifiableList());
		return ResponseEntity.ok(bookings);
	}

	@Override
	public ResponseEntity<Booking> addBooking(Booking booking) {
		return ResponseEntity.ok(bookingRepo.save(booking));
	}

	@Override
	public ResponseEntity<Booking> updatebooking(Booking booking) {
		Optional<Booking> dbBooking = bookingRepo.findById(booking.getBookingId());
		if (dbBooking.isPresent()) {
			if (Objects.nonNull(booking.getEventDate())) {
				dbBooking.get().setEventDate(booking.getEventDate());
			}
			if (Objects.nonNull(booking.getBookingPrice())) {
				dbBooking.get().setBookingPrice(booking.getBookingPrice());
			}
			return ResponseEntity.ok(bookingRepo.save(dbBooking.get()));
		}
		return ResponseEntity.internalServerError().build();
	}

	@Override
	public ResponseEntity<Boolean> deleteBooking(Long bookingId) {
		try {
			bookingRepo.deleteById(bookingId);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}

}
