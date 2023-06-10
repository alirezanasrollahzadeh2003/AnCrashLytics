# AnCrashLytics

<img src="https://github.com/alirezanasrollahzadeh2003/AnCrashLytics/blob/master/logo-no-background.png" alt="An CrashLytics">

**A fully customized service for analyzing and tracking errors in mobile applications, independent of any external service.**

<h1>How To Use</h1>

Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories

```
allprojects {
    repositories {
    	...
    	maven { url 'https://jitpack.io' }
    }
} 
```

Add the dependency
```
implementation 'com.github.alirezanasrollahzadeh2003:AnCrashLytics:1.0.0'
```

Implementation
```
class AnApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AnCrashLytics(this,baseUrl = "http://192.168.1.53/AlirezaNasrollahzadeh/index.php").init()
    }
}
```

**Uses-Permission**

```
<uses-permission android:name="android.permission.INTERNET"/>
```

**Matched With JetPack Compose And Xml**

# Parameter
Required parameters for backend coding retrieval:

| exception | app_version | android_version |
| ------- | ------- | ------- |

**Here's a simple backend code snippet that you can use:**

php code
```
$exception = $_POST['exception'];
$android_version = $_POST['android_version'];
$app_version = $_POST['app_version'];
```

**Note: PHP has been used as an example, but you can use any backend language**

**My Personal WebSite**

https://alirezanasrollahzadeh.ir

