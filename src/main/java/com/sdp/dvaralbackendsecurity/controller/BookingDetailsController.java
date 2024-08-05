package com.sdp.dvaralbackendsecurity.controller;



import com.sdp.dvaralbackendsecurity.dto.StatusDto;
import com.sdp.dvaralbackendsecurity.model.BookingDetails;
import com.sdp.dvaralbackendsecurity.service.BookingDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/hall")
@Slf4j
public class BookingDetailsController {

    @Autowired
    private BookingDetailsService bookingDetailsService;


    @PostMapping("/add/booking-details/{userID}/{hallID}")
    public ResponseEntity<?> addBookingDetails(@RequestBody BookingDetails bookingDetails, @PathVariable Long userID, @PathVariable Long hallID) {

        try{

            BookingDetails bookedHalls = bookingDetailsService.addBookingDetails(bookingDetails, userID, hallID);
            return new ResponseEntity<>("Hall : " + hallID + " booked successfully", HttpStatus.CREATED);

        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getby/{bookingID}")
    public ResponseEntity<?> getBookingDetails(@PathVariable Long bookingID) {

        Optional<BookingDetails> bookingDetailsList = bookingDetailsService.getAllBookingDetailsFor(bookingID);
        return new ResponseEntity<>(bookingDetailsList, HttpStatus.OK);
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

    @GetMapping("/fetch/booked-details/{status}")
    public ResponseEntity<?> fetchApprovedBookingDetails(@PathVariable String status) {

        try{

            List<BookingDetails> bookedDetails = bookingDetailsService.getBookedDetails(status);
            return new ResponseEntity<>(bookedDetails, HttpStatus.OK);
        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping("/update-status/{hallID}")
    public ResponseEntity<?> updateHallStatus(@PathVariable Long hallID, @RequestBody StatusDto hallStatus) {

        try{

            Boolean response = bookingDetailsService.updateHallStatus(hallID, hallStatus);

            if(response)
                return new ResponseEntity<>("Hall : " + hallID + " updated successfully to status - " + hallStatus.getBookingStatus(), HttpStatus.OK);
            else
                return new ResponseEntity<>("Hall not found", HttpStatus.NOT_FOUND);

        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
