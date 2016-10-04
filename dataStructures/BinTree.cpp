#include "BinTree.h"
#include<iostream>
#include "Element.h"
#include <fstream>
#include "LinkedList.h"
using namespace std;
BinTree::BinTree()
{
    root = NULL;
    count = 1;

}

BinTree:: Node* BinTree::getNode(Element* object3)
{
    Node* mynode = new Node();
    mynode->object = *object3;
    mynode->leftPointer = NULL;
    mynode->rightPointer = NULL;
    return mynode;
}
BinTree:: Node* BinTree::add(Node* root, Element* object3)
{
     if (root == NULL)
     {
         root = getNode(object3);
         return root;
     }
      else if (count == 1)
     {   count++;
         root->leftPointer = add(root->leftPointer, object3);
          return root;
     }
      else if (count ==2)
     {   count--;
         root->rightPointer = add(root->rightPointer, object3);
          return root;
     }

     //return root;
}
void BinTree::startPreOrderTraversal(Node* root)
{

     if (root == NULL)
       return;
       file3 <<root->object.getNames();
       file3<<",";
       file3 <<root->object.getAge();
       file3<<",";
       file3 <<root->object.getBirthday();
       file3<<endl;
       startPreOrderTraversal(root->leftPointer);
       startPreOrderTraversal(root->rightPointer);

}
void BinTree::startPostOrderTraversal(Node*root)
{
    if (root == NULL)return;
     startPostOrderTraversal(root->leftPointer);
     startPostOrderTraversal(root->rightPointer);
      file4 <<root->object.getNames();
      file4<<",";
      file4 <<root->object.getAge();
      file4<<",";
      file4 <<root->object.getBirthday();
      file4<<endl;
}
void BinTree::startInOrderTraversal(Node* root)
{
    if (root == NULL) return;
    startInOrderTraversal(root->leftPointer);
    b3.append(&(root->object));
    file5 <<root->object.getNames();
    file5<<",";
    file5 <<root->object.getAge();
    file5<<",";
    file5 <<root->object.getBirthday();
    file5<<endl;
    startInOrderTraversal(root->rightPointer);
}
