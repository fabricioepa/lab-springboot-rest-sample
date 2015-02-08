# lab-springboot-rest-sample
Sample code for Spring Boot RESTful Service workshop

The code is based on the CQRS pattern (Command Query Responsibility Segregation), introduced by Greg Young, decoupling
the models for the Read/Write operations.

The pattern is better described by Martin Fowler in his blog (http://martinfowler.com/bliki/CQRS.html)

"The other main benefit is in handling high performance applications.
CQRS allows you to separate the load from reads and writes allowing you to scale each independently..."

It means you can create lightweight data structures to read thousands of data and also have complex object structures
to read detailed information for the same entity in the domain.

Feel free to bring up your ideas  ;)

See more at my [fabricioepa.wordpress.com](http://fabricioepa.wordpress.com)
