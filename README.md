### 开发环境
- macOS
- IDEA 2020
- Spring Boot 2.4.0

### 踩坑记录
- lombok依赖需要安装IDEA插件

- 程序清单2.2代码部分错误

  ```java
      private List<Ingredient> filterByType(
              List<Ingredient> ingredients, Type type) {
          return ingredients
                  .stream()
                  .filter(x -> x.getType().equals(type))
                  .collect(Collectors.toList());
      }
  ```

  
