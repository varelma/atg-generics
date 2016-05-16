# atg-generics
Enables Oracle ATG repositorys to work with Java Generics, allows off heap storage of RepositorItems



# Sample code
```java
Product product = repository.getItem(productId, Product.class);
String description = product.getDescription();
println("1=" + description);

RepositoryItem productRepositoryItem = (RepositoryItem) product;
description = (String)productRepositoryItem.getPropertyValue("description");
println("2=" + description);

Product product =(Product ) repository.getItem(productId,"product");
String description = product.getDescription();
println("3=" + description);

RepositoryItem item =   repository.getItem(productId, "product");
description = (String) item.getPropertyValue("description");
println("4=" + description);

Product product1 =  (Product )item ;
String description = product1 .getDescription();
println("5=" + description);
```
