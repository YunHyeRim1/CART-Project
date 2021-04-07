package org.yunhyerim.api.booking.service;

import java.util.List;

import org.yunhyerim.api.booking.domain.Booking;

public interface BookingService {
	public long update(String bookName, String bookEmail, String bookPnumber, long bookNum);
}
