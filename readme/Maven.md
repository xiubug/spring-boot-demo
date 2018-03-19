# Maven 标准参考教程（alpha）
Maven基础教程，由浅入深，一步一步学习Maven，最后学到的不单单是基础！

## Mac安装、配置Maven

Spring Boot兼容Apache Maven 3.2或更高版本。如果本地没有安装Maven，你可以参考以下指南。

注：在很多操作系统上，可以通过包管理器来安装Maven。OSX Homebrew用户可以尝试brew install maven，Ubuntu用户可以运行sudo apt-get install maven。

Spring Boot依赖使用的groupId为org.springframework.boot。通常，你的Maven POM文件会继承spring-boot-starter-parent工程，
并声明一个或多个依赖。此外，Spring Boot提供了一个可选的Maven插件，用于创建可执行jars。

Mac下安装maven步骤如下：

下载 [Maven](http://maven.apache.org/download.cgi), 我们选择binary zip archive 的类型。等待下载完成解压到某个目录。我这边是/Users/apple/Documents/jobs/javas/apache-maven-3.5.2

打开Terminal,输入以下命令，设置Maven classpath
```shell
$ vi ~/.bash_profile
```

添加maven的路径，将下载好的maven资源引入path 中：
```shell
$ export M2_HOME=/Users/apple/Documents/jobs/javas/apache-maven-3.5.2
$ export PATH=$PATH:$M2_HOME/bin
```

编辑完了，按ESC键 跳到命令模式，
```shell
$ :wq  // 保存文件并退出vi
```

设置path后，使用以下命令使之生效： 
```shell
$ source ~/.bash_profile
```

使用 mvn -v 命令查看mvn命令是否ok
```shell
$ mvn -v
```

下面是一个典型的pom.xml文件：
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <artifactId>myproject</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <!-- Inherit defaults from Spring Boot -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.0.BUILD-SNAPSHOT</version>
    </parent>

    <!-- Add typical dependencies for a web application -->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <!-- Package as an executable jar -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
    <!-- Add Spring repositories -->
    <!-- (you don't need this if you are using a .RELEASE version) -->
    <repositories>
        <repository>
            <id>spring-snapshots</id>
            <url>http://repo.spring.io/snapshot</url>
            <snapshots><enabled>true</enabled></snapshots>
        </repository>
        <repository>
            <id>spring-milestones</id>
            <url>http://repo.spring.io/milestone</url>
        </repository>
    </repositories>
    <pluginRepositories>
        <pluginRepository>
            <id>spring-snapshots</id>
            <url>http://repo.spring.io/snapshot</url>
        </pluginRepository>
        <pluginRepository>
            <id>spring-milestones</id>
            <url>http://repo.spring.io/milestone</url>
        </pluginRepository>
    </pluginRepositories>
</project>
```

注：spring-boot-starter-parent是使用Spring Boot的一种不错的方式，但它并不总是最合适的。有时你可能需要继承一个
不同的父 POM，或只是不喜欢我们的默认配置，那你可以使用import作用域这种替代方案. 