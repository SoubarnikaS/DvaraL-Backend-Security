package com.sdp.dvaralbackendsecurity.service;



import com.sdp.dvaralbackendsecurity.model.BookingDetails;
import com.sdp.dvaralbackendsecurity.model.Halls;
import com.sdp.dvaralbackendsecurity.model.User;
import com.sdp.dvaralbackendsecurity.repo.BookingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailsService {

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private HallService hallService;


    public BookingDetails addBookingDetails(BookingDetails bookingDetails, Long userID, Long hallID) {

        User userObj = userService.getUser(userID);
        Halls hallObj = hallService.getHallDetailsBYID(hallID).get();

        bookingDetails.setUsers(userObj);
        bookingDetails.setHalls(hallObj);

        return bookingDetailsRepository.save(bookingDetails);
    }

    public List<BookingDetails> getBookingDetailsForUser(Long userID) {

        return bookingDetailsRepository.findByUsers_Id(userID);
    }
}
