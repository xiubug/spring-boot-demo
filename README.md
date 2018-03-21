# spring boot标准参考教程（alpha）
spring boot基础教程，由浅入深，一步一步学习spring boot，最后学到的不单单是基础！

## 导论

### 简介

Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，
从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域（rapid application development）
成为领导者的。

在以前的spring项目中，都会面对大量繁琐的配置，使用的时候基本上都是大量的复制黏贴。而Spring Boot 则能让我们在不需要过多的配置下，
轻松快速地搭建Spring Web应用，开箱即用，没有代码生成，也无需XML配置，从而快速使用spring框架。

### Spring Boot安装

Spring Boot可以跟常用Java开发工具（Eclipse，IntelliJ等）一起使用或安装成一个命令行工具。不管怎样，你都需要安装[Java SDK v1.6 ](http://www.java.com/)或更高版本。在开始之前，
你需要检查下当前安装的Java版本：
```shell
$ java -version
```
**注**：尽管Spring Boot兼容Java 1.6，如果可能的话，你应该考虑使用Java最新版本。

对于java开发者来说，使用Spring Boot就跟使用其他Java库一样，只需要在你的classpath下引入适当的spring-boot-*.jar文件。Spring Boot不需要集成任何特殊的工具，所以你可以使用任何IDE或文本编辑器；同时，Spring Boot应用也没有什么特殊之处，你可以像对待其他Java程序那样运行，调试它。

尽管可以拷贝Spring Boot jars，但还是建议使用支持依赖管理的构建工具，比如Maven或Gradle。

## 参考链接

### [Spring Boot 系列（一）快速入门](http://blog.csdn.net/sinat_14982831/article/details/75126936)
