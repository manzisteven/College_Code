#ifndef STACK_H
#define STACK_H
#include "Element.h"
#include "LinkedList.h"

class Stack
{
  public:
	Stack();
	void push(Element* data);
	Element* pop();
	bool isEmpty();
	LinkedList b2;
};

#endif // STACK_H
