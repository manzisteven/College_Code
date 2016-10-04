#ifndef LINKEDLIST_H
#define LINKEDLIST_H
#include "Element.h"
#include <exception>
#include <string>
#include<fstream>

class LinkedList
{

  private:
    struct Node
        {
            Element object;
            Node* next;
        };

        Node* pointer1;
        Node* pointer2;
        Node* pointer3;
        Node* pointer4;
        Node* pointer5;
        Node* pointer6;
  public:
	LinkedList();

	void prepend(Element* object1);
	void append(Element *object1);
	// insert element at the right position into a sorted list
	void insertSorted(Element*);
	Element* removeFirst();
	Element* removeLast();
	bool isEmpty();
	void empty();
	int isSorted();
	void sort(Element object[], int begin, int end);
	std::string to_string();
    Node* head = NULL;
    Node* top_Value = NULL;
    Node* pointer7;
    void print ();
    Element object7[100];
    int i = 0;
    ofstream file11;
    int getPartitionIndex(Element object[], int begin, int end);
    void swap (Element object[], int index1, int index2);
    void printSorted();

};

#endif // LINKEDLIST_H
