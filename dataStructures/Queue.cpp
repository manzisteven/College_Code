#include "Queue.h"
#include<iostream>
using namespace std;
Queue::Queue()
{

}
void Queue::enqueue(Element *object)
{
    b1.append(object);


}

void Queue::print()
{
    b1.print();
}
Element*Queue::dequeue()
{
    Element* object2 = b1.removeFirst();
    return object2;
}
