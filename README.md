# double-linked-list
Create a class DoubleLinkdList that implements ILinkedList interface.

Input Format

First line contains a comma-separated list of the linkedlist elements.
The following line contains a keyword of the operation required to perform on the list.
The number and the contents of the following lines depend on the keyword:

add: Followed by 1 line containing the element to insert to the end of the list.
addToIndex: Followed by 2 lines, the first contains the insertion index and the second contains the insertion value.
get: Followed by 1 line containing the index of the requried element.
set: Followed by 2 lines, the first contains the index and the second contains the value of the new value.
clear: Not followed by additional lines.
isEmpty: Not followed by additional lines.
remove: Followed by 1 line containig the index of the element.
sublist: Followed by 2 lines, the first has the starting index and the second has the ending index of the sublist.
contains: Followed by 1 line, containing the the element we test for exisitence.
Constraints

Assume the list contains only integer values for this problem.

Output Format

For keywords add, addToIndex, set, clear, and remove it is required to print the list elements after the operations.

For get: print the retrieved element.
For isEmpty, contains: print "True" or "False".
For sublist: print the elements of the sublist.
