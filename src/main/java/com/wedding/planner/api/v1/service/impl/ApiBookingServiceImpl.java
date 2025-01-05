package com.wedding.planner.api.v1.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.BookingDTO;
import com.wedding.planner.api.v1.service.ApiBookingService;
import com.wedding.planner.entity.Booking;
import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.repository.BookingRepository;
import com.wedding.planner.service.UserService;
import com.wedding.planner.utils.UtilityService;

@Service
public class ApiBookingServiceImpl implements ApiBookingService {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private UtilityService utility;

	@Override
	public ResponseEntity<List<BookingDTO>> getBookings(Optional<Long> user) {
		return ResponseEntity.ok(convertToDTO(
				bookingRepo.findByBookedBy(user.isEmpty() ? userService.getUser(utility.getCurrentUsername()).getBody()
						: userService.getUser(user.get()).getBody())));
	}

	@Override
	public ResponseEntity<BookingDTO> addBooking(BookingDTO bookingDto) {
		Booking booking = Booking.builder()
				.eventDate(LocalDateTime.parse(bookingDto.eventDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm")))
				.bookedBy(userService.getUser(utility.getCurrentUsername()).getBody())
				.bookedService(ServiceItem.builder().serviceItemId(Long.parseLong(bookingDto.bookedService())).build())
				.bookingPrice(bookingDto.bookingPrice()).build();

		return ResponseEntity.ok(convertToDTO(bookingRepo.save(booking)));
	}

	@Override
	public ResponseEntity<BookingDTO> updatebooking(BookingDTO bookingDto) {
		Optional<Booking> dbBooking = bookingRepo.findById(bookingDto.bookingId());
		if (dbBooking.isPresent()) {
			if (Objects.nonNull(bookingDto.eventDate()) && !"".equalsIgnoreCase(bookingDto.eventDate())) {
				dbBooking.get().setEventDate(
						LocalDateTime.parse(bookingDto.eventDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm")));
			}
			if (Objects.nonNull(bookingDto.bookingPrice())) {
				dbBooking.get().setBookingPrice(bookingDto.bookingPrice());
			}

			return ResponseEntity.ok(convertToDTO(bookingRepo.save(dbBooking.get())));
		}

		return ResponseEntity.notFound().build();
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
