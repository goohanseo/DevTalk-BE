package com.devtalk.item.dtitemapi.item.service;

import com.devtalk.item.dtitemapi.item.domain.Product;

public interface ProductService {
    Product reserveProduct(Long time, Long tutorid);
}
