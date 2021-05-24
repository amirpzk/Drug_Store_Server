package com.Prana.Latifi.repository;

import com.Prana.Latifi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    List<Item> findAllBySpecialOfferAndAmountGreaterThan(Boolean specialOffer, Long amountInShop);

    List<Item> findByOrderBySoldAmountDesc();


}
