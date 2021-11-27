package com.lyra.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyra.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
public interface ProductMapper extends BaseMapper<Product> {
    IPage<Product> findProductAndCategoryName(IPage<Product> productIPage);

    Product findProductAndCateegory(Integer id);

    IPage<Product> findProductByName(IPage<Product> productIPage, String name);

    IPage<Product> findPriceByProduct(IPage<Product> productIPage, Double beginPrice, Double endPrice);

    IPage<Product> findProductByCondtion(IPage<Product> productIPage, Double beginPrice, Double endPrice, String name);
}
