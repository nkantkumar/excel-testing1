package tdd;

import com.puretech.payment.Booking;
import com.puretech.payment.Hotel;
import com.puretech.payment.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

    private Hotel hotel;

    @BeforeEach
    void setUp() {
        hotel = new Hotel();
        hotel.addRoom(new Room(101, "Single"));
        hotel.addRoom(new Room(102, "Double"));
        hotel.addRoom(new Room(103, "Suite"));
    }

    @Test
    void testSuccessfulRoomBooking() {
        Booking booking = hotel.bookRoom("Single", "Alice", LocalDate.now(), LocalDate.now().plusDays(2));
        assertNotNull(booking);
        assertEquals(101, booking.getRoom().getRoomNumber());
        assertFalse(booking.getRoom().isAvailable());
    }

    @Test
    void testBookingWhenNoRoomAvailable() {
        // Book all rooms of type "Single"
        hotel.bookRoom("Single", "Bob", LocalDate.now(), LocalDate.now().plusDays(1));

        // Try to book another "Single" room (should be none left)
        Booking secondBooking = hotel.bookRoom("Single", "Charlie", LocalDate.now(), LocalDate.now().plusDays(1));
        assertNull(secondBooking);
    }

    @Test
    void testCancelBookingFreesUpRoom() {
        Booking booking = hotel.bookRoom("Suite", "Daisy", LocalDate.now(), LocalDate.now().plusDays(1));
        assertNotNull(booking);
        assertFalse(booking.getRoom().isAvailable());

        hotel.cancelBooking(booking);
        assertTrue(booking.getRoom().isAvailable());

        // Book again to confirm it's available
        Booking newBooking = hotel.bookRoom("Suite", "Eve", LocalDate.now(), LocalDate.now().plusDays(1));
        assertNotNull(newBooking);
    }
}
