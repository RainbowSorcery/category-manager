package com.lyra.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lyra.common.Result;
import com.lyra.entity.PmsCategory;
import com.lyra.entity.Product;
import com.lyra.entity.vo.CategoryVO;
import com.lyra.service.IPmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.*;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
@RestController
@RequestMapping("/pms-category")
public class PmsCategoryController {
    @Autowired
    private IPmsCategoryService categoryService;

    @GetMapping("/list/tree")
    public Result<List<PmsCategory>> treeList() {
        List<PmsCategory> tree = categoryService.findTree();

        return new Result<>(20000, true, "查询商品列表成功", tree);
    }

    @PostMapping("/add")
    public Result<Object> addCategory(@RequestBody PmsCategory category) {
        if (category != null) {
            categoryService.save(category);
            return new Result<>(20000, true, "添加商品分类成功");

        }

        return new Result<>(50000, false, "添加商品分类失败");
    }

    @GetMapping("/getCategoryById")
    public Result<PmsCategory> getCategoryById(@RequestParam Long categoryId) {
        if (categoryId != null) {
            PmsCategory category = categoryService.getById(categoryId);

            return new Result<>(20000, true, "查询分类id成功", category);
        }

        return new Result<>(50000, false, "查询分类id失败");
    }


    @PostMapping("/delete")
    public Result<Object> delete(@RequestBody  List<Long> ids) {
        if (!categoryService.removeByIds(ids)) {
            return new Result<Object>(500,false, "删除失败");
        }
        return new Result<Object>(20000,true, "删除成功");
    }

    @GetMapping("/list")
    public Result<List<PmsCategory>> list() {
        List<PmsCategory> list = categoryService.list();
        return new Result<>(20000, true, "查询成功", list);
    }

    @GetMapping("/findCategoryListByProduct")
    public Result<List<PmsCategory>> findCategoryListByProduct() {
        List<PmsCategory> categories = categoryService.findCategoryListByProduct();

        return new Result<>(20000, true, "查询成功", categories);
    }

    @PostMapping("/update")
    public Result<Object> update(@RequestBody PmsCategory pmsCategory) {
        QueryWrapper<PmsCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cat_id", pmsCategory.getCatId());
        categoryService.update(pmsCategory, queryWrapper);

        return new Result<>(20000, true, "更新成功");
    }
}
