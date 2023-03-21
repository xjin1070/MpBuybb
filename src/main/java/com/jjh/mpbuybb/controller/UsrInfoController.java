package com.jjh.mpbuybb.controller;

import com.jjh.mpbuybb.bean.UsrInfo;
import com.jjh.mpbuybb.service.UsrInfoService;
import com.jjh.mpbuybb.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Slf4j
@Controller
public class UsrInfoController {
    @Resource
    UsrInfoService usrInfoService;

    @RequestMapping("/usrInfo")
    public String indexPage(){
        return "index";
    }

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
//              MD5校验
              System.out.println(DigestUtils.md5Hex(usrInfo1.getPassword()));

              //方便后面的读取
              session.setAttribute("loginUser",usrInfo1);
              return new ResultVO(200,"成功");
          }
            return new ResultVO(510,"失败");
    }


}
