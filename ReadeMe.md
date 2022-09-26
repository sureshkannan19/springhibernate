**@Table** : Optional, used only when java class name is different from table name. 

**@Entity** :
 * to mark POJO class as an entity
 * Entity name is used in JPQL, 
      
     by default Class name is Entity name 
     @Entity
     public class Product {}
     (i.e Select * from Product), 
     
     @Entity(name="ProductEntity"
     public class Product {}
     (i.e Select * from ProductEntity)


**Finder Methods** - Spring JPA has provided features, such as without writing a JPQL, desired search operation can be performed by using method name itself. <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords">Click here to Explore</a>