package dao;

import Models.Guest;

public interface GuestDAO {

    void addGuest(Guest guest);

    Guest getGuestById(int guestId);

}
