package com.jjh.mpbuybb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jjh.mpbuybb.bean.ProductInfo;
import com.jjh.mpbuybb.bean.TypeInfo;
import com.jjh.mpbuybb.mapper.ProductInfoMapper;
import com.jjh.mpbuybb.service.ProductInfoService;
import com.jjh.mpbuybb.service.TypeInfoService;
import com.jjh.mpbuybb.service.impl.ProductInfoImpl;
import com.jjh.mpbuybb.vo.LayuiVO;
import com.jjh.mpbuybb.vo.R;
import com.jjh.mpbuybb.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productInfo")
@Api(tags = "小程序接收端口")
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
     * 搜索商品信息
     */
    @GetMapping("/findAllProduct")
    public List<ProductInfo> findAllProduct(){
//        return new ResultVO(200, "查询成功", true,productInfoService.getBaseMapper().selectList(null));
        return productInfoService.findAllProduct();
    }





    /**
     * 搜索商品信息(根据商品名称查询后分页)
     */
    @GetMapping("/findByPname")
    public R findByPname(String pname,Integer pageNum,Integer pageSize){
        return productInfoService.findByPname(pname,pageNum,pageSize);
    }

    /**
     * 修改商品信息
     */
    @PutMapping("/updateProduct")
    public ResultVO updateProduct(ProductInfo productInfo){
        boolean result = productInfoImpl.updateById(productInfo);
        if (!result) {
            return new ResultVO(510, "数据请求验证失败");
        }
        else {
            return new ResultVO(200, "修改成功", true,productInfo);
        }
    }
//    public R updateProduct(@RequestBody ProductInfo productInfo,Integer pno){
//
//        return productInfoService.updateProduct(productInfo,pno);
//
//    }

    /**
     * 删除商品信息
     */
    @DeleteMapping("/deleteProduct/{pno}")
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
//    @GetMapping("/findProduct/{tname}/{curentPage}/{pageSize}")
//    public ResultVO findProduct(@PathVariable Integer tno,@PathVariable Integer curentPage,@PathVariable Integer pageSize,ProductInfo productInfo)
//    {
//        LambdaQueryWrapper<ProductInfo> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(ProductInfo::getTno,tno);
//        //根据商品名称和商品编号模糊查询
//        wrapper.like(productInfo.getPname()!= null, ProductInfo:: getPname, productInfo.getPname()).or()
//                .like(productInfo.getPno()!= null, ProductInfo:: getPno, productInfo.getPno());
//
//        //分页
//        Page<ProductInfo> pfPage = new Page<>(curentPage, pageSize);
//        Page<ProductInfo> page = productInfoService.page(pfPage, wrapper);
//        return new ResultVO(200, "查询成功", true,page);
//    }

    /**
     * 多表联合：查询type_info表中tname时显示product_info表中对应的所有商品信息
     */
//    @GetMapping("/findTno/{currentpage}/{pagesize}")
//    public Page<ProductInfo> findTno(@PathVariable Integer currentpage,@PathVariable Integer pagesize){
//        Page<ProductInfo> page = new Page<>(currentpage, pagesize);
//        return productInfoImpl.findPage(currentpage,pagesize);
//    }

    /**
     * 多表联合：查询type_info表中tname时显示product_info表中对应的所有商品信息
     * @param pageNum 页码
     * @param pageSize 每页显示的条数
     * @return 返回分页后的数据
     */
    @GetMapping("/getAll")
    public R testall(Integer pageNum,Integer pageSize){
        return  productInfoService.getAll(pageNum,pageSize);

    }

    /**
     * 根据tno返回对应所有信息
     */

    @GetMapping("/findByTno/{tno}")
    public List<ProductInfo> findByTno(@PathVariable Integer tno){
        return productInfoService.findByTno(tno);
    }


    /**
     * 根据tno返回对应所有信息
     */
    @GetMapping("/findByPnameNoPage/{pname}")
    public List<ProductInfo> findByPnameNoPage(@PathVariable String pname){
        return productInfoService.findByPnameNoPage(pname);
    }


    /**
     * 文件上传
     */
    @Value("${file.upload.url}")
    private String uploadFile;
    @PostMapping("/upload")
    @ApiOperation("添加商品信息")
    public LayuiVO upload(ProductInfo productInfo, MultipartFile file) throws Exception{
        productInfo.setImgs("11122.png");
        boolean save = productInfoService.save(productInfo);
        System.out.println(productInfo.getPno());
        productInfo.setImgs(productInfo.getPno()+".jpg");
        productInfoService.updateById(productInfo);
        File dest = new File(uploadFile, productInfo.getPno() + ".jpg");
        if(file!=null) file.transferTo(dest);
        //存入数据
        productInfo.setImgs(productInfo.getPno()+".jpg");
        return new LayuiVO<>(200,"成功");
    }

@Autowired
    private TypeInfoService typeInfoService;

    @ApiOperation(value = "多字段模糊查询" ,notes = "如果类型没有传就是查询所有的商品信息,如果\n1.msg是null，type不为空，根据type查询\n" +
            "2.如果type为空，msg不是空，直接没有类型的要求查询\n,3.如果，type不是空,msg不是空，就是在查询type这种类型下面的对应msg消息的商品信息")
    @GetMapping("/dimSearch")
    //实现一些查询功能 -手办的模糊查询
    public LayuiVO<List<ProductInfo>> getProductDimSearch(@RequestParam(required = false) @ApiParam("查询的内容")  String msg, @RequestParam(required = false) @ApiParam(value = "指定的类型名字" ,required = false) String type) {
        //限制类型，根据什么都可以进行模糊查询
        LambdaQueryWrapper<ProductInfo> productInfoLqw = new LambdaQueryWrapper<>();
        List<ProductInfo> productInfoList=null;
        if(msg==null && type==null) return new LayuiVO<>(510,"没有可查询的内容，查询失败");
        if(msg==null&&type!=null){
            LambdaQueryWrapper<TypeInfo> typeInfolqw = new LambdaQueryWrapper<>();
            typeInfolqw.eq(TypeInfo::getTname, type);
            TypeInfo one = typeInfoService.getOne(typeInfolqw);
            LambdaQueryWrapper<ProductInfo> productInfoLqw1 = new LambdaQueryWrapper<>();
            productInfoLqw1.eq(ProductInfo::getTno,one.getTno());
            List<ProductInfo> list = productInfoService.list(productInfoLqw1);
            for (ProductInfo productInfo : list) {
                TypeInfo typeInfo = typeInfoService.getById(productInfo.getTno());
                productInfo.setTname(typeInfo.getTname());
            }
            return new LayuiVO<List<ProductInfo>>(200,list);
        }
        if (type != null){
            LambdaQueryWrapper<TypeInfo> typeInfoLqw = new LambdaQueryWrapper<>();
            typeInfoLqw.like(TypeInfo::getTname, type);
            TypeInfo one = typeInfoService.getOne(typeInfoLqw);
            if(one==null) return new LayuiVO<>(510,"当前类型不存在");
            //限制商品的类型
            productInfoLqw.like(ProductInfo::getTno,one.getTno()).like(ProductInfo::getPname,msg).or().like(ProductInfo::getPintro,msg);
        }
        productInfoLqw.like(ProductInfo::getPname,msg).or().like(ProductInfo::getPintro,msg);
        List<ProductInfo> list = productInfoService.list(productInfoLqw);
        for (ProductInfo productInfo : list) {
            TypeInfo typeInfo = typeInfoService.getById(productInfo.getTno());
            productInfo.setTname(typeInfo.getTname());
        }
        return new LayuiVO<List<ProductInfo>>(200,list);
    }



}
