# springhibernate
In this project, have explored spring data jpa with hibernate implementation.
-----------------------------------------------------------------------------
**Fundamentals : **
**@Table** : Optional, used only when java class name is different from table name. 
**@Entity** :
 * to mark POJO class as an entity
 * Entity name is used in JPQL, 
      
     by default Class name is Entity name 
     @Entity
     public class Product {}
     (i.e Select t from Product t), 
     
     @Entity(name="ProductEntity"
     public class Product {}
     (i.e Select t from ProductEntity t)
------------------------------------------------------------------------------
**Finder Methods** - Spring JPA has provided features, such as without writing a JPQL, desired search operation can be performed by using method name itself.
* Refer : <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationTests.java">Few examples</a>
* Refer : <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords">Spring Documentation. Click here to Explore</a>

