package com.exercici.PicturesShop.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.exercici.PicturesShop.domain.Shop;

public interface ShopService {

	HttpStatus create(Shop shop);

	List<Shop> listShops();

}
