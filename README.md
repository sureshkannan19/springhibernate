# springhibernate
In this project, have explored spring data jpa with hibernate implementation.

**Note:**

**MySQL** is used for database operation. If MySQL setup is **not present in your machine**, please feel free to use **H2 database** by changing the profile --> **--spring.profiles.active=dev** from "dev" to "int" in <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/annotation/SpringBootTestByProfile.java" style="text-decoration:none;">here</a>

----------------------------------------------------------------------------------------------
**Finder Methods** - Spring JPA has provided features, such as without writing a JPQL, desired search operation can be performed by using method name itself.
* Refer : <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationTests.java" style="text-decoration:none;">Few examples</a>
* Refer : <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords" style="text-decoration:none;">Spring Documentation</a>

----------------------------------------------------------------------------------------------
**Types of Query Formation :**

* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/onetoone/NamedAndNativeQueryExecutionTest.java" style="text-decoration:none;">Named And Native Query</a>
* Dynamic query formation using <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/onetoone/DynamicQueryExecutionTest.java" style="text-decoration:none;">JpaSpecificationExecutor</a>

----------------------------------------------------------------------------------------------
**Pagable And Sorting :**

* To Sort results and/or to restrict number of results to be fetched explore <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/bank/BankApplicationTests.java" style="text-decoration:none;">here</a>

------------------------------------------------------------------------------------------------

**Cache :** 
* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationFirstLevelCacheTest.java" style="text-decoration:none;">FirstLevelCache</a>

* For <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationSecondLevelCacheTest.java" style="text-decoration:none;">SecondLevelCache</a>, explore <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/main/resources/application.properties" style="text-decoration:none;">application.properties</a> and <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/main/resources/ehcache.xml" style="text-decoration:none;">ehcache.xml</a>

* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationSpringCacheTest.java" style="text-decoration:none;">Spring Cache</a>

**Note:**     To show the difference between First and SecondLevelCache, second level cache is disabled in <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/product/ProductApplicationFirstLevelCacheTest.java" style="text-decoration:none;">FirstLevelCache</a> using
**--spring.jpa.properties.hibernate.cache.use_second_level_cache=false**
------------------------------------------------------------------------------------------------
**Inheritance Strategy :-**

* **Single :**  Entities used are Payment, Card, Check and <a href="https://github.com/sureshbabk19698/springhibernate/tree/main/src/test/java/com/sk/hibernate/inheritancestrategy/single/IStrategySingleApplicationTest.java" style="text-decoration:none;">Test file</a>

* **TablePerClass :**  Entities used are Car, TataNexon, MaruthiSwift and <a href="https://github.com/sureshbabk19698/springhibernate/tree/main/src/test/java/com/sk/hibernate/inheritancestrategy/tableperclass/IStrategyTablePerClassApplicationTest.java" style="text-decoration:none;">Test file</a>

* **Joined :** Entities used are Student, Boyz, Girlz and <a href="https://github.com/sureshbabk19698/springhibernate/tree/main/src/test/java/com/sk/hibernate/inheritancestrategy/joined/IStrategyJoinedApplicationTest.java" style="text-decoration:none;">Test file</a>

-------------------------------------------------------------------------------------------------
**Component Mapping :** 

Entities used are Address, Customer and <a href="https://github.com/sureshbabk19698/springhibernate/tree/main/src/test/java/com/sk/hibernate/componentmapping/CustomerApplicationTest.java" style="text-decoration:none;">Test file</a>
------------------------------------------------------------------------------------------------
**Difference between save and saveAndFlush :-**

* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/bank/SaveVsSaveAndFlushBasic.java" style="text-decoration:none;">SaveVsSaveAndFlushBasic</a>

* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/bank/SaveVsSaveAndFlushOnCacheEvict.java" style="text-decoration:none;">SaveVsSaveAndFlushOnCacheEvict</a>

* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/bank/SaveVsSaveAndFlushOnRollBack.java" style="text-decoration:none;">SaveVsSaveAndFlushOnRollBack</a>

------------------------------------------------------------------------------------------------
**Relationship Mapping :**

* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/onetomany/UserClientApplicationTest.java" style="text-decoration:none;">OneToMany</a>
* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/manytomany/ProgrammerApplicationTest.java" style="text-decoration:none;">ManyToMany</a>

* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/test/java/com/sk/hibernate/onetoone/LicenseApplicationTest.java" style="text-decoration:none;">OneToOne</a>

-------------------------------------------------------------------------------------------------------
**Miscellaneous :**
* <a href="https://github.com/sureshbabk19698/springhibernate/tree/main/src/main/java/com/sk/hibernate/entity" style="text-decoration:none;">Entities</a>
* <a href="https://github.com/sureshbabk19698/springhibernate/blob/main/src/main/resources/schema.sql" style="text-decoration:none;">schema.sql</a>
* <a href="https://github.com/sureshbabk19698/springhibernate/tree/main/src/test/resources/db/data" style="text-decoration:none;">Test datas</a>
