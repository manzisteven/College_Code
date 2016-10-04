#ifndef BINTREE_H
#define BINTREE_H
#include "Element.h"
#include <iostream>
#include <fstream>
#include "Element.h"
#include "LinkedList.h"
class BinTree
{
private:
    struct Node
    {
        Element object;
        Node* leftPointer;
        Node* rightPointer;
    };


 public:
	BinTree();
	Node* getNode(Element* object3);
	// Add element to the tree (1) replacing and returning the element last returned by next() (during traversal) or (2) at the last unfilled position (outside traversal) keeping the tree completely filled at all times and returning null
	Node* add(Node* root, Element* object3);
	void startPreOrderTraversal(Node*root);
	void startInOrderTraversal(Node*root);
	void startPostOrderTraversal(Node* root);
	// Is there another element in this traversal ordering?
	bool hasNext();
	// Get next element in chosen traversal ordering
	Element* next();
	// stop traversal
	void stopTraversal();
	Node* root;
	int count;
    ofstream file3;
    ofstream file4;
    ofstream file5;
    ofstream file8;
    Node* test;
    LinkedList b3;
};

#endif // BINTREE_H
