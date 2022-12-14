package org.java.yp.goods.controller;

import org.java.yp.entity.Result;
import org.java.yp.entity.StatusCode;
import org.java.yp.goods.pojo.Brand;
import org.java.yp.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 杨鹏
 * @version 1.0
 * Create by 2022/9/2 19:44
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/findAll")
    public Result findAll(){
        List<Brand> brands = brandService.finAll();
        return new Result(true, StatusCode.OK,"查询成功",brands);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id){
        Brand byId = brandService.findById(id);
        return new Result(true, StatusCode.OK,"查询成功",byId);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK,"新增成功");
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody Brand brand,@PathVariable("id") Integer id){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK,"修改成功");
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") Integer id){
        brandService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }


    @GetMapping("/search")
    public Result search(@RequestParam Map<String, String> searchMap){
        List<Brand> brandList = brandService.search(searchMap);
        return new Result(true, StatusCode.OK,"查询成功",brandList);
    }

    @GetMapping("/search/{page}/{size}")
    public Result findPage(@PathVariable("page") int page, @PathVariable("size") int size){
        List<Brand> brandList = brandService.findPage(page, size);
        return new Result(true, StatusCode.OK,"查询成功",brandList);
    }

    @GetMapping("/searchPage/{page}/{size}")
    public Result searchPage(@RequestParam Map<String, String> searchMap,@PathVariable int page, @PathVariable int size){
        List<Brand> brandList = brandService.findPage(page,size,searchMap);
        return new Result(true,StatusCode.OK,"查询成功",brandList);
    }
}
