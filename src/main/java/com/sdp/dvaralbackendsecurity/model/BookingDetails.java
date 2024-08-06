package com.sdp.dvaralbackendsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingID;
    private LocalDateTime bookingDateTime;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String requestedDate;
    private String requestedTime;
    private int noOfGuest;
    private String eventType;
    private String specialRequests;
    private String bookingStatus;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User users;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    @JsonManagedReference
    private Halls halls;
}
