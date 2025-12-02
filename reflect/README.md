## 反射学习
### 获取构造器
- getDeclaredConstructors() 获取所有构造器
- getConstructors() 获取所有的构造器---public
- getDeclaredConstructor(Class<?>... parameterTypes) 获取指定参数的构造器
- getConstructor(Class<?>... parameterTypes) 获取指定参数的构造器--public
### 反射获取构造器 新建对象
- newInstance(Object... initargs) 创建对象
- constructor.setAccessible(boolean); 忽略访问权限修饰符
### 反射获取成员变量 赋值与取值
- getFields() 获取所有public字段
- getDeclaredFields() 获取所有字段
- getField(String name) 获取指定字段--public
- getDeclaredField(String name) 获取指定字段  
- set(Object obj, Object value) 赋值
- get(Object obj) 获取值  
  **赋值和获取值的时候 需要setAccessible(true) 忽略访问权限修饰符**
