# Java Data Structures

This repository contains implementations of common data structures in Java, organized into a clear and modular file structure. It is designed for learning and practical use, with reusable interfaces and utility functions.


## File Structure

#### Entry point  [link](src/main/java/git/JavaDataStructure/)


- **Abstract**: Contains `AbstractList.java` which provides shared functionality for list-based implementations.
- **ArrayBased**: Includes array-based data structures:
  - `ArrayList.java`, `Queue.java`, `Dequeue.java`, `Stack.java`.
- **Interfaces**: Defines shared contracts used across various data structure implementations:
  - `DequeueInterface.java`, `QueueInterface.java`, `StackInterface.java`, `RandomAccess.java`.
- **LinkedList**: Implements data structures using linked lists:
  - `LinkedList.java`, `Node.java`, `Queue.java`, `Stack.java`, `Dequeue.java`.
- **Utils**: Utility classes for operations on data structures:
  - `LinkedListUtils.java`, `ListUtils.java`, `NodeUtils.java`.

## Package  Structure
``` 
├───Abstract
│       AbstractList.java
│       
├───ArrayBased
│       ArrayList.java
│       Dequeue.java
│       Queue.java
│       Stack.java
│       
├───Interfaces
│       DequeueInterface.java
│       QueueInterface.java
│       RandomAccess.java
│       StackInterface.java
│
├───LinkedList
│       Dequeue.java
│       LinkedList.java
│       Node.java
│       Queue.java
│       Stack.java
│
└───Utils
        LinkedListUtils.java
        ListUtils.java
        NodeUtils.java

```

## Getting Started

Clone the repository to explore the implementations:

```bash
git clone https://github.com/MostafaOsmanFathi/Java-Data-Structure.git
cd Java-Data-Structure
```


## License

This project is licensed under the [MIT License](LICENSE).

---
