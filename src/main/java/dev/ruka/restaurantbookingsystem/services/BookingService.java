package dev.ruka.restaurantbookingsystem.services;
import dev.ruka.restaurantbookingsystem.dto.BookingDto;
import dev.ruka.restaurantbookingsystem.dto.UpdateBookingDto;
import dev.ruka.restaurantbookingsystem.exceptions.BusinessException;
import dev.ruka.restaurantbookingsystem.model.Booking;
import dev.ruka.restaurantbookingsystem.model.Table;
import dev.ruka.restaurantbookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;
    @Autowired
    private TableService tableService;

    public Booking getBookingByReservante(String reservante){
        return repository.findByReservante(reservante);
    }

    public void createBooking(BookingDto booking){
        if(repository.existsByReservante(booking.getReservante())){
            throw new BusinessException("Só é possível fazer uma reserva por reservante");
        } else if(booking.getMesas().isEmpty()){
            throw new BusinessException("Uma reserva deve ter no mínimo uma mesa");
        } else {
            Booking toBeSaved = booking.toBooking();
            repository.save(toBeSaved);
            tableService.setBookingId(booking.getMesas(), repository.findByReservante(booking.getReservante()));
        }
    }

    public void deleteBookingByReservante(String reservante){
        Booking booking = repository.findByReservante(reservante);
        if(booking == null){
                throw new BusinessException("Esta reserva não existe");
        } else {
            repository.delete(booking);
        }
    }

    public List<Table> getBookingTablesByReservante(String reservante){
        Booking booking = getBookingByReservante(reservante);
        List<Table> mesas = tableService.repository.findByBookingId(booking);
        return mesas;
    }

    public boolean existsByReservante(String reservante){
        return repository.existsByReservante(reservante);
    }

    //UPDATE BOOKING
    public void updateBooking(UpdateBookingDto updateBooking, String reservante){
        //verifica se a reserva existe
        Booking toBeUpdated = getBookingByReservante(reservante);
        if(toBeUpdated == null){
            throw new BusinessException("Este booking não existe");
        }
        if(updateBooking.getNumPessoas() != null){
            toBeUpdated.setNumPessoas(updateBooking.getNumPessoas());
        }
        if(updateBooking.getData() != null){
            toBeUpdated.setData(updateBooking.getData());
        }
        if(updateBooking.getHora() != null){
            toBeUpdated.setHora(updateBooking.getHora());
        }

        repository.save(toBeUpdated);
    }
}
