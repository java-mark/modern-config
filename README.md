[toc]

# 介绍

一个简单有效的配置文件库，基于jackson进行了抽象封装，三行快速使用配置文件。
在使用方式上参考了spring configuration。

# Feature
1. 简单，容易使用
2. 仿Spring对配置文件的操作，能够对某一节绑定对象。


# 样例

## IMPORT

```mvn
// todo
```

## Example code

```java
class SimpleConfigProviderExample {
    static class Foo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        YamlFileConfigSource yamlFileConfigSource = 
                new YamlFileConfigSource("src/test/resources/research/jackson.yaml");
        SimpleConfigProvider provider = new SimpleConfigProvider(yamlFileConfigSource);
        Foo res = provider.bind("foo", Foo.class);
        return 0;
    }
}
```

# TODO

## Version 0.2
- [ ] 发布到maven镜像仓库
- [ ] 支持bind checker
- [ ] 支持jackson config source(支持url等数据源)

## Version 0.3
- [ ] 支持环境变量设置配置文件
- [ ] 支持dev,product等环境切换


# 参考
[cfg4j](https://github.com/cfg4j/cfg4j)
