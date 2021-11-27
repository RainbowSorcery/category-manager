package com.lyra.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyra.entity.Product;
import com.lyra.mapper.ProductMapper;
import com.lyra.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<Product> findPriceByProduct(IPage<Product> productIPage, Double beginPrice, Double endPrice) {
        return productMapper.findPriceByProduct(productIPage, beginPrice, endPrice);
    }

    @Override
    public IPage<Product> findProductAndCategoryList(IPage<Product> productIPage) {
        return productMapper.findProductAndCategoryName(productIPage);
    }

    @Override
    public Product findProductAndCategoryName(Integer id) {
        return productMapper.findProductAndCateegory(id);
    }

    @Override
    public IPage<Product> findProductByName(IPage<Product> productIPage, String name) {
        return productMapper.findProductByName(productIPage, name);
    }

    @Override
    public IPage<Product> findProductByContdtion(IPage<Product> productIPage, Double beginPrice, Double endPrice, String name) {

        return productMapper.findProductByCondtion(productIPage, beginPrice, endPrice, name);
    }
}
