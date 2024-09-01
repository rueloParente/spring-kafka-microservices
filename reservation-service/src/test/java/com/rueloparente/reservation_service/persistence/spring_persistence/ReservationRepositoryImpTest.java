package com.rueloparente.reservation_service.persistence.spring_persistence;

import com.rueloparente.reservation_service.model.Reservation;
import com.rueloparente.reservation_service.model.ReservationBuilderGetter;
import com.rueloparente.reservation_service.model.ReservationBuilderGetterImp;
import com.rueloparente.reservation_service.persistence.mapper.ReservationDataModel2Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ReservationRepositoryImpTest {
    @Autowired
    private ReservationDBContext dbContext;
    private  ReservationBuilderGetter reservationBuilderGetter = new ReservationBuilderGetterImp();

    @Test
    void shouldSaveReservationToRepositoryWithNoReturnDate() {
        // Arrange
        Reservation reservation = Reservation.builder()
                .id(1)
                .bookID("1")
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .build();


        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        // Act
        Reservation savedReservation = reservationRepositoryImp.save(reservation);
        // Assert
        assertEquals(reservation, savedReservation);
    }
    @Test
    void shouldSaveReservationToRepositoryWithReturnDate(){
        // Arrange
        Reservation reservation = Reservation.builder()
                .id(1)
                .bookID("1")
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        // Act
        Reservation savedReservation = reservationRepositoryImp.save(reservation);
        // Assert
        assertEquals(reservation, savedReservation);
    }

    @Test
    void shouldReturnReservationFromRepositoryIfPresent(){
        // Arrange
        int reservationID = 1;
        Reservation reservation = Reservation.builder()
                .id(reservationID)
                .bookID("1")
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();


        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation);
        // Act
        Optional<Reservation> retrievedReservation = reservationRepositoryImp.findByID(reservationID);

        // Assert
        assertTrue(retrievedReservation.isPresent());
        assertEquals(reservation, retrievedReservation.get());
    }

    @Test
    void shouldReturnOptionalEmptyIfReservationNotFound(){
        // Arrange
        Reservation reservation = Reservation.builder()
                .id(1)
                .bookID("1")
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        int nonExistentID = 2;

        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation);
        // Act
        Optional<Reservation> retrievedReservation = reservationRepositoryImp.findByID(nonExistentID);

        // Assert
        assertTrue(retrievedReservation.isEmpty());
    }
    @Test
    void shouldReturnReservationWithoutReturnDateFromRepository(){
        // Arrange
        int reservationID = 1;
        Reservation reservation = Reservation.builder()
                .id(reservationID)
                .bookID("1")
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .build();


        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation);
        // Act
        Optional<Reservation> retrievedReservation = reservationRepositoryImp.findByID(reservationID);

        // Assert
        assertTrue(retrievedReservation.isPresent());
        assertEquals(reservation, retrievedReservation.get());
    }
    @Test
    void shouldThrowExceptionIfSavingSameBookID(){
        // Arrange
        String repeatedBookID = "1";
        Reservation reservation = Reservation.builder()
                .id(1)
                .bookID(repeatedBookID)
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        Reservation reservationWithRepeatedBookID = Reservation.builder()
                .id(2)
                .bookID(repeatedBookID)
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation);
        // Act
        // Assert
        assertThrows(Exception.class, () -> reservationRepositoryImp.save(reservationWithRepeatedBookID));
    }

    @Test
    void shouldDeleteReservationFromRepositoryIfPresent() {
        // Arrange
        int reservationID = 1;
        Reservation reservation = Reservation.builder()
                .id(reservationID)
                .bookID("1")
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation);
        // Act
        boolean isDeleted = reservationRepositoryImp.delete(reservationID);
        // Assert
        assertTrue(isDeleted);
    }

    @Test
    void shouldReturnFalseIfReservationToDeleteNotFound(){
        // Arrange
        int reservationID = 1;
        Reservation reservation = Reservation.builder()
                .id(reservationID)
                .bookID("1")
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        int nonExistentID = 2;

        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation);
        // Act
        boolean isDeleted = reservationRepositoryImp.delete(nonExistentID);
        // Assert
        assertFalse(isDeleted);
    }

    @Test
    void shouldReturnReservationWhenSearchingByBookID(){
        // Arrange
        String bookID = "1";
        Reservation reservation = Reservation.builder()
                .id(1)
                .bookID(bookID)
                .clientID("1")
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation);
        // Act
        Optional<Reservation> retrievedReservation = reservationRepositoryImp.findByBookID(bookID);
        // Assert
        assertEquals(reservation, retrievedReservation.get());
    }
    @Test
    void shouldReturnOptionalEmptyWhenNoReservationCorrespondingToBookID() {
        // Arrange
        String bookID = "1";
        Reservation reservation = Reservation.builder()
                .id(2)
                .bookID(bookID)
                .clientID("2")
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        String nonExistentBookID = "2";

        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation);
        // Act
        Optional<Reservation> retrievedReservation = reservationRepositoryImp.findByBookID(nonExistentBookID);
        // Assert
        assertTrue(retrievedReservation.isEmpty());
    }

    @Test
    void shouldReturnReservationListWhenSearchingByClientID(){
        // Arrange
        String clientID = "1";
        Reservation reservation1 = Reservation.builder()
                .id(1)
                .bookID("1")
                .clientID(clientID)
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        Reservation reservation2 = Reservation.builder()
                .id(2)
                .bookID("2")
                .clientID(clientID)
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        List<Reservation> expectedReservations = List.of(reservation1, reservation2);

        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation1);
        reservationRepositoryImp.save(reservation2);
        // Act
        List<Reservation> retrievedReservations = reservationRepositoryImp.findByClientID(clientID);
        // Assert
        assertEquals(expectedReservations, retrievedReservations);
    }

    @Test
    void shouldReturnEmptyListWhenNoReservationCorrespondingToClientID(){
        // Arrange
        String clientID = "1";
        Reservation reservation1 = Reservation.builder()
                .id(1)
                .bookID("1")
                .clientID(clientID)
                .reservationDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build();

        String nonExistentClientID = "2";

        ReservationDataModel2Reservation dataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        ReservationRepositoryImp reservationRepositoryImp = new ReservationRepositoryImp(dbContext, dataModel2Reservation);
        reservationRepositoryImp.save(reservation1);
        // Act
        List<Reservation> retrievedReservations = reservationRepositoryImp.findByClientID(nonExistentClientID);
        // Assert
        assertTrue(retrievedReservations.isEmpty());
    }

}