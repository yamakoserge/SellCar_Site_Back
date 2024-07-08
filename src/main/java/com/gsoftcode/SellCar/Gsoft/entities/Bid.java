package com.gsoftcode.SellCar.Gsoft.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gsoftcode.SellCar.Gsoft.dtos.BidDTO;
import com.gsoftcode.SellCar.Gsoft.enums.BidStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Car car;

    private BidStatus bidStatus;

    public BidDTO getBioDTO(){
        BidDTO bidDTO = new BidDTO();

        bidDTO.setId(id);

        bidDTO.setPrice(price);

        bidDTO.setCarId(car.getId());

        bidDTO.setCarName(car.getName());

        bidDTO.setCarMarque(car.getMarque());

        bidDTO.setBidStatus(bidStatus);

        bidDTO.setEmail(user.getEmail());

        bidDTO.setUsername(user.getName());

        bidDTO.setSellerName(car.getUser().getName());

        return bidDTO;
    }

}
