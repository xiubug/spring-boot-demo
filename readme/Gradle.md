# gradle 标准参考教程（alpha）
gradle基础教程，由浅入深，一步一步学习gradle，最后学到的不单单是基础！

#### 在mac上安装gradle

##### 第一步， 就是先download最新版本的gradle，网址如下：

[gradle](http://gradle.org/gradle-download/)

然后将下载下来的zip包放解压到本地任意的路径上，

例如，我本地则安装在 /Users/apple/Documents/jobs/javas/gradle-4.4

1、打开Mac上的“终端”，输入以下命令,将gradle的bin目录添加至到环境变量中:

```shell
$ vi ~/.bash_profile
```

2、打开.bash_profile 文件窗口依次输入以下命令：

i （进入vi的编辑模式，添加如下配置）

export GRADLE_HOME=/Users/apple/Documents/jobs/javas/gradle-4.4

export PATH=$PATH:$GRADLE_HOME/bin

3、输入完毕，按esc键退出vi的编辑模式，

输入“:”(冒号)进入最后行模式，

输入 wq 保存并退出vi

4、通过以下命令来查看是否安装成功：

gradle -version  

如果输出以下的gradle版本信息就表示已经安装成功了：


------------------------------------------------------------
Gradle 4.4
------------------------------------------------------------

Build time:   2017-12-06 09:05:06 UTC
Revision:     cf7821a6f79f8e2a598df21780e3ff7ce8db2b82

Groovy:       2.4.12
Ant:          Apache Ant(TM) version 1.9.9 compiled on February 2 2017
JVM:          1.8.0_151 (Oracle Corporation 25.151-b12)
OS:           Mac OS X 10.13.1 x86_64


Spring Boot兼容Gradle 1.12或更高版本。如果本地没有安装Gradle，你可以参考[www.gradle.org](http://www.gradle.org/)上的指南。

Spring Boot的依赖可通过groupId `org.springframework.boot`来声明。通常，你的项目将声明一个或多个[“Starter POMs”](../III. Using Spring Boot/13.4. Starter POMs.md)依赖。Spring Boot提供了一个很有用的[Gradle插件](../VIII. Build tool plugins/59. Spring Boot Gradle plugin.md)，可以用来简化依赖声明，创建可执行jars。

**注**：当你需要构建项目时，Gradle Wrapper提供一种给力的获取Gradle的方式。它是一小段脚本和库，跟你的代码一块提交，用于启动构建进程，具体参考[Gradle Wrapper](www.gradle.org/docs/current/userguide/gradle_wrapper.html)。

下面是一个典型的`build.gradle`文件：

```gradle
buildscript {
    repositories {
        jcenter()
        maven { url "http://repo.spring.io/snapshot" }
        maven { url "http://repo.spring.io/milestone" }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.4.0.BUILD-SNAPSHOT")
    }
}

apply plugin: 'java'
apply plugin: 'spring-boot'

jar {
    baseName = 'myproject'
    version =  '0.0.1-SNAPSHOT'
}

repositories {
    jcenter()
    maven { url "http://repo.spring.io/snapshot" }
    maven { url "http://repo.spring.io/milestone" }
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

```