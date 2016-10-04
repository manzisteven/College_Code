#include "LinkedList.h"
#include<iostream>
using namespace std;
LinkedList::LinkedList()
{

}
// This function creates a linkedlist where the node is added at the end of the list
// @param object1: object of type Element
void LinkedList::append(Element *object1)
{
Node* Pointer = new Node();
    Pointer->object = *object1;
    Pointer-> next= NULL;
    if (head== NULL)
    {
       head = Pointer;
    }
    else
    {
      Node* Pointer = new Node();
      Pointer->object = *object1;
      Pointer-> next= NULL;
      pointer1=head;
      while(pointer1->next!=NULL)
        {
          pointer1 = pointer1->next;
        }
        pointer1->next = Pointer;



}
}
// I used this function for testing other functions, it print out the content of the list to the console.
void LinkedList::print()
{
    if (head == NULL)
    cout<<"The list is empty"<<endl;

    pointer2 = head;

    while(pointer2!=NULL)
        {
          //cout<<pointer2->object.getNames();
         // cout<<pointer2->object.getAge();
         // cout<<pointer2->object.getBirthday()<<endl;
          object7[i] = pointer2->object;
          pointer2 = pointer2->next;
          i++;
        }
 sort(object7, 0, 99);
 printSorted();

}
// This function is used to remove an element from the list,
Element* LinkedList::removeFirst()
{
    Node* pointer3 = head;



        head = head->next;

    return &(pointer3->object);

}
// This function is used to create a linkedlist where the node is added at the head of the list
// @param object1: object of type Element
void LinkedList::prepend(Element* object1)
{
    Node* Pointer = new Node();
    Pointer->object = *object1;
    Pointer-> next= top_Value;
    top_Value = Pointer;
}
// This function is used to remove an element from the list, it was used to empty the stack.
Element* LinkedList::removeLast()
{
    pointer3 = top_Value;
    top_Value = top_Value->next;
    return &(pointer3->object);
}
// This function is used to sort elements in a linked list
// @param: object[]: array of objects of type elements.
// @param: begin: the starting index of the array
//@param: end: the last index of the array
void LinkedList::sort(Element object[], int begin, int end)
{
  if (begin<end)
  {
      int newIndex = getPartitionIndex(object,begin, end);
      sort (object, begin, newIndex-1);
      sort (object, newIndex+1, end);
  }
}
// This function pushes all the elements in the array that are smaller than the pivot to the left-hand side of the pivot
// and all the elements that are greater than the pivot are pushed to the right-hand side of the pivot.
// The pivot is an element of an array that is randomly chosen.
int LinkedList::getPartitionIndex(Element object[], int begin, int end)
{
    Element pivot = object[end];
    int newIndex = begin;
    for (int i = begin; i<end; i++)
    {
       if (object[i].getNames().compare(pivot.getNames())<=0)
       {
           swap(object, i, newIndex);
           newIndex++;
       }

    }
    swap(object, newIndex, end);

    return newIndex;
}
// This function swaps two elements of an array at two different index positions.
void LinkedList::swap(Element object[], int index1, int index2)
{
    Element object1;
    object1 = object[index1];
    object[index1] = object[index2];
    object[index2] = object1;

}
void LinkedList::printSorted()
{    file11.open("output6.dat");
      for (int i= 0; i<99; i++)
  {
     file11 <<object7[i].getNames();
     file11<<",";
     file11<<object7[i].getAge();
     file11<<",";
     file11<<object7[i].getBirthday();
     file11<<endl;
  }
}
