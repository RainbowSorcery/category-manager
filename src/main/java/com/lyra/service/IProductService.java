package com.lyra.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyra.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
public interface IProductService extends IService<Product> {
    IPage<Product> findProductAndCategoryList(IPage<Product> productIPage);

    Product findProductAndCategoryName(Integer id);

    IPage<Product> findProductByName(IPage<Product> productIPage, String name);

    IPage<Product> findPriceByProduct(IPage<Product> productIPage, Double beginPrice, Double endPrice);

    IPage<Product> findProductByContdtion(IPage<Product> productIPage, Double beginPrice, Double endPrice, String name);
}
