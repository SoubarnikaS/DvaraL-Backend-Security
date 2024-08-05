package com.sdp.dvaralbackendsecurity.model;

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
    private User users;

    @ManyToOne
    @Id
    private Halls hall;
}
