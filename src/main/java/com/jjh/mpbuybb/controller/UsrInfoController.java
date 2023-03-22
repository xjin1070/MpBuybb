package com.jjh.mpbuybb.controller;

import com.jjh.mpbuybb.bean.UsrInfo;
import com.jjh.mpbuybb.service.UsrInfoService;
import com.jjh.mpbuybb.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Slf4j
//@Controller
@RestController
public class UsrInfoController {
    @Resource
    UsrInfoService usrInfoService;

    @RequestMapping("/usrInfo")
    public String indexPage(){
        return "index";
    }

    /**
     * 登录
     * @param usrInfo 用户信息
     * @param session session
     * @return 返回结果
     */
    @PostMapping("/login")
    @ResponseBody
    public ResultVO checkLogin( UsrInfo usrInfo, HttpSession session){
          Integer id = usrInfo.getId();
          if (id == null){
              return new ResultVO(510,"没有数据id");
          }
          UsrInfo usrInfo1 = usrInfoService.getById(id);
          if (usrInfo1 == null){
              return new ResultVO(510,"当前员工账号不存在");
          }
//          if (usrInfo1.getId().equals(usrInfo.getId()) && DigestUtils.md5Hex(usrInfo.getPassword()).equals(usrInfo1.getPassword()))
        if (usrInfo1.getId().equals(usrInfo.getId()) && usrInfo.getPassword().equals(usrInfo1.getPassword()))
        {
//              MD5校验没写
              System.out.println(DigestUtils.md5Hex(usrInfo1.getPassword()));

              //方便后面的读取
              session.setAttribute("loginUser",usrInfo1);
              return new ResultVO(200,"成功",true,usrInfo1);
          }
            return new ResultVO(510,"失败");
    }


    /**
     * 返回该id的信息
     */
    @GetMapping("/getById/{id}")
    public ResultVO getById(@PathVariable Integer id){
        return new ResultVO(200,"获取成功",true,usrInfoService.getById(id));
    }
}
