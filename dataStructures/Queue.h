#ifndef QUEUE_H
#define QUEUE_H
#include "Element.h"
#include "LinkedList.h"

class Queue
{
 public:
	Queue();
	void enqueue(Element* object);
	Element* dequeue();
	bool isEmpty();
	void print();

 public:
    LinkedList b1;
};

#endif // QUEUE_H
