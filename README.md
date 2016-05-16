# atg-generics
Enables Oracle ATG repositorys to work with Java Generics, allows off heap storage of RepositorItems

This is design to be backwardly compatibale with standard ATG repositories.

* It offer automatic code generation, of Repository Item wrapper beans
* Give some example of offheap item cacheing  



## Sample code
```java
Product product = repository.getItem(productId, Product.class);
String description = product.getDescription();
println("1=" + description);

RepositoryItem productRepositoryItem = (RepositoryItem) product;
description = (String)productRepositoryItem.getPropertyValue("description");
println("2=" + description);

Product product = (Product) repository.getItem(productId,"product");
String description = product.getDescription();
println("3=" + description);

RepositoryItem item =   repository.getItem(productId, "product");
description = (String) item.getPropertyValue("description");
println("4=" + description);

Product product1 =  (Product )item ;
String description = product1 .getDescription();
println("5=" + description);
```

## Use



