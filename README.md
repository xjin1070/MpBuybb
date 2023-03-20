# MpBuybb
微信小程序



前端：微信小程序+后台

后端：SpringBoot框架+Mybatis-Plus框架+MySQL数据库

数据库：MySQL


## 2. 项目接口

### 2.1. type_info数据库

| 名称           | 接口                                   | 返回内容     | 描述                            |
|--------------|--------------------------------------|----------|-------------------------------|
| 获取所有内容       | get:localhost:8080/type/findAll      | Result对象 | 得到type_info数据库所有信息            |
| 添加商品类型       | post:localhost:8080/type/add         | Result对象      | 添加商品名称，tno自增，status状态默认0未上架   |
| 修改商品信息       | put:localhost:8080/type/updateByTno  | Result对象      | 更新type_info数据库中任意信息（包括status） |
| 删除员工         | delete:localhost:8080/delByTno/{tno} | Result对象      | 删除商品类型                        |

[//]: # (| 更新员工         | put:localhost:8080/emp                       | Result对象      | 通过json数据更新员工                |)

[//]: # (| 普通分页查询       | get:localhost:8080/emp/1/2                   | Result对象      | 1代表页数，2代表每页的条数              |)

[//]: # (| 分页查询和多条件模糊查询 | get:localhost:8080/emp/1/2?name=0&position=员 | Result对象      | 获取名字中有0和职位中有0的所有的员工         |)


