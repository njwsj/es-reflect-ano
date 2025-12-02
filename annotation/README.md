## 注解
### 自定义注解
- 可以在类、方法、属性、参数上使用
- 可以在注解中定义属性，属性值可以有默认值  
    public 属性类型 属性名称() default 默认值;  
    没有默认值的属性，必须在使用注解时指定属性值  
    如果只有一个value属性 那么在使用注解时可以不写属性名
### 注解的本质
- 本质是一个接口，继承了Annotation接口
- @注解(...) 实际上就是一个实现类对象，实现了该注解及Annotation接口
### 元注解
- 为修饰注解的注解
-  @Target声明被修饰的注解只能在哪些位置使用
- @Retention声明被修饰的注解在哪些生命周期有效
### 注解的解析

- 就是判断类/方法/成员变量上是否有注解，并且把注解的内容解析出来
- Class、Method、Field、Constructor都实现了AnnotatedElement接口，使得他们有解析注解的能力
- getDeclaredAnnotations()获取类/方法/成员变量上的注解
- getDeclaredAnnotation() 获取类/方法/成员变量上的指定注解
- isAnnotationPresent() 判断类/方法/成员变量上是否有指定注解
- 要是想获取方法上的注解内容 需要通过反射获取类的字节码类class 然后获取方法

### 注解的应用
- AnnotationTest