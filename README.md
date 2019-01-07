# Uchat_Refactoring
[采用Android-CleanArchitecture 架构](https://github.com/android10/Android-CleanArchitecture)
---
个人开发的聊天应用，具有手机号验证码登录,聊天,二维码扫一扫加好友,以及上传皮肤,下载皮肤功能,图片存储在云对象服务器,数据存储在搭建的云服务器上.
重构后为MVP模式，采用了RxJava+Dagger2+Retrofit开发框架主要的第三方功能库：腾讯云Sdk(IM功能),Glide(图片加载),Greendao(数据库),ZXing(二维码),Retrofit(网络库),Rxjava(异步任务)
---
### 主界面展示(主要运用了自定义recyclerview 实现OverScroll 和加载的功能)
![](http://wx2.sinaimg.cn/large/e7d0444fly1fyx44av75vg20hs0qoqv6.gif)
### 登录界面（手机号登录 腾讯TLS系统账号）
![](http://wx2.sinaimg.cn/large/e7d0444fly1fyxdtnbsn0g20qo0hse81.gif)
### 皮肤新建功能(主要数据上传服务器)
![](http://wx4.sinaimg.cn/large/e7d0444fly1fyxg2pjcmgg20qo0hse84.gif)
### 皮肤切换功能(主要数据从服务器获取)
![](http://wx3.sinaimg.cn/large/e7d0444fly1fyxg2uo05eg20qo0hshdw.gif)
### 二维码添加好友(Zxing)
![](http://wx3.sinaimg.cn/large/e7d0444fly1fyxdtlfnqzg20qo0hsu0y.gif)
