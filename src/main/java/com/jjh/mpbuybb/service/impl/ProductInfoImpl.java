package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.ProductInfo;
import com.jjh.mpbuybb.bean.TypeInfo;
import com.jjh.mpbuybb.mapper.ProductInfoMapper;
import com.jjh.mpbuybb.service.ProductInfoService;
import com.jjh.mpbuybb.vo.R;
import com.jjh.mpbuybb.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductInfoImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

//    @Autowired


    // 多表查询分页
    @Resource
    private ProductInfoMapper productInfoMapper;
//    public Page<ProductInfo> findPage(int currentpage, int pagesize) {
//        Page<ProductInfo> page = new Page<>(currentpage, pagesize);
//        return productInfoMapper.findPage(page);
//    }

    @Override
    public R getAll(Integer pageNum, Integer pageSize) {
        pageNum = (pageNum -1)*pageSize;
         List<ProductInfo> productInfos=productInfoMapper.getAll(pageNum,pageSize);
         Integer total = productInfoMapper.getTotal().size();
//        Integer total = productInfos.size();
        return R.ok().data("productInfos",productInfos).data("total",total);
    }

    @Override
    public List<ProductInfo> findAllProduct() {
        return productInfoMapper.selectList(null);
    }

    @Override
    public List<ProductInfo> findByTno(Integer tno) {
        QueryWrapper<ProductInfo> lm=new QueryWrapper<>();
//        lm.select("tno");
        lm.eq("tno",tno);
        return productInfoMapper.selectList(lm);
    }

    @Override
    public List<ProductInfo> findByPnameNoPage(String pname) {
//        LQueryWrapper<ProductInfo> lm=new QueryWrapper<>();
        LambdaQueryWrapper<ProductInfo> lm=new LambdaQueryWrapper<>();
        //pname = "%"+pname+"%";
        lm.like(pname!=null,ProductInfo::getPname,pname);
        return productInfoMapper.selectList(lm);
    }

    @Override
    public R updateProduct(ProductInfo productInfo,Integer pno) {
//        System.out.println(pno);
//        String pname =new String();
//        String punit =new String();
//        String pnw =new String();
//        String pexp =new String();
//        String pintro =new String();
//        String tname =new String();
//        String imgs =new String();
//        Double price =new Double(0);
//        Integer pinvent =new Integer(0);
//        Integer tno =new Integer(0);
//        Integer status =new Integer(0);
//        Integer deleted =new Integer(0);
//        System.out.println(productInfo.getPname());
//
//        if (!productInfo.getPname().isEmpty()){
//             pname = productInfo.getPname();
//            System.out.println(pname);
//        }
//        if (!productInfo.getPrice().toString().isEmpty()){
//             price = productInfo.getPrice();
//        }
//        if (!productInfo.getPinvent().toString().isEmpty()){
//             pinvent = productInfo.getPinvent();
//        }
//        if (!productInfo.getPunit().isEmpty()){
//             punit = productInfo.getPunit();
//        }
//        if (!productInfo.getPnw().isEmpty()){
//             pnw = productInfo.getPnw();
//        }
//        if (!productInfo.getPexp().isEmpty()){
//             pexp = productInfo.getPexp();
//        }
//        if (!productInfo.getPintro().isEmpty()){
//             pintro= productInfo.getPintro();
//        }
//        if (!productInfo.getTno().toString().isEmpty()){
//             tno = productInfo.getTno();
//        }
//        System.out.println(productInfo.getTname());
//        if (!productInfo.getTname().isEmpty()){
//             tname = productInfo.getTname();
//        }
//        if (!productInfo.getStatus().toString().isEmpty()){
//             status = productInfo.getStatus();
//        }
//        if (!productInfo.getDeleted().toString().isEmpty()){
//             deleted = productInfo.getDeleted();
//        }
//        if (!productInfo.getImgs().isEmpty()){
//             imgs = productInfo.getImgs();
//        }

        String pname = productInfo.getPname();
        Double price = productInfo.getPrice();
        Integer pinvent = productInfo.getPinvent();
        String punit = productInfo.getPunit();
        String pnw = productInfo.getPnw();
        String pexp = productInfo.getPexp();
        String pintro= productInfo.getPintro();
        Integer tno = productInfo.getTno();
        String tname = productInfo.getTname();
        Integer status = productInfo.getStatus();
        Integer deleted = productInfo.getDeleted();
        String imgs = productInfo.getImgs();

        baseMapper.updateProduct(pname,price,pinvent,punit,pnw,pexp,pintro,tno,tname,status,deleted,imgs,pno);
//        baseMapper.uppdateProduct01(productInfo);
        return R.ok().message("修改成功");
    }

    @Override
    public R findByPname(String pname, Integer pageNum, Integer pageSize) {
        pageNum = (pageNum -1)*pageSize;
        String pname1 = "%"+pname+"%";
        List<ProductInfo> productInfos=productInfoMapper.selectLists(pname1,pageNum,pageSize);
//        Integer total = productInfos.size();
        Integer total = productInfoMapper.getTotal1(pname1).size();
        return R.ok().data("productInfos",productInfos).data("total",total);
//        return productInfoMapper.selectList(pname1,pageNum,pageSize);
    }


}
