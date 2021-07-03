[toc]

[中文版](./README.md)

# Introduce

This is a simple config library of Java.

# Feature
1. Simple and easy
2. Bind segment to POJO like Spring Configuration
3. Support data source
    - local file of json
    - local file of yaml

# Sample of usage

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
- [ ] Release to mvn repository
- [ ] Support bind checker
- [ ] Support jackson readTree from diff source
- [ ] More doc
- [ ] More test unit

## Version 0.3
- [ ] Support read config file path from ENV
- [ ] Change dev, project etc simply


# reference
[cfg4j](https://github.com/cfg4j/cfg4j)
