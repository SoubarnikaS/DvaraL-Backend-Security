package com.sdp.dvaralbackendsecurity.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FavoriteHallsIdClass.class)
public class FavoriteHalls {

    @ManyToOne
    @Id
//    @JsonManagedReference("favoriteUserReference")
    private User users;


    @ManyToOne
    @Id
//    @JsonManagedReference("favoriteHallReference")
    private Halls hall;
}
