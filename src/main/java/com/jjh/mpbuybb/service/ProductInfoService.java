package com.jjh.mpbuybb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jjh.mpbuybb.bean.ProductInfo;
import com.jjh.mpbuybb.vo.R;
import com.jjh.mpbuybb.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface ProductInfoService extends IService<ProductInfo> {
      R findByPname(String pname, Integer pageNum, Integer pageSize);

      R getAll(Integer pageNum, Integer pageSize);

      List<ProductInfo> findAllProduct();

      List<ProductInfo> findByTno(Integer tno);

      List<ProductInfo> findByPnameNoPage(String pname);

     R updateProduct(ProductInfo productInfo,Integer pno);

//    List<ProductInfo> selectList(String pname, Integer pageNum, Integer pageSize);

}
