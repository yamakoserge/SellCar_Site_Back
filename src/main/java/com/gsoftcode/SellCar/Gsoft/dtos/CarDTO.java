package com.gsoftcode.SellCar.Gsoft.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date year;

    private Date model;

    private Boolean sold;

    private String description;

    private Long price;

    private MultipartFile img;

    private Long userId;

    private byte[] returnedImg;



}
