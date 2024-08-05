package com.sdp.dvaralbackendsecurity.controller;



import com.sdp.dvaralbackendsecurity.model.BookingDetails;
import com.sdp.dvaralbackendsecurity.service.BookingDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hall")
@Slf4j
public class BookingDetailsController {

    @Autowired
    private BookingDetailsService bookingDetailsService;


    @PostMapping("/add/booking-details/{userID}/{hallID}")
    public ResponseEntity<?> addBookingDetails(@RequestBody BookingDetails bookingDetails, @PathVariable Long userID, @PathVariable Long hallID) {

        try{

            BookingDetails bookedHalls = bookingDetailsService.addBookingDetails(bookingDetails, userID, hallID);
            return new ResponseEntity<>(bookedHalls, HttpStatus.CREATED);

        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/fetch/booking-details/{userID}")
    public ResponseEntity<?> fetchBookingDetails(@PathVariable Long userID) {
        try{

            List<BookingDetails> bookedHallsForUser = bookingDetailsService.getBookingDetailsForUser(userID);
            return new ResponseEntity<>(bookedHallsForUser, HttpStatus.OK);

        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
