# Introduction #

对比Connect-It已有的功能,提出不同于相同的地方


**Details**

  1. Scheduler启动某个connector开始produce给mapping, 或者由Service Connector监听到request启动mapping.而这种概念在最初用户开始编写scenario时就要设置.
  1. Collection to Collection: 对于节点命名过长, 能否提供个解决方案, 比如collection是a.b.c.d, d下面有id, CIT里面要[a.b.c.d.id], 能否直接写成$id