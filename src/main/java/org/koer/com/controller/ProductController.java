package org.koer.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.koer.com.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.locks.Condition;

@RestController
@RequestMapping("api/products")
@Api(tags = "商品管理")
public class ProductController {
    private static Map<Integer,Product> productMap=new HashMap<>();
    static {
        productMap.put(1,new Product(1,"小兔子手环","张万森的粉色兔子手环",12.00));
        productMap.put(2,new Product(2,"掉落的魔法日记","偶然掉落的过去的魔法日记",45.00));
        productMap.put(3,new Product(3,"雷军的小米手环","比较贵的雷军的小米手环",1200.00));
        productMap.put(4,new Product(4,"鲨鱼小玩偶","我像鲨鱼一样保护着你",67.00));
    }
    //获取所有商品
    @GetMapping
    @ApiOperation(value = "获取全部商品信息",notes = "获取全部商品信息")
    public  List<Product> getAllProducts(){
        return new ArrayList<>(productMap.values());
    }
    //根据单个id获取商品
    @GetMapping("/{id}")
    @ApiOperation(value = "根据单个id获取商品信息",notes = "根据单个id获取商品信息")
    public static ResponseEntity<Product> getProductById(@PathVariable Integer id){
        if (productMap.containsKey(id)) {
            return ResponseEntity.ok(productMap.get(id));

        }
        return ResponseEntity.notFound().build();

    }

    //创建商品
    @PostMapping
    @ApiOperation(value = "新建商品",notes = "添加一个商品")
    public Product createProduct(@RequestBody Product product){
        productMap.put(product.getId(),product);
        return productMap.get(product.getId());
    }
}


