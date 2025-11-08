package com.example.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public BookingEntity createBooking(BookingEntity booking) {
        // ensure user and service exist (if ids provided)
        if (booking.getUser() != null && booking.getUser().getId() != null) {
            Long uid = booking.getUser().getId();
            userRepository.findById(uid).ifPresent(booking::setUser);
        }
        if (booking.getService() != null && booking.getService().getId() != null) {
            Long sid = booking.getService().getId();
            serviceRepository.findById(sid).ifPresent(booking::setService);
        }
        return bookingRepository.save(booking);
    }

    public BookingEntity getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<BookingEntity> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    public BookingEntity updateBooking(Long id, BookingEntity updated) {
        Optional<BookingEntity> existingOpt = bookingRepository.findById(id);
        if (existingOpt.isPresent()) {
            BookingEntity existing = existingOpt.get();
            // update allowed fields
            existing.setFullName(updated.getFullName());
            existing.setEmail(updated.getEmail());
            existing.setPhone(updated.getPhone());
            existing.setAddress(updated.getAddress());
            existing.setCity(updated.getCity());
            existing.setZipCode(updated.getZipCode());
            existing.setScheduledDate(updated.getScheduledDate());
            existing.setScheduledTime(updated.getScheduledTime());
            existing.setStatus(updated.getStatus());
            // optionally update service/user reference if provided
            if (updated.getService() != null && updated.getService().getId() != null) {
                serviceRepository.findById(updated.getService().getId()).ifPresent(existing::setService);
            }
            if (updated.getUser() != null && updated.getUser().getId() != null) {
                userRepository.findById(updated.getUser().getId()).ifPresent(existing::setUser);
            }
            return bookingRepository.save(existing);
        }
        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
