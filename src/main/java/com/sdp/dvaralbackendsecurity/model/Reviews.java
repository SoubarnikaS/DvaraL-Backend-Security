package com.sdp.dvaralbackendsecurity.model;


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
