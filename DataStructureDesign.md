**lumens 数据结构的设计**

  * 节点种类:Format和Data
    1. Format:定义了数据类型(Type)，表达方式(Form)。
    1. Data:表达具体的数据值。

  * 节点的表达方式(Form)及分类：
    1. FIELD:一个数据结构的叶子节点称为field
    1. STRUCT:一个复合由field和struct组成的非重复数据节点称为struct
    1. ARRAY:一个复合由field和struct组成的可重复的数据节点称为array，array包含item。它的概念和编程语言的数组一样。一个ARRAY节点表示它可以包含不定数量的item，item的结构由ARRAY本身决定。

  * 节点的数据类型(Type)
    1. SHORT
    1. INT
    1. LONG
    1. FLOAT
    1. DOUBLE
    1. BINARY
    1. DATE
    1. STRING

  * Transform
    1. TransformRule:订制数据如何从源映射(mapping)到目标的规则
    1. TransformRuleSet:多个Rule的集合可以顺序执行，也可以并发执行，取决于具体情况由用户决定
    1. TransformProcessor:具体执行数据的计算，根据一个Rule把数据从源数据结构放到目标数据结构