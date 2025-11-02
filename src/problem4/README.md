## Analysis

The performance differences between `ArrayList` and `LinkedList` can be explained by their underlying data structures:

### Random Insertions and Deletions (Middle of List)

- **LinkedList is faster.**  
- **Reason:** `LinkedList` only updates references of neighboring nodes (`O(1)`) once the position is reached.  
- `ArrayList` must shift all subsequent elements to maintain the array order, which takes `O(n)` time.

### Sequential Insertions and Deletions (Start and End)

- **Start:** `LinkedList` is faster (`O(1)`), `ArrayList` is slower (`O(n)` due to shifting).  
- **End:** `ArrayList` is fast (amortized `O(1)`), `LinkedList` is also `O(1)` but slightly slower in practice due to node overhead.  
- **Reason:** `LinkedList` allows constant-time insertion/deletion at both ends, whereas `ArrayList` must shift elements at the start.

### Random Access (`get(index)`)

- **ArrayList is much faster.**  
- **Reason:** `ArrayList` stores elements in a contiguous array, so accessing an element by index is `O(1)`).  
- `LinkedList` must traverse nodes from the start or end, making access `O(n)`.
