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

- 依赖问题，jdbc由于个人原因导入`org.springframework`的jdbc，导致无法自动注入。。

  ```
  错误：
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>5.2.10.RELEASE</version>
  </dependency>
  正确：
  <dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-jdbc</artifactId>
  </dependency>
  ```
  
- 程序清单3.7代码没有为`design`分配变量，代码报错

  ```
      @GetMapping
      public String showDesignForm(Model model) {
          List<Ingredient> ingredients = new ArrayList<>();
          ingredientRepo.findAll().forEach(i -> ingredients.add(i));
  
          Type[] types = Ingredient.Type.values();
          for (Type type : types){
              model.addAttribute(type.toString().toLowerCase(),
                      filterByType(ingredients, type));
          }
          model.addAttribute("design", new Taco());
          return "design";
      }
  ```

- 程序清单3.16声明JPA实体报错，直接全为公有有参和无参

  ```
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Entity
  public class Ingredient {
  
      @Id
      private String id;
  
      private String name;
  
      private Type type;
  
      public static enum Type {
          WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
      }
  
  }
  ```

- Hibernate默认将enum类型映射为number，枚举类型变量需要增加`@Enumerated`注解

  ```
      @Enumerated(EnumType.STRING)
      private Type type;
  ```

- bug

  ```
  https://github.com/habuma/spring-in-action-5-samples/issues/54
  ```

  

