## Java Enums

Java enums are full-fledged classes, much powerful than C++ enums, which is simply int

Enum constructors are not allowed to access static fields(except constants) because static fields may
not be initialized when constructors of enums run.