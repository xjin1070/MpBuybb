package com.jjh.mpbuybb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jjh.mpbuybb.bean.TypeInfo;
import com.jjh.mpbuybb.service.TypeInfoService;
import com.jjh.mpbuybb.vo.LayuiVO;
import com.jjh.mpbuybb.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/type")
public class TypeInfoController {
    @Resource
//    @Qualifier("typeInfoServiceImpl")
//
//    @Autowired
    private TypeInfoService typeInfoService;
    /**
     * 处理添加商品类型
     * @param typeInfo 商品类型
     * @return
     */

//    @PostMapping
//    public ResultVO add(String tname){
//        int result = typeInfoService.add(tname);



    @PostMapping("/add")
//    public ResultVO add(@RequestBody TypeInfo tname)
    public ResultVO add(TypeInfo typeInfo)
    {
//        int result = typeInfoService.add(tname);
        int result = typeInfoService.getBaseMapper().insert(typeInfo);
        if (result == -1) {
            return new ResultVO(510, "数据请求验证失败");
        }
        if(result > 0) {
            return new ResultVO(200, "添加成功",true,typeInfo);
        }
        return new ResultVO(500, "添加失败");
    }


    @GetMapping("/finds")
    public ResultVO finds(){
        List<TypeInfo> list = typeInfoService.getBaseMapper().selectList(null);
        if(list != null && !list.isEmpty()) {
            return new ResultVO(200, list);
        }
        return new ResultVO(600, "暂无数据");
    }


    /**
     * 查询所有商品类型数据
     * @return
     */
    @GetMapping("/findAll")
    public LayuiVO findAll(){
        List<TypeInfo> list = typeInfoService.getBaseMapper().selectList(null);
        if(list != null && !list.isEmpty()) {
            return new LayuiVO(list);
        }
        return new LayuiVO(600, "暂无数据");
    }

    // 根据tno删除商品类型
//    @DeleteMapping("/delByTno")
////    public ResultVO delete(@PathVariable("tno") Integer tno)
//    public ResultVO delByTno(Integer tno)
//    {
////        int result = typeInfoService.getBaseMapper().deleteById(tno);
//        boolean result = typeInfoService.removeById(tno);
//
////        if(result > 0) {
////            return new ResultVO(200, "删除成功");
////        }
////         return new ResultVO(500, "删除失败");
//        return new ResultVO(1,"删除成功");
//    }

    /**
     * 根据tno删除商品类型(物理删除)
     * @param tno 商品类型编号
     * @return
     */
    @DeleteMapping("/delByTno/{tno}")
//    @ResponseBody
//    public  ResultVO delByTno(@RequestParam Integer tno) //不带tno删除
    public  ResultVO delByTno(@PathVariable Integer tno) //带tno路径删除
    {
        boolean r = typeInfoService.removeById(tno);
        if (r) {
            return new ResultVO(200, "删除成功",true);
        }
        return new ResultVO(505, "删除失败");
    }

    /**
     * 根据tno修改商品类型
     * @param typeInfo 商品类型编号
     * @return
     */
    @PutMapping("/updateByTno")
    public ResultVO update(TypeInfo typeInfo) {
//        TypeInfo typeInfo1 = typeInfoService.getBaseMapper().selectById(typeInfo.getTno());
//        int result = typeInfoService.update(typeInfo1);
//        if(result > 0) {
//            return new ResultVO(200, "修改成功");
//        }
//        return new ResultVO(500, "修改失败");
//    }
        try {
            if (typeInfoService.updateById(typeInfo)) {
                return new ResultVO(200, "修改成功", true,typeInfo);
            }
        } catch (Exception e) {
            return new ResultVO(501, "重复的商品类型");
        }
        return new ResultVO(502, "修改失败");
    }

    /**
     * 模糊查询商品类型
     * @param
     * @return
     */
    // 模糊查询
    @GetMapping("/finddd/{curentPage}/{pageSize}")
    public Map<String,Object> finddd( @PathVariable Integer curentPage,@PathVariable Integer pageSize) {
//        LambdaQueryWrapper<TypeInfo> queryWrapper = new LambdaQueryWrapper<>();
//        //queryWrapper.eq(TypeInfo :: getTno, content);
//
//      //  queryWrapper.like(typeInfo.getTname() != null, TypeInfo :: getTname, content);
//
//        Page<TypeInfo> typeInfoPage = new Page<>(curentPage, pageSize);
//        Page<TypeInfo> page1 = typeInfoService.page(typeInfoPage, null);
//        List<TypeInfo> list = typeInfoService.finddd(tname, page);
//        if (list != null && !list.isEmpty()) {
//            return new LayuiVO(list);
//        }
//        return new LayuiVO(600, "暂无数据");
       Map<String,Object> page1=typeInfoService.finds(curentPage,pageSize);

       return page1;
//        return new ResultVO(true, page1);
    }

    /**
     * 根据tno查询商品类型
     * @param tno 商品类型编号
     * @return
     */
    @GetMapping("/findByTno/{tno}")
    public ResultVO findByTno(@PathVariable Integer tno) {
        TypeInfo typeInfo = typeInfoService.getById(tno);
        if (typeInfo != null) {
            return new ResultVO(200,"查询视频", typeInfo,true);
        }
        return new ResultVO(505, "查询失败,没有该商品类型");
    }


}
