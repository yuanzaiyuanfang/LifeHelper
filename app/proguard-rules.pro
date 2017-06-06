# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#-----------------混淆配置设定------------------------------------------------------------------------
-optimizationpasses 5                                                       #指定代码压缩级别
-dontusemixedcaseclassnames                                                 #混淆时不会产生形形色色的类名
-dontskipnonpubliclibraryclasses                                            #指定不忽略非公共类库
-dontpreverify                                                              #不预校验，如果需要预校验，是-dontoptimize
-ignorewarnings                                                             #屏蔽警告
-verbose                                                                    #混淆时记录日志
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*    #优化
#-applymapping mapping.txt
-keepattributes SourceFile,LineNumberTable

#-----------------不需要混淆第三方类库------------------------------------------------------------------

# ButterKnife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

# support-v4
-dontwarn android.support.v4.**                                             #去掉警告
-keep class android.support.v4.** { *; }                                    #过滤android.support.v4
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment

# baidu
-dontwarn com.baidu.**                                                      #去掉警告
-dontwarn com.baidu.mapapi.**
-keep class com.baidu.** {*;}                                               #过滤BaiduLBS_Android.jar
-keep class vi.com.gdi.bgl.android.**{*;}
-keep class com.baidu.platform.**{*;}
-keep class com.baidu.location.**{*;}
-keep class com.baidu.vi.**{*;}

# pinyin4j
-dontwarn net.soureceforge.pinyin4j.**
-dontwarn demo.**
-keep class net.sourceforge.pinyin4j.** { *;}
-keep class demo.** { *;}

# util
-keep class com.blankj.utilcode.** { *; }
-keepclassmembers class com.blankj.utilcode.** { *; }
-dontwarn com.blankj.utilcode.**

## sharesdk
-keep class cn.sharesdk.**{*;}
-keep class com.sina.**{*;}
-keep class **.R$* {*;}
-keep class **.R{*;}
-dontwarn cn.sharesdk.**
-dontwarn **.R$*

-keep class m.framework.**{*;}
-keep class android.net.http.SslError
-keep class android.webkit.**{*;}
-keep class com.mob.tools.utils
-keep class cn.sharesdk.onekeyshare.theme.classic.EditPage

#ali httpdns 混淆
-keep class com.alibaba.sdk.android.**{*;}
-keep class com.ut.**{*;}
-keep class com.ta.**{*;}

# 个推的混淆
-dontwarn com.igexin.**
-keep class com.igexin.**{*;}
-keep class org.json.** { *; }

#umeng混淆
-keepclassmembers class * {
   public <init>(org.json.JSONObject);
}
-keep public class com.yzyfdf.lifehelper.R$*{
	public static final int *;
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}


-keepattributes *Annotation*

#JSON
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#阿里百川
-keep class * extends java.lang.annotation.Annotation
-keepclasseswithmembernames class * {
    native <methods>;
}
-keep class com.alipay.euler.andfix.**{
    *;
}
-keep class com.taobao.hotfix.aidl.**{*;}
-keep class com.ta.utdid2.device.**{*;}
-keep class com.taobao.hotfix.HotFixManager{
    public *;
}

#bugly
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
-keep class android.support.**{*;}

 #okgo
 -dontwarn com.lzy.okgo.**
 -keep class com.lzy.okgo.**{*;}

 #okrx
 -dontwarn com.lzy.okrx.**
 -keep class com.lzy.okrx.**{*;}

 #okserver
 -dontwarn com.lzy.okserver.**
 -keep class com.lzy.okserver.**{*;}

 #okhttp
 -dontwarn okhttp3.**
 -keep class okhttp3.**{*;}

 #okio
 -dontwarn okio.**
 -keep class okio.**{*;}

 -dontwarn javax.annotation.**
 -dontwarn javax.inject.**

 # RxJava RxAndroid
 -dontwarn sun.misc.**
 -keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
     long producerIndex;
     long consumerIndex;
 }
 -keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
     rx.internal.util.atomic.LinkedQueueNode producerNode;
 }
 -keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
     rx.internal.util.atomic.LinkedQueueNode consumerNode;
 }

 #--------glide 系列--------
 -keep public class * implements com.bumptech.glide.module.GlideModule
 -keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
   **[] $VALUES;
   public *;
 }

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature
# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class rjs.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson

##---------------End: proguard configuration for Gson  ----------

#-----------------不需要混淆系统组件等-------------------------------------------------------------------
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

#---------------过滤掉自己编写的实体类--------------------------------------------------------
-keep class com.yzyfdf.lifehelper.bean.** { *; }  ##这里需要改成解析到哪个  javabean

-keep class com.yzyfdf.lifehelper.ui.cookbook.model.** { *; }
-keep class com.yzyfdf.lifehelper.ui.cookbook.presenter.** { *; }

-keep class com.yzyfdf.lifehelper.ui.other.model.** { *; }
-keep class com.yzyfdf.lifehelper.ui.other.presenter.** { *; }

-keep class com.yzyfdf.lifehelper.ui.read.activity.** { *; }
-keep class com.yzyfdf.lifehelper.ui.read.model.** { *; }
-keep class com.yzyfdf.lifehelper.ui.read.presenter.** { *; }

-keep class com.jaydenxiao.common.** { *; }

#----------------保护指定的类和类的成员，但条件是所有指定的类和类成员是要存在------------------------------------
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Kotlin
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}

-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}


#微信
-keep class com.tencent.mm.opensdk.** {
   *;
}
-keep class com.tencent.wxop.** {
   *;
}
-keep class com.tencent.mm.sdk.** {
   *;
}