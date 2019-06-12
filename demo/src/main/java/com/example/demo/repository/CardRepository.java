package com.example.demo.repository;

import com.example.demo.entity.ScratchCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * Anita
 * 6/12/2019
 */
public interface CardRepository  extends CrudRepository<ScratchCard, Long> {

   // @Query("select c from card_master c where c.serial_no like %?1")default
   // ScratchCard findByNameEndsWith(String serialNo) {
     //   return findByNameEndsWith(serialNo);
   // }

   /* @Query("select c from card_master c where c.serial_no like %?1")
   ScratchCard findByNameEndsWith(String chars);*/
}
