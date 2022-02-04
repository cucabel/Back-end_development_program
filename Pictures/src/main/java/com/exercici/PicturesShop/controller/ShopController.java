package com.exercici.PicturesShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercici.PicturesShop.domain.Shop;
import com.exercici.PicturesShop.service.ShopService;

@CrossOrigin
@RestController
@RequestMapping(value = "/shops")
public class ShopController {

	@Autowired
	private ShopService shopService;

	@PostMapping
	ResponseEntity<HttpStatus> create(@RequestBody Shop shop) {
		return new ResponseEntity<>(shopService.create(shop));
	}

	@GetMapping
	ResponseEntity<List<Shop>> listShops() {
		return new ResponseEntity<>(shopService.listShops(), HttpStatus.OK);
	}

}
