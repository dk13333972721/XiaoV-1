# XiaoV
微信群秘书机器人。
+ 组件化：支持各个群设置不同的功能及差异化参数。
+ 可拓展：继承Customized或ClockIn基类即可实现更多差异化功能开发；

# 支持功能
+ 步数打卡；
+ 运动打卡；
+ 作息打卡；
+ 每日反思打卡；
+ 周报；

# 怎么使用
+ 下载项目源码
+ 修改config类，对指定群进行组件配置
+ 编译成jar包
+ 命令行下java -jar xxx.jar运行即可。

注意:
+ 使用前记得先把要做机器人的微信号拉进指定群；
+ 老微信号才有微信接口权限，新微信号没微信接口权限故没法做机器人；

# 项目入口
配置类：/src/main/java/org/androidtest/xiaoV/Config.java
主入口：/src/main/java/org/androidtest/xiaoV/Main.java

# 使用截图
![](https://github.com/shinyvince/XiaoV/blob/master/src/main/resources/example1.jpg)

![](https://github.com/shinyvince/XiaoV/blob/master/src/main/resources/example2.jpg)

![](https://github.com/shinyvince/XiaoV/blob/master/src/main/resources/example3.jpg)
![](https://github.com/shinyvince/XiaoV/blob/master/src/main/resources/example4.jpg)
![](https://github.com/shinyvince/XiaoV/blob/master/src/main/resources/example5.jpg)
![](https://github.com/shinyvince/XiaoV/blob/master/src/main/resources/example6.jpg)
![](https://github.com/shinyvince/XiaoV/blob/master/src/main/resources/example7.jpg)
![](https://github.com/shinyvince/XiaoV/blob/master/src/main/resources/example8.jpg)
![](https://github.com/shinyvince/XiaoV/blob/master/src/main/resources/example9.jpg)

# 作者
Vince蔡培培
wx:shinyvince2

# 依赖项目
使用了https://github.com/yaphone/itchat4j 的微信API封装。
并修复了该项目的若干BUG，并进行了拓展；

# TODO解坑又无关紧要的代码
+ 有的组件里的实现代码为旧代码复制粘贴进来，没改逻辑，不够精美，虽然不影响执行，但后面可以细节优化改善下；
+ 步数打卡、运动打卡的isDiff功能后面可能埋坑，后续有新需求的话，需要改下这块代码；
+ 组件里关于时间判断这块，用的是整型，比如4点，预期想表达的是0400，实际表达出来的是400，这块代码后面需要改善；

# 开源协议
GPL开源协议

# 问题和建议
本项目长期更新、维护，功能不断扩展与完善中，欢迎star。

项目使用过程中遇到问题，或者有好的建议，欢迎随时反馈。

# 最后说一句
本人自由散漫，开发的功能目的是解放自己劳动力，故后面功能全从自身出发开发。文档也不会专心写。

