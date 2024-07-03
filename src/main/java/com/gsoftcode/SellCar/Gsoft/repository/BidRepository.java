package com.gsoftcode.SellCar.Gsoft.repository;

import com.gsoftcode.SellCar.Gsoft.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
}
