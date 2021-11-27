package com.lyra.mapper;

import com.lyra.entity.PmsCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品三级分类 Mapper 接口
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
public interface PmsCategoryMapper extends BaseMapper<PmsCategory> {

    List<PmsCategory> findCategoryListByProduct();

}
