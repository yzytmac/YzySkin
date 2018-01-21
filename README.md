# YzySkin
**网易云音乐换肤框架实现**  
- 如果觉得有用，不吝啬在右上角给我一个Star。谢谢！！  
![](https://raw.githubusercontent.com/yzytmac/yzytmac.github.io/master/images/star.png)  
使用步骤  
1、在app目录中创建一个aars的文件夹  
2、将skinlibrary.aar复制进去  
3、在app的build.gradle文件中进行配置  
```
android{
    repositories {
        flatDir {
            dirs'aars' 
        }
    }
}
dependencies {
       compile(name:'skinlibrary', ext:'aar')
}
```
4、需要换肤的页面继承SkinActivity  
5、将皮肤包skin.apk复制到手机  
6、调用YzyChangeSkin.getInstance().changeSkin(context, skinPath);进行换肤  
**注意**  
1、所有的颜色、图片资源都是引用资源，不能在xml文件中写死，否则无法更换  
2、皮肤包也是一个apk，该包内只需要有引用资源的同名的图片、同名的颜色引用即可。  
如：  
按钮背景颜色为@color/bt_bg,那么在app/src/main/res/values/colors.xml中就会有一个bt_bg的颜色值对应  
在皮肤包中也要在colors.xml中有bt_bg这个item，只是颜色值不同.如果没有皮肤包或皮肤包中没有找到相对应的引用资源，将会使用原始值  
3、有任何疑问欢迎发邮件到yzytmac@163.com 欢迎提交代码   

 

