# atg-generics
Enables Oracle ATG repositorys to work with Java Generics, allows off heap storage of RepositorItems

This is design to be backwardly compatibale with standard ATG repositories. ***All*** items that are created are both RepositoryItems and Beans 

# Key features
* It offer automatic code generation, of Repository Item wrapper beans
* Offheap item cacheing, that allows you to scale better
* Faster performance for in memeory caching 
* Better scaling by using of heap methods for very large number of items


## Sample code 
```java
Product product = repository.getItem(productId, Product.class);
String description = product.getDescription();
println("1=" + description);

RepositoryItem productRepositoryItem = (RepositoryItem) product;
description = (String)productRepositoryItem.getPropertyValue("description");
println("2=" + description);

Product product = (Product)repository.getItem(productId,"product");
String description = product.getDescription();
println("3=" + description);

RepositoryItem item =   repository.getItem(productId, "product");
description = (String)item.getPropertyValue("description");
println("4=" + description);

Product product1 =  (Product)item ;
String description = product1.getDescription();
println("5=" + description);
```

## Performance

If the item will fit within the JVMs heap without causing excessive GC avtivity that you can set ***usingMap=true*** This is appoximatly ***6x***  *faster* than simple caching.

If you the number of items are to large to fit in the JVMs memory that you can take advantage of the off heap versions, this serialise and deserialise the object, This is similar to the ATG Coherance intergartion, however I beleive that Oracles only stored the key and not that full object loosing some of the potential performance improvement.
Some very basic test have show perfomance approximately ***3x*** *slower* than simple caching however its still faster than going back to the DB. And it can scale to a hugh number of items.


## Use

#### Repository configuration 
```
# /atg/commerce/catalog/ProductCatalog
$class=atg.adapter.gsa.GenericsRepository
dataSource=/atg/commerce/jdbc/ProductCatalogSwitchingDataSource
outputDirectory=/app/oracle/product/atg/ATG/GenericRepository/src
#loggingDebug=true
#loggingTrace=true


#You must uses one of the following storage types usingMap, usingMapDB or usingHazelcast if either of these is not see it will default to using a Map
changeAware=true
#MapDB settings
usingMapDB=true
#Hazelcast settings
#usingHazelcast=true
hazelcastServers=10.0.2.15:5701,10.0.2.15:5702
hazelcastUser=dev
hazelcastPassword=dev-pass
```

#### Bean creation 

Having configured the your repository as above you need to invoke a the **generateAllClasses** on the repository
```
http://localhost:8840/dyn/admin/nucleus/atg/commerce/catalog/ProductCatalog
```
The code will be generated in the directory ***outputDirectory***


Additional ATG related 

[https://github.com/varelma/atg-utils](https://github.com/varelma/atg-utils)

[https://github.com/sparkred-insight/atgel](https://github.com/sparkred-insight/atgel)

This software was created by Jon Pallas - jon@varelma.com

![Varelma](https://github.com/varelma/atg-generics/varelma-small.png "Varelma")

