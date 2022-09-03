package org.java.yp.goods.service;

import org.java.yp.goods.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * @author 杨鹏
 * @version 1.0
 * Create by 2022/9/2 19:32
 */

public interface BrandService {

    //查询所有品牌
    public List<Brand> finAll();

    //根据id查询品牌
    public Brand findById(Integer id);

    //新增
    public void add(Brand brand);

    //修改
    public void update(Brand brand);

    //删除
    public void delete(Integer id);

    //模糊查询
    public List<Brand> search(Map<String, String> searchMap);

    //分页查询
    public List<Brand> findPage(int page,int size);

    //多条件分页查询
    public List<Brand> findPage(int page,int size,Map<String, String> searchMap);

}
