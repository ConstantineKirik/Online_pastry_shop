package com.academy.kirik.online_pastry_shop.model.repository;

import com.academy.kirik.online_pastry_shop.model.entity.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket, Integer> {
}
