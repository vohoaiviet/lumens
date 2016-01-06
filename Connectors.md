# Introduction #

临时想到的


**Details**

  1. connector与server才有http rest ssl连接, 采用注册到引擎server
  1. connector分为模板与实例(favorate)
  1. post process failed处理增加rollback接口,由connector实现,引擎调度
  1. 把connect-it service和data generator整合.最好做到scheduling只管理这个connector, 即使database和xml也由这个connector出发. 就是设计一个用户很好理解的起点. 参照yahoo pipe

**Connector**

  1. mail connector can support multi-account/profile