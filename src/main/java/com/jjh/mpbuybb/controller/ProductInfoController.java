package com.jjh.mpbuybb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jjh.mpbuybb.bean.ProductInfo;
import com.jjh.mpbuybb.bean.TypeInfo;
import com.jjh.mpbuybb.service.ProductInfoService;
import com.jjh.mpbuybb.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {
    @Resource
    ProductInfoService productInfoService;

    /**
     * 添加商品信息
     */
    @PostMapping("/addProduct")
    public ResultVO addProduct(ProductInfo productInfo){
        int result = productInfoService.getBaseMapper().insert(productInfo);
        if (result == -1) {
            return new ResultVO(510, "数据请求验证失败");
        }
        if(result > 0) {
            return new ResultVO(200, "添加成功", true,productInfo);
        }
        return new ResultVO(500, "添加失败");
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
        int result = productInfoService.getBaseMapper().updateById(productInfo);
        if (result == -1) {
            return new ResultVO(510, "数据请求验证失败");
        }
        if(result > 0) {
            return new ResultVO(200, "修改成功", true, productInfo);
        }
        return new ResultVO(500, "修改失败");
    }

    /**
     * 删除商品信息
     */
    @DeleteMapping("/deleteProduct/{pno}")
    public ResultVO deleteProduct(@PathVariable Integer pno) {

        return new ResultVO(200, "删除成功", productInfoService.removeById(pno));
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
        wrapper.like(productInfo.getPname()!= null, ProductInfo:: getPname, productInfo.getPname())
                .like(productInfo.getPno()!= null, ProductInfo:: getPno, productInfo.getPno());

        //分页
        Page<ProductInfo> pfPage = new Page<>(curentPage, pageSize);
        Page<ProductInfo> page = productInfoService.page(pfPage, wrapper);
        return new ResultVO(200, "查询成功", true,page);
    }




}
