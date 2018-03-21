# Spring 标准参考教程（alpha）

## 注解

### @Controller定义一个Controller控制器

@Controller用于标记在一个类上，使用它标记的类就是一个SpringMVC Controller对象。分发处理器将会扫描使用了该注解的类的方法，
并检测该方法是否使用了@RequestMapping注解。@Controller只是定义了一个控制器类，而使用@RequestMapping注解的方法才是真正
处理请求的处理器。

单单使用@Controller标记在一个类上还不能真正意义上的说它就是SpringMVC的一个控制器类，因为这个时候Spring还不认识它。拿
MyController来举一个例子：

```java
@Controller
public class MyController {
  @RequestMapping("/showView")
  public ModelAndView showView() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("viewName");
    modelAndView.addObject(" 需要放到 model 中的属性名称 ", " 对应的属性值，它是一个对象 ");
    return modelAndView;
  }
}
```
这个时候有两种方式可以把MyController交给Spring管理，好让它能够识别我们标记的@Controller。

第一种方式是在SpringMVC的配置文件中定义MyController的bean对象。

```xml
<bean class="com.host.app.web.controller.MyController"/>
```

第二种方式是在SpringMVC的配置文件中告诉Spring该到哪里去找标记为@Controller的Controller控制器。

```xml
<context:component-scan base-package = "com.host.app.web.controller">
  <context:exclude-filter type = "annotation" expression = "org.springframework.stereotype.Service" />
</context:component-scan>
```

>注：上面 context:exclude-filter标注的是不扫描@Service标注的类。

### 使用@RequestMapping来映射Request请求与处理器

可以使用@RequestMapping来映射URL到控制器类，或者是到Controller控制器的处理方法上。当@RequestMapping标记在Controller
类上的时候，里面使用@RequestMapping标记的方法的请求地址都是相对于类上的@RequestMapping而言的；当Controller类上没有标记
@RequestMapping注解时，方法上的@RequestMapping都是绝对路径。这种绝对路径和相对路径所组合成的最终路径都是相对于根路径“/”而言的。

### @ResponseBody

该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。

使用时机：返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用；

### @RestController

@RestController = @Controller + @ResponseBody

是2个注解的合并效果，即指定了该controller是组件，又指定方法返回的是String或json类型数据，不会解决成jsp页面，注定不够灵活，
如果一个Controller即有SpringMVC返回视图的方法，又有返回json数据的方法即使用@RestController太死板。
灵活的作法是：定义controller的时候，直接使用@Controller，如果需要返回json可以直接在方法中添加@ResponseBody

### @SpringApplication

Spring Boot的SpringApplication类，用以启动一个Spring应用，实质上是为Spring应用创建并初始化Spring上下文。其中，第一个
参数MySpringConfigurationApp.class就是Spring应用的入口类；第二个参数args是启动Spring应用的命令行参数