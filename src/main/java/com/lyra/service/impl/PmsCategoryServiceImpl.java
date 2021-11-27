package com.lyra.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyra.entity.PmsCategory;
import com.lyra.mapper.PmsCategoryMapper;
import com.lyra.service.IPmsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
@Service
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryMapper, PmsCategory> implements IPmsCategoryService {
    @Autowired
    private PmsCategoryMapper categoryMapper;

    @Override
    public List<PmsCategory> findTree() {
        long beginTime = System.currentTimeMillis();
        List<PmsCategory> categoryList = categoryMapper.selectList(null);

        //  思路： 新建一个set set中保存所有父id 根据父id查询并组装
        Set<Long> parentIdSet = new HashSet<>();
        categoryList.forEach((category -> {
            parentIdSet.add(category.getParentCid());
        }));

        List<PmsCategory> parentCategoryList = new ArrayList<>();
        categoryList.forEach((category -> {
            parentIdSet.forEach((id) -> {
                if (Objects.equals(id, category.getCatId())) {
                    parentCategoryList.add(category);
                }
            });
        }));

        parentCategoryList.forEach((parentCategory) -> {
            List<PmsCategory> pmsCategories = new ArrayList<>();
            categoryList.forEach((category -> {
                if (Objects.equals(parentCategory.getCatId(), category.getParentCid())) {
                    pmsCategories.add(category);
                }
            }));
            parentCategory.setChildren(pmsCategories);
        });

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        return parentCategoryList;
    }

    @Override
    public List<PmsCategory> findCategoryListByProduct() {
        return categoryMapper.findCategoryListByProduct();
    }
}
