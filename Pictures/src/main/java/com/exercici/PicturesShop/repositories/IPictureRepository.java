package com.exercici.PicturesShop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercici.PicturesShop.domain.Picture;
import com.exercici.PicturesShop.domain.Shop;

@Repository
public interface IPictureRepository extends JpaRepository<Picture, Long> {

	List<Picture> findAllByShop(Shop shop);

	@Transactional
	void removeByShop(Shop shop);

}
