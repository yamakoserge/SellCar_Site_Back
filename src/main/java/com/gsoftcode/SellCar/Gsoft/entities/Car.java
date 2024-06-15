package com.gsoftcode.SellCar.Gsoft.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gsoftcode.SellCar.Gsoft.dtos.CarDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String marque;

    private String type;

    private String transmission;


    private String color;

    private Date year;

    private Boolean sold;

    @Lob
    private String description;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore

    private User user;

    public CarDTO getCarDTO(){
        CarDTO carDto = new CarDTO();
        carDto.setId(id);
        carDto.setName(name);
        carDto.setMarque(marque);
        carDto.setType(type);
        carDto.setTransmission(transmission);
        carDto.setColor(color);
        carDto.setYear(year);
        carDto.setSold(sold);
        carDto.setDescription(description);
        carDto.setPrice(price);
        carDto.setReturnedImg(img);
        return carDto;
    }


}
