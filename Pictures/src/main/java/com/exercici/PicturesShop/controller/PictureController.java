package com.exercici.PicturesShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercici.PicturesShop.domain.Picture;
import com.exercici.PicturesShop.service.PictureService;

@CrossOrigin
@RestController
@RequestMapping("shops/{shopId}/pictures")
public class PictureController {

	@Autowired
	private PictureService pictureService;

	@PostMapping
	ResponseEntity<HttpStatus> create(@PathVariable long shopId, @RequestBody Picture picture) {
		return new ResponseEntity<>(pictureService.create(shopId, picture));
	}

	@GetMapping
	ResponseEntity<List<Picture>> getAllPictures(@PathVariable long shopId) {
		return new ResponseEntity<>(pictureService.getAllPictures(shopId), HttpStatus.OK);
	}

	@DeleteMapping
	ResponseEntity<HttpStatus> removeAllPictures(@PathVariable long shopId) {
		pictureService.removeAllPictures(shopId);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
