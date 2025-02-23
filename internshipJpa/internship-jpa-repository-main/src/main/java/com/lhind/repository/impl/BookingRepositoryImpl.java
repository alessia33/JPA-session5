package com.lhind.repository.impl;

import com.lhind.configuration.EntityManagerConfiguration;
import com.lhind.model.entity.Booking;
import com.lhind.model.entity.EmployeeDetails;
import com.lhind.repository.BookingRepository;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BookingRepositoryImpl implements BookingRepository {

    private final EntityManager entityManager;

    public BookingRepositoryImpl() {
        entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<Booking> findById(Long aLong) {
        return Optional.ofNullable(entityManager.find(Booking.class, aLong));
    }

    public List<Booking> findByEmployeeLastName(String lastName) {
        List<Booking> bookings = entityManager.createQuery("SELECT b FROM Booking b inner join Employee e on b.id = e.id WHERE e.lastName = :lname", Booking.class)
                .setParameter("lname", lastName)
                .getResultList();
        return bookings;
    }

    @Override
    public List<Booking> findAll() {
        return null;
    }

    public List<EmployeeDetails> findFromNativeQuery(String cost) {
        List<EmployeeDetails> details = entityManager.createNativeQuery("SELECT * FROM Employee_Details as b where b.phone_Number = :number", Booking.class)
                .setParameter("number", "1234")
                .getResultList();
        return details;
    }

    @Override
    public void save(Booking booking) {
        entityManager.getTransaction().begin();
        if (booking.getId() != null) {
            findById(Long.valueOf(booking.getId())).ifPresent(existingBooking -> {
                booking.setCost(booking.getCost());
                booking.setBookingNumber(booking.getBookingNumber());
                booking.setBookingStatus(booking.getBookingStatus());
                booking.setBookingStartDate(booking.getBookingStartDate());
                booking.setBookingEndDate(booking.getBookingEndDate());
            });
        } else {
            entityManager.persist(booking);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Booking booking) {
    }
}
