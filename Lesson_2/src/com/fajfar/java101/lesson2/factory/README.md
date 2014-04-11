# Factory Pattern

Provides an abstraction or an interface and lets subclass or implementing classes decide which class or method should be instantiated or called, based on the conditions or parameters given.

# Where to use & benefits

+ Connect parallel class hierarchies.
+ A class wants its subclasses to specify the object.
+ A class cannot anticipate its subclasses, which must be created.
+ A family of objects needs to be separated by using shared interface.
+ The code needs to deal with interface, not implemented classes.
+ Hide concrete classes from the client.
+ Factory methods can be parameterized.
+ The returned object may be either abstract or concrete object.
+ Providing hooks for subclasses is more flexible than creating objects directly.
+ Follow naming conventions to help other developers to recognize the code structure.