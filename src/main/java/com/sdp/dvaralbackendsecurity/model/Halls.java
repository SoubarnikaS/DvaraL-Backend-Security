package com.sdp.dvaralbackendsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Halls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallID;
    private String hallOwner;
    private String hallName;
    private String hallType;
    private String hallLocation;
    @Column(length = 5667879)
    private String hallDescription;
    private String hallStatus;
    private Float hallRating;
    private String hallAddress;
    private String hallContact;
    private int capacity;
    private double hallPrice;


    @ElementCollection
    private List<String> hallAmenitiesList;


    @JsonIgnore
    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonBackReference
    private List<FavoriteHalls> favoriteHalls;


    @ManyToOne
    private User users;


    @JsonIgnore
    @OneToMany(mappedBy = "halls", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookingDetails> bookingDetailsList;



}
