#include "Stack.h"
#include<iostream>
using namespace std;
Stack::Stack()
{

}
void Stack::push(Element* data)
{
    b2.prepend(data);

}

Element* Stack:: pop()
{
    Element* object = b2.removeLast();
    return object;
}
