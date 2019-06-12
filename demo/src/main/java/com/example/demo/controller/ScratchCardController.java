package com.example.demo.controller;

/**
 * Anita
 * 6/12/2019
 */

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.example.demo.entity.Employee;
import com.example.demo.entity.ScratchCard;
import com.example.demo.repository.CardRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@RestController
@RequestMapping("/card")
public class ScratchCardController {

    @Autowired
    CardRepository cardRepository;

    // insert new card into database
    @PostMapping("/addCard")
    public ScratchCard addCard(@RequestBody ScratchCard card) {
        //Generate VoucherNumber
        card.setVoucherNumber(generateVoucherNumber());
        card.setExpiryDate("12/12/2019");
        card.setDateCreated(new java.sql.Timestamp(new java.util.Date()
                .getTime()));
        card.setDateUpdated(new java.sql.Timestamp(new java.util.Date()
                .getTime()));
        return cardRepository.save(card);
    }

    @GetMapping ("/getCard")
    public Iterable<ScratchCard> getAllCards(EntityManager em) {


        Query q = em.createNativeQuery("SELECT * FROM  card_master", ScratchCard.class);
        List<ScratchCard> cards = q.getResultList();
        return cards;
    }

    // fetch specific country by their ID
   /* @GetMapping("/{serialNo}")
    public ScratchCard countryById(@PathVariable("serialNo") String serialNo) {

        return  cardRepository.findByNameEndsWith(serialNo);
    }*/
    public String generateVoucherNumber(){
        Random random = new Random();
        String voucherNumber = "Saf"+String.format("%04d", random.nextInt(10000));
        return voucherNumber;
    }


}
