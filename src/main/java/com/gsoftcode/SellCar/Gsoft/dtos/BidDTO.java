package com.gsoftcode.SellCar.Gsoft.dtos;

import com.gsoftcode.SellCar.Gsoft.enums.BidStatus;
import lombok.Data;

@Data
public class BidDTO {

    private Long id;

    private Long price;

    private BidStatus bidStatus;

    private Long userId;

    private Long carId;

    private String username;

    private String carMarque;

    private String email;

    private String sellerName;

}
