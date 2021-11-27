package com.lyra.service;

import com.lyra.entity.PmsCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
public interface IPmsCategoryService extends IService<PmsCategory> {
    List<PmsCategory> findTree();

    List<PmsCategory> findCategoryListByProduct();
}
