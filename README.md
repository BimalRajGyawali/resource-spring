[From Spring Docs,](https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch05s04.html)

### The ResourceLoader
The *ResourceLoader* interface is meant to be implemented by objects that can return (i.e. load) *Resource* instances.

```JAVA
public interface ResourceLoader {
Resource getResource(String location);
}
```

All application contexts implement the ResourceLoader interface, and therefore all application contexts may be used to obtain Resource instances.

When you call getResource() on a specific application context, and the location path specified doesn't have a specific prefix, you will get back a Resource type that is appropriate to that particular application context. For example, assume the following snippet of code was executed against a ClassPathXmlApplicationContext instance:

```
Resource template = ctx.getResource("some/resource/path/myTemplate.txt);
```
What would be returned would be a ClassPathResource; if the same method was executed against a FileSystemXmlApplicationContext instance, you'd get back a FileSystemResource. For a WebApplicationContext, you'd get back a ServletContextResource, and so on.

As such, you can load resources in a fashion appropriate to the particular application context.

On the other hand, you may also force ClassPathResource to be used, regardless of the application 
context type, by specifying the special classpath: prefix:


```
Resource template = ctx.getResource("classpath:some/resource/path/myTemplate.txt);
```

Similarly, one can force a UrlResource to be used by specifying any of the standard java.net.URL prefixes:
```
Resource template = ctx.getResource("file:/some/resource/path/myTemplate.txt);
Resource template = ctx.getResource("http://myhost.com/resource/path/myTemplate.txt);
```

