# couponSystem
Java分布式优惠券系统后台

## 技术分层：

1. 框架层：
   1. Spring Boot：自动配置，内置Tomcat
2. 存储层：
   1. MySQL：
   2. HBase：列族式分布式数据库
   3. Redis：解决MySQL的IO瓶颈
3. 消息队列
   1. Kafka



![image-20200118094048245](D:\Develop\Coding\couponSystem\md_data\技术分层.png)

## 需求分析

1. ### 什么是卡包

   卡券收集、聚合类的应用

2. ### 包含哪些子系统

   1. 商户投放子系统

      提供给商户，用于商家注册、卡券的投放、卡券核销。

      **怎样接入平台 ** 

      ​	商家注册，提供商户接口

      |       字段名称       |     含义     |   备注   |
      | :------------------: | :----------: | :------: |
      |         name         |   商户名称   | 全局唯一 |
      |       logo_url       |   商户logo   |          |
      | business_license_url | 商户营业执照 |          |
      |        phone         | 商户联系电话 |          |
      |       address        |   商户地址   |          |

      ​	优惠券投放，优惠券接口

      |  字段名称  |        含义        |   备注   |
      | :--------: | :----------------: | :------: |
      |     id     |     所属商户id     |          |
      |   title    |     优惠券标题     | 全局唯一 |
      |  summary   |     优惠券摘要     |          |
      |    desc    |   优惠券详细信息   |          |
      |   limit    |    最大个数限制    |          |
      | has_token  | 优惠券是否有token  |          |
      | background |    优惠券背景色    |          |
      |   start    | 优惠券开始使用时间 |          |
      |    end     | 优惠券结束使用时间 |          |

   2. 用户应用子系统

      优惠券领取存储、使用、查看库存、评论

      ![image-20200127145357564](D:\Develop\Coding\couponSystem\md_data\用户应用子系统.png)

3. ### 优惠券使用方法

   1. 展示型
   2. 兑换型
   3. token 核销型：类似优惠券密码

4. ### 卡包应用的扩展

   1. 存储纪念型卡券
   2. 证件信息
   3. 银行卡
   4. ····

## 技术架构



## 开整！
