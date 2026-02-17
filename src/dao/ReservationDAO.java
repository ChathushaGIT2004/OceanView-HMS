package dao;

import Models.Reservation;

public interface ReservationDAO {

    void addReservation(Reservation reservation);

    Reservation getReservation(int reservationId);
}
