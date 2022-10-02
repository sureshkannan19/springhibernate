# springhibernate
In this project, have explored spring data jpa with hibernate implementation.

**Note:**

**MySQL** is used for database operation. If MySQL setup is **not present in your machine**, please feel free to use **H2 database** by changing the profile --> **@ActiveProfiles** from "dev" to "int" in all test files, in this <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/" style="text-decoration:none;">folder</a>

----------------------------------------------------------------------------------------------
**Finder Methods** - Spring JPA has provided features, such as without writing a JPQL, desired search operation can be performed by using method name itself.
* Refer : <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationTests.java" style="text-decoration:none;">Few examples</a>
* Refer : <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords" style="text-decoration:none;">Spring Documentation</a>

----------------------------------------------------------------------------------------------
**Cache :** 
* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationFirstLevelCacheTest.java" style="text-decoration:none;">FirstLevelCache</a>

* For <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationSecondLevelCacheTest.java" style="text-decoration:none;">SecondLevelCache</a>, explore <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/main/resources/application.properties" style="text-decoration:none;">application.properties</a> and <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/main/resources/ehcache.xml" style="text-decoration:none;">ehcache.xml</a>

* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationSpringCacheTest.java" style="text-decoration:none;">Spring Cache</a>

Note : To show the difference between First and SecondLevelCache, second level cache is disabled in
<a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationFirstLevelCacheTest.java" style="text-decoration:none;">FirstLevelCache</a> using **--spring.jpa.properties.hibernate.cache.use_second_level_cache=false**
------------------------------------------------------------------------------------------------
<a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/bank/BankApplicationTests.java" style="text-decoration:none;">Pageable and Sorting</a>

------------------------------------------------------------------------------------------------
**Inheritance Strategy :- **

* ** Single :**  Entities used are Payment, Card, Check and <a href="https://github.com/sureshbabk19698/springhibernate/tree/main/src/test/java/com/sk/hibernate/payment" style="text-decoration:none;">Test file</a>


------------------------------------------------------------------------------------------------
** Miscellaneous : **
* <a href="https://github.com/sureshbabk19698/springhibernate/tree/main/src/main/java/com/sk/hibernate/entity" style="text-decoration:none;">Entities</a>
* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/main/resources/schema.sql" style="text-decoration:none;">schema.sql</a>
* <a href="https://github.com/sureshbabk19698/springhibernate/tree/main/src/test/resources/db/data" style="text-decoration:none;">Test datas</a>