package com.gsoftcode.SellCar.Gsoft.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class CarDTO {

    private Long id;

    private String name;

    private String marque;

    private String type;

    private String transmission;

    private String color;

    private Date year;

    private Boolean sold;

    private String description;

    private Long price;

    private MultipartFile img;

    private Long userId;

    private byte[] returnedImg;



}
