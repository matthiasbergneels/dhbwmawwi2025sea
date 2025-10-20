# Hello World - Terminal Example

steps to reproduce on Mac: 
- Open Terminal
- create a new file with ```touch HelloWorld.java```
- open the file with ```vi HelloWorld.java```
- add code and save the file (```:wq```)

```java
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

- compile the code with ```javac HelloWorld.java```
  - Note: new file ```HelloWorld.class``` will be created
- run the code with ```java HelloWorld```
  - Result: ```Hello, World!``` will be printed in the terminal
  - Note: do not add ```.class``` extension when running the code -> the class will be started NOT the class-file. 