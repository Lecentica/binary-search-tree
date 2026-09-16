# Binary Search Tree

Full BST implementation in Java with traversals, structural analysis, and 
node deletion supporting all three cases (leaf, one child, two children).

## Key Concepts
- Recursive tree traversals (in-order, pre-order, post-order, reverse)
- Tree metrics: height, width, diameter, leaf count, node count
- Node removal with in-order successor replacement
- Level-order traversal using queue

## How to Run

javac *.java

java BSTreeRunner

## Known Limitations / Future Improvements
- Does not use inherent property of BST's, as such the search os O(n) - would use BST property in search and getLargest to make them O(log n) instead of O(n).
- Uses simple non realigning BST, as such worst case scenario even with improved search is O(n).
- getDiameter() doesn't compute the actual diameter. True diameter is the longest path between any two nodes, which may not pass through the root. My implementation computes "left spine length + right spine length from root".
- Uses counters as static instance variables- would change to local variables.
