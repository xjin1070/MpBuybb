package com.jjh.mpbuybb.controller;

import com.jjh.mpbuybb.bean.TypeInfo;
import com.jjh.mpbuybb.service.TypeInfoService;
import com.jjh.mpbuybb.vo.LayuiVO;
import com.jjh.mpbuybb.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
     * @param tname
     * @return
     */

//    @PostMapping
//    public ResultVO add(String tname){
//        int result = typeInfoService.add(tname);



    @PostMapping("/add")
//    public ResultVO add(@RequestBody TypeInfo tname)
    public ResultVO add( TypeInfo tname)
    {
//        int result = typeInfoService.add(tname);
        int result = typeInfoService.getBaseMapper().insert(tname);
        if (result == -1) {
            return new ResultVO(510, "数据请求验证失败");
        }
        if(result > 0) {
            return new ResultVO(200, "添加成功");
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
     * 根据tno删除商品类型
     * @param tno 商品类型编号
     * @return
     */
    @DeleteMapping("/delByTno")
//    @ResponseBody
    public  ResultVO delByTno(@RequestParam Integer tno) {
        boolean r = typeInfoService.removeById(tno);
        if (r) {
            return new ResultVO(200, "删除成功");
        }
        return new ResultVO(505, "删除失败");
    }

    /**
     * 根据tno修改商品类型
     * @param typeInfo 商品类型编号
     * @return
     */
    @PutMapping("/updateById")
    public ResultVO update(TypeInfo typeInfo) {
//        TypeInfo typeInfo1 = typeInfoService.getBaseMapper().selectById(typeInfo.getTno());
//        int result = typeInfoService.update(typeInfo1);
//        if(result > 0) {
//            return new ResultVO(200, "修改成功");
//        }
//        return new ResultVO(500, "修改失败");
//    }
        if (typeInfoService.updateById(typeInfo)) {
            return new ResultVO(200, "修改成功");
        }
        return new ResultVO(501, "修改失败");
    }

    /**
     * 模糊查询商品类型
     * @param
     * @return
     */
    // 模糊查询
    @GetMapping("/")



}
