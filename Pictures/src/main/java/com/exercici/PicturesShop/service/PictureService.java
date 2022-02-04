package com.exercici.PicturesShop.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.exercici.PicturesShop.domain.Picture;

public interface PictureService {

	HttpStatus create(long shopId, Picture picture);

	List<Picture> getAllPictures(long shopId);

	void removeAllPictures(long shopId);

}
