package com.deeznut.spring_boot_library.requestmodels;

import lombok.Data;

@Data
public class ReviewRequest {

    private double rating;

    private Long bookId;

    private String reviewDescription;
}