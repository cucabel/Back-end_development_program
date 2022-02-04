package com.exercici.PicturesShop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exercici.PicturesShop.domain.Picture;
import com.exercici.PicturesShop.domain.Shop;
import com.exercici.PicturesShop.repositories.IPictureRepository;
import com.exercici.PicturesShop.repositories.IShopRepository;
import com.exercici.PicturesShop.service.PictureService;

@Service(value = "pictureService")
public class PictureServiceImpl implements PictureService {

	@Autowired
	private IShopRepository shopRepository;

	@Autowired
	private IPictureRepository pictureRepository;

	@Override
	public HttpStatus create(long shopId, Picture picture) {

		Optional<Shop> shop = shopRepository.findById(shopId);
		if (!shop.isPresent())
			return HttpStatus.NOT_FOUND;

		if (picture.getName() == null || picture.getAuthorName() == null)
			return HttpStatus.BAD_REQUEST;

		pictureRepository.save(new Picture(picture.getName(), new Double(picture.getPrice()), picture.getAuthorName(), shop.get()));
		return HttpStatus.CREATED;
	}

	@Override
	public List<Picture> getAllPictures(long shopId) {
		return pictureRepository.findAllByShop(shopRepository.findById(shopId).get());
	}

	@Override
	public void removeAllPictures(long shopId) {
		pictureRepository.removeByShop(shopRepository.findById(shopId).get());
	}

}
