package com.lyra.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyra.common.Result;
import com.lyra.common.utils.UploadUtils;
import com.lyra.entity.Product;
import com.lyra.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyra
 * @since 2021-11-16
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private UploadUtils uploadUtils;

    @GetMapping("/list")
    public Result<List<Product>> list() {

        List<Product> list = productService.list();

        return new Result<>(20000, true, "查询成功", list);
    }

    @PostMapping("/upload")
    public Result<Object> upload(@RequestParam MultipartFile file) {
        try {
            String fileName = UUID.randomUUID().toString() + ".jpg";
            byte[] fileBytes = file.getBytes();
            String fileUrl = uploadUtils.upload(fileName, fileBytes);

            return new Result<>(20000, true, "上传成功", fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result<>(50000, false, "上传失败");
        }
    }

    @GetMapping("/list/page")
    public Result<IPage<Product>> page(Integer current, Integer size) {
        if (current == null) {
            current = 0;
        }

        if (size == null) {
            size = 5;
        }

        IPage<Product> productIPage = new Page<>(current, size);
        IPage<Product> page = productService.findProductAndCategoryList(productIPage);
        return new Result<>(20000, true, "查询商品列表成功", page);
    }

    @PostMapping("/add")
    public Result<Object> add(@RequestBody Product product) {
        if (product != null) {
            productService.save(product);

            return new Result<>(20000, true, "商品添加成功");
        }
        return new Result<>(50000, false, "商品添加失败");
    }

    @PostMapping("/delete")
    public Result<Object> delete(@RequestParam Long id) {
        if (id != null) {
            productService.removeById(id);
            return new Result<>(20000, true, "商品添加成功");
        }
        return new Result<>(50000, false, "商品删除失败");
    }

    @GetMapping("/findProductAdnCategoryName")
    public Result<Product> findProductAndCategoryName(@RequestParam Integer id) {
        Product product = productService.findProductAndCategoryName(id);
        return new Result<>(20000, true, "查询成功", product);
    }

    @PostMapping("/update")
    public Result<Product> update(@RequestBody Product product) {
        productService.updateById(product);
        return new Result<>(20000, true, "更新成功");
    }

    @GetMapping("/findProductByName")
    public Result<IPage<Product>> findProductByName(Integer current, Integer pageSize, String name) {
        if (current == null) {
            current = 0;
        }

        if (pageSize == null) {
            pageSize = 7;
        }

        IPage<Product> productIPage = new Page<>(current, pageSize);
        IPage<Product> page = productService.findProductByName(productIPage, name);

        return new Result<>(20000, true, "查询成功", page);
    }

    @GetMapping("/findPriceByProduct")
    public Result<IPage<Product>> findPriceByProduct(Integer current, Integer pageSize, Double beginPrice, Double endPrice) {
        if (current == null) {
            current = 0;
        }

        if (pageSize == null) {
            pageSize = 7;
        }


        IPage<Product> productIPage = new Page<>(current, pageSize);
        IPage<Product> page = productService.findPriceByProduct(productIPage, beginPrice, endPrice);

        return new Result<>(20000, true, "查询成功", page);
    }

    @GetMapping("/findConditionByProduct")
    public Result<IPage<Product>> findConditionByProduct(Integer current, Integer pageSize, Double beginPrice, Double endPrice, String name) {

        if (current == null) {
            current = 0;
        }

        if (pageSize == null) {
            pageSize = 7;
        }
        IPage<Product> productIPage = new Page<>(current, pageSize);
        IPage<Product> page = productService.findProductByContdtion(productIPage, beginPrice, endPrice, name);

        return new Result<>(20000, true, "查询成功", page);
    }
}
