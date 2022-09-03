package org.java.yp.goods.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.java.yp.goods.dao.BrandMapper;
import org.java.yp.goods.pojo.Brand;
import org.java.yp.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 杨鹏
 * @version 1.0
 * Create by 2022/9/2 19:36
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    BrandMapper brandMapper;

    //查询所有品牌
    @Override
    public List<Brand> finAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void update(Brand brand) {
    brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> search(Map<String, String> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap !=null){
            if (StringUtils.isNotBlank(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            if (StringUtils.isNotBlank(searchMap.get("letter"))){
                criteria.andEqualTo("letter",searchMap.get("letter"));
            }
        }
        List<Brand> brands = brandMapper.selectByExample(example);
        return brands;
    }

    @Override
    public List<Brand> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        List<Brand> brands = brandMapper.selectAll();
        return brands;
    }

    @Override
    public List<Brand> findPage(int page, int size, Map<String, String> searchMap) {
        PageHelper.startPage(page,size);
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap !=null){
            if (StringUtils.isNotBlank(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            if (StringUtils.isNotBlank(searchMap.get("letter"))){
                criteria.andEqualTo("letter",searchMap.get("letter"));
            }
        }
        List<Brand> brands = brandMapper.selectByExample(example);
        return brands;
    }




}
