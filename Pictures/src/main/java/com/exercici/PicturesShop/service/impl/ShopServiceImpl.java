package com.exercici.PicturesShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exercici.PicturesShop.domain.Shop;
import com.exercici.PicturesShop.repositories.IShopRepository;
import com.exercici.PicturesShop.service.ShopService;

@Service(value = "shopService")
public class ShopServiceImpl implements ShopService {

	@Autowired
	private IShopRepository shopRepository;

	@Override
	public HttpStatus create(Shop shop) {
		
		if (shop.getName() == null)
			return HttpStatus.BAD_REQUEST;

		shopRepository.save(shop);
		return HttpStatus.CREATED;
	}

	@Override
	public List<Shop> listShops() {		
		return shopRepository.findAll();
	}

}
