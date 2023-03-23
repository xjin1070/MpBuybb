package com.jjh.mpbuybb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jjh.mpbuybb.bean.ProductInfo;
import com.jjh.mpbuybb.bean.TypeInfo;
import com.jjh.mpbuybb.mapper.ProductInfoMapper;
import com.jjh.mpbuybb.service.ProductInfoService;
import com.jjh.mpbuybb.service.impl.ProductInfoImpl;
import com.jjh.mpbuybb.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {
    @Resource
    ProductInfoService productInfoService;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private ProductInfoImpl  productInfoImpl;
    /**
     * 添加商品信息
     */
    @PostMapping("/addProduct")
    public ResultVO addProduct(ProductInfo productInfo){
        boolean result = productInfoImpl.save(productInfo);
        if (!result) {
            return new ResultVO(510, "数据请求验证失败");
        }
        else {
            return new ResultVO(200, "添加成功", true,productInfo);
        }
//        return new ResultVO(500, "添加失败");
    }

    /**
     * 搜索商品信息(所有)
     */
    @GetMapping("/findAllProduct")
    public ResultVO findAllProduct(){
        return new ResultVO(200, "查询成功", true,productInfoService.getBaseMapper().selectList(null));
    }



    /**
     * 修改商品信息
     */
    @PutMapping("/updateProduct")
    public ResultVO updateProduct(ProductInfo productInfo){

        QueryWrapper<ProductInfo> wrapper = new QueryWrapper<ProductInfo>();
        wrapper.eq("pno",productInfo.getPno());
        List<ProductInfo>list = productInfoMapper.selectList(wrapper);
        if(!list.isEmpty()){
            return new ResultVO(510,"id已存在,已存在的商品",list,false);
        }else{
            int result = productInfoService.getBaseMapper().updateById(productInfo);
            if (result == -1) {
                return new ResultVO(510, "数据请求验证失败");
            }
            if(result > 0) {
                return new ResultVO(200, "修改成功", true, productInfo);
            }
            return new ResultVO(500, "修改失败");
        }

    }

    /**
     * 删除商品信息
     */
    @DeleteMapping("/delByPno/{pno}")
    public ResultVO deleteProduct(@PathVariable Integer pno) {
//        boolean r = productInfoService.removeById(pno);
        boolean r = productInfoService.removeById(pno);
        if (r)
        {
            return new ResultVO(200, "逻辑删除成功，deleted字段为1",true);
        }
        return new ResultVO(505, "逻辑删除失败，deleted字段为0");
//          productInfoMapper.deleteById(pno);
//        System.out.println(r);
//        if(r==0){
//
//        }
//        else {
//            return new ResultVO(666, "删除失败", false);
//        }

    }


    /**
     * 搜索商品信息(根据商品名称，商品类型，商品编号)
     */
    @GetMapping("/findProduct/{tno}/{curentPage}/{pageSize}")
    public ResultVO findProduct(@PathVariable Integer tno,@PathVariable Integer curentPage,@PathVariable Integer pageSize,ProductInfo productInfo)
    {
        LambdaQueryWrapper<ProductInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProductInfo::getTno,tno);
        //根据商品名称和商品编号模糊查询
        wrapper.like(productInfo.getPname()!= null, ProductInfo:: getPname, productInfo.getPname()).or()
                .like(productInfo.getPno()!= null, ProductInfo:: getPno, productInfo.getPno());

        //分页
        Page<ProductInfo> pfPage = new Page<>(curentPage, pageSize);
        Page<ProductInfo> page = productInfoService.page(pfPage, wrapper);
        return new ResultVO(200, "查询成功", true,page);
    }

    /**
     * 多表联合：查询type_info表中tname时显示product_info表中对应的所有商品信息
     */
//    @GetMapping("/findTno/{currentpage}/{pagesize}")
//    public Page<ProductInfo> findTno(@PathVariable Integer currentpage,@PathVariable Integer pagesize){
//        Page<ProductInfo> page = new Page<>(currentpage, pagesize);
//        return productInfoImpl.findPage(currentpage,pagesize);
//    }
    @GetMapping("/testall")
    public List<ProductInfo> testall(){
        return productInfoMapper.getAll();
    }

}
