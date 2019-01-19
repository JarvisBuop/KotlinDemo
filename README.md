# KotlinDemo for kotlin study

&#x1F684;&#x1F683;&#x1F683;&#x1F683;&#x1F683;&#x1F683;&#x1F683;&#x1F409; <br/>
是不是很好玩 ->[emoji转义字符](https://apps.timwhitlock.info/emoji/tables/unicode)

:yum::yum::yum::yum::yum::yum::yum: <br/>
另外还有markdown emoji -> [emoji for markdown](https://www.webfx.com/tools/emoji-cheat-sheet/)

**约束布局**

>tips

约束布局中使用`ViewStub`导入时,使用的布局时`ConstraintLayout`作为根布局时会出现问题;
就是底部的布局不会消失;

**koltin**

>kit中存有`layout布局`供app使用这种情况

会出现问题,layout的id和kotlin框架中出现冲突,不建议在lib中放layout提供给module使用;
跟组件化中类似,也不建议这样做,R文件会出现多份;   建议单独的module中使用单独的layout;
lib中的layout只用于lib中;不跨模块使用layout文件;
