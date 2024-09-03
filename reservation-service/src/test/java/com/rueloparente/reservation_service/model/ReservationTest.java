package com.rueloparente.reservation_service.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
    @Test
    void builderShouldCreateExpectedObject() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        String expected = "Reservation(id=1, bookID=bookID, reservationDate=2021-08-01T00:00, returnDate=2021-08-02T00:00, clientID=clientID)";
        //Act
        Reservation reservation = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        //Assert
        assertEquals(expected, reservation.toString());
    }

    @Test
    void builderShouldCreateExpectedObjectWithoutReturnDate() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String clientID = "clientID";

        String expected = "Reservation(id=1, bookID=bookID, reservationDate=2021-08-01T00:00, returnDate=null, clientID=clientID)";
        //Act
        Reservation reservation = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .clientID(clientID)
                .build();
        //Assert
        assertEquals(expected, reservation.toString());
    }


    @Test
    void builderShouldThrowExceptionWhenBookIDIsNull() {
        //Arrange
        Integer id = 1;
        String bookID = null;
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        //Act & Assert
        assertThrows(NullPointerException.class, () -> Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build());
    }

    @Test
    void builderShouldThrowExceptionWhenReservationDateIsNull() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = null;
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        //Act & Assert
        assertThrows(NullPointerException.class, () -> Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build());
    }

    @Test
    void builderShouldThrowExceptionWhenClientIDIsNull() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = null;

        //Act & Assert
        assertThrows(NullPointerException.class, () -> Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build());
    }

    @Test
    void equalsShouldReturnTrueWhenObjectsAreEqual() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        Reservation reservation1 = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        Reservation reservation2 = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        //Act
        boolean result = reservation1.equals(reservation2);
        //Assert
        assertTrue(result);
    }

    @Test
    void equalsShouldReturnFalseWhenObjectsAreNotEqual() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        Reservation reservation1 = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        Reservation reservation2 = Reservation.builder()
                .id(2)
                .bookID("bookID2")
                .reservationDate(java.time.LocalDateTime.parse("2021-08-02T00:00:00"))
                .returnDate(java.time.LocalDateTime.parse("2021-08-03T00:00:00"))
                .clientID("clientID2")
                .build();
        //Act
        boolean result = reservation1.equals(reservation2);
        //Assert
        assertFalse(result);
    }

    @Test
    void hashCodeShouldReturnSameValueWhenObjectsAreEqual() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        Reservation reservation1 = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        Reservation reservation2 = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        //Act
        int hashCode1 = reservation1.hashCode();
        int hashCode2 = reservation2.hashCode();
        //Assert
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void hashCodeShouldReturnDifferentValueWhenObjectsAreNotEqual() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        Reservation reservation1 = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        Reservation reservation2 = Reservation.builder()
                .id(2)
                .bookID("bookID2")
                .reservationDate(java.time.LocalDateTime.parse("2021-08-02T00:00:00"))
                .returnDate(java.time.LocalDateTime.parse("2021-08-03T00:00:00"))
                .clientID("clientID2")
                .build();
        //Act
        int hashCode1 = reservation1.hashCode();
        int hashCode2 = reservation2.hashCode();
        //Assert
        assertNotEquals(hashCode1, hashCode2);
    }

    void getIDShouldReturnExpectedValue() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        Reservation reservation = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        //Act
        Integer result = reservation.getId();
        //Assert
        assertEquals(id, result);
    }

    @Test
    void getBookIDShouldReturnExpectedValue() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        Reservation reservation = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        //Act
        String result = reservation.getBookID();
        //Assert
        assertEquals(bookID, result);
    }

    @Test

    void getReservationDateShouldReturnExpectedValue() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        LocalDateTime expected = LocalDateTime.parse(reservationDate);

        Reservation reservation = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        //Act
        LocalDateTime result = reservation.getReservationDate();
        //Assert
        assertEquals(expected, result);
    }

    @Test
    void getReturnDateShouldReturnExpectedValue() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        LocalDateTime expected = LocalDateTime.parse(returnDate);

        Reservation reservation = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        //Act
        LocalDateTime result = reservation.getReturnDate();
        //Assert
        assertEquals(expected, result);
    }

    @Test
    void getClientIDShouldReturnExpectedValue() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        Reservation reservation = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .returnDate(java.time.LocalDateTime.parse(returnDate))
                .clientID(clientID)
                .build();
        //Act
        String result = reservation.getClientID();
        //Assert
        assertEquals(clientID, result);
    }

    @Test
    void setReturnDateShouldSetReturnDate() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-02T00:00:00";
        String clientID = "clientID";

        LocalDateTime expected = LocalDateTime.parse(returnDate);

        Reservation reservation = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .clientID(clientID)
                .build();
        //Act
        reservation.setReturnDate(java.time.LocalDateTime.parse(returnDate));
        //Assert
        assertEquals(expected, reservation.getReturnDate());
    }

    @Test
    void shouldReturnNullWhenReturnDateIsNotSet() {
        //Arrange
        Integer id = 1;
        String bookID = "bookID";
        String reservationDate = "2021-08-01T00:00:00";
        String clientID = "clientID";

        Reservation reservation = Reservation.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(java.time.LocalDateTime.parse(reservationDate))
                .clientID(clientID)
                .build();
        //Act
        LocalDateTime result = reservation.getReturnDate();
        //Assert
        assertNull(result);
    }
}