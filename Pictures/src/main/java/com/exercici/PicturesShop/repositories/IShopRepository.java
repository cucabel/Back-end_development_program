package com.exercici.PicturesShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercici.PicturesShop.domain.Shop;

public interface IShopRepository extends JpaRepository<Shop, Long> {

}
