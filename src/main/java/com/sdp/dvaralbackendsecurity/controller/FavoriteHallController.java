package com.sdp.dvaralbackendsecurity.controller;


import com.sdp.dvaralbackendsecurity.model.FavoriteHalls;
import com.sdp.dvaralbackendsecurity.service.FavouriteHallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/halls")
@Slf4j
public class FavoriteHallController {

    @Autowired
    private FavouriteHallService favouriteHallService;


    @PostMapping("/add-to-fav/{hallID}/{userID}")
    public ResponseEntity<?> addHallToFav(@PathVariable Long hallID, @PathVariable Long userID) {

        try{

            FavoriteHalls favHalls = favouriteHallService.addHallToFav(userID, hallID);
            return new ResponseEntity<>(favHalls, HttpStatus.OK);

        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-favourite/{userID}")
    public ResponseEntity<?> getFavourite(@PathVariable Long userID) {
        try{

            List<FavoriteHalls> favHallList = favouriteHallService.getFavouriteForUser(userID);
            return new ResponseEntity<>(favHallList, HttpStatus.OK);
        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("/remove-favourites")
    public ResponseEntity<?> removeFavourite(@RequestBody FavoriteHalls favoriteHalls) {
        try{

            favouriteHallService.deleteFavorite(favoriteHalls);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
