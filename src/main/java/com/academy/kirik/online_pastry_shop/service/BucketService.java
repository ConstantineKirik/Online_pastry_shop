package com.academy.kirik.online_pastry_shop.service;

import com.academy.kirik.online_pastry_shop.dto.BucketDTO;
import com.academy.kirik.online_pastry_shop.model.entity.Bucket;
import com.academy.kirik.online_pastry_shop.model.entity.Product;
import com.academy.kirik.online_pastry_shop.model.entity.User;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Integer> productIds);

    void addProduct(Bucket bucket, List<Integer> productIds);

    BucketDTO getBucketByUser(String username);
}
