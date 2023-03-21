# MpBuybb
微信小程序



前端：微信小程序+后台

后端：SpringBoot框架+Mybatis-Plus框架+MySQL数据库

数据库：MySQL

# 注: 驼峰命名法每个单词首字母大写，下划线命名法每个单词之间用下划线连接，如果命名出问题了会出现奇奇怪怪的bug

## 2. 项目接口

### 2.1. 用户数据库(usr_info)
### 登陆相关接口

| 名称        | 接口                               | 返回内容     | 描述                                       |
|-----------|----------------------------------|----------|------------------------------------------|
| 登录        | post:localhost:8080/login        | Result对象 | 用户登录（~~可选MD5校验~~）                        |
| 获取登录id的信息 | post:localhost:8080/getById/{id} | Result对象 | 获取登陆者id的所有信息（获取其他人的也可以，这里没设置拦截器，校验等安全设置） |


### 2.2. type_info数据库

| 名称          | 接口                                        | 返回内容     | 描述                              |
|-------------|-------------------------------------------|----------|---------------------------------|
| 获取所有内容      | get:localhost:8080/type/findAll           | Result对象 | 得到type_info数据库所有信息              |
| 添加商品类型      | post:localhost:8080/type/add              | Result对象      | 添加商品名称，tno自增，status状态默认0未上架     |
| 修改商品信息      | put:localhost:8080/type/updateByTno       | Result对象      | 更新type_info数据库中任意信息（可以更新status） |
| 删除商品信息      | delete:localhost:8080/type/delByTno/{tno} | Result对象      | 删除商品类型(tno)                     |
| 根据tno查询商品类型 | put:localhost:8080/type/findByTno/{tno}   | Result对象      | 无                               |

[//]: # (| 更新员工         | put:localhost:8080/emp                       | Result对象      | 通过json数据更新员工                |)

[//]: # (| 普通分页查询       | get:localhost:8080/emp/1/2                   | Result对象      | 1代表页数，2代表每页的条数              |)

[//]: # (| 分页查询和多条件模糊查询 | get:localhost:8080/emp/1/2?name=0&position=员 | Result对象      | 获取名字中有0和职位中有0的所有的员工         |)



### 2.3. 商品数据库(product_info)

| 名称          | 接口                                         | 返回内容     | 描述                                 |
|-------------|--------------------------------------------|----------|------------------------------------|
| 获取所有内容      | get:localhost:8080/productInfo/findAllProduct | Result对象 | 得到product_info数据库所有信息              |
| 添加商品      | post:localhost:8080/productInfo/addProduct         | Result对象      | 添加商品名称，~~tno自增~~，status状态默认0未上架    |
| 修改商品信息      | put:localhost:8080/productInfo/updateProduct       | Result对象      | 更新product_info数据库中任意信息（可以更新status） |
| 删除商品信息      | delete:localhost:8080/productInfo/deleteProduct/{id} | Result对象      | 根据商品号(pno)删除商品类型                   |


