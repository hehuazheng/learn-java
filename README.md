# java使用

Pluggable Annotation Processing API
[参考](https://liuyehcf.github.io/2018/02/02/Java-JSR-269-%E6%8F%92%E5%85%A5%E5%BC%8F%E6%B3%A8%E8%A7%A3%E5%A4%84%E7%90%86%E5%99%A8/)

java instrumentation（javaagent）
transform方法中，判断类名
MyClass.class.getCanonicalName().replace('.', '/').equals(className)
这样的代码会失效， 需要使用常量

[参考一](https://rmannibucau.metawerx.net/post/your-first-javaagent)

- 修改启动命令
```
java -jar -javaagent:target/javaagent-1.0-SNAPSHOT.jar target/javaagent-1.0-SNAPSHOT.jar
``` 

二 动态加载
