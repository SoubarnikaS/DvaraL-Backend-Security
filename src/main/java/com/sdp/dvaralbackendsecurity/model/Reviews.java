package com.sdp.dvaralbackendsecurity.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewID;
    private String hallName;
    private String reviewContent;
    private LocalDateTime reviewDate;
    private int rating;

    @ManyToOne
    private User users;
}
