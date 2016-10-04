// basic file operations
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <sstream>
#include <vector>
#include "Element.h"
#include "Stack.h"
#include "LinkedList.h"
#include "Queue.h"
#include "BinTree.h"
using namespace std;
// This variable was declared as a global variable so that it can be accessed by other functions, other than main.
Queue d;
//This function is used to queue and requeue after reading the InputFile.dat file.
void queue_();
// This function is invoked by readMoreData function while queuing and requeuing.
void processMoredata(string names2, string age2, string birthdate2);
//This function is used to queue and requeue after reading the more-input.dat file
void readMoreData();
// This function is invoked by queue_ function while queuing and requeuing.
void process_data(string names2, string age2, string birthdate2);
string names;
string age;
string birthdate;
int count = 0;
BinTree obj1;
int main()
{
 int val = 1;
 queue_();
 ofstream file;
 ofstream file1;
 ofstream file12;
 file12.open("output7.dat");
 Stack obj;

 LinkedList a;
obj1.file3.open("output3.dat");
obj1.file4.open("output4.dat");
obj1.file5.open("output5.dat");
file.open("output1.dat");
file1.open("output2.dat");
while (d.b1.head != NULL)
  {
      Element* object3 = d.dequeue();
      file <<object3->getNames();
      file<<",";
      file <<object3->getAge();
      file<<",";
      file <<object3->getBirthday();
      file<<endl;
  }
 queue_();

 while (d.b1.head != NULL)
  {
      Element* object4 = d.dequeue();
      obj.push(object4);
  }
 while(obj.b2.top_Value != NULL)
 {
     Element* object = obj.pop();
     d.enqueue(object);
 }
  while (d.b1.head != NULL)
  {
      Element* object3 = d.dequeue();
      file1 <<object3->getNames();
      file1<<",";
      file1 <<object3->getAge();
      file1<<",";
      file1 <<object3->getBirthday();
      file1<<endl;
  }
  queue_();
  obj1.root = NULL;
  while (d.b1.head != NULL)
  {
    Element* object3 = d.dequeue();
    obj1.root = obj1.add(obj1.root, object3);

  }

  obj1.startPreOrderTraversal(obj1.root);
  obj1.startPostOrderTraversal(obj1.root);
  while (d.b1.head != NULL)
  {
    Element* object3 = d.dequeue();
    delete(object3);

  }
  obj1.startInOrderTraversal(obj1.root);
  readMoreData();
  obj1.b3.print();





   return 0;

}
void process_data(string names2, string age2, string birthdate2)
{
     Element object (names2, age2, birthdate2);
     d.enqueue(&object);

}
void queue_()
{

  vector <vector <string> > data;
  ifstream infile( "InputFile.dat" );

  while (infile)
  {
    string s;
    if (!getline( infile, s )) break;

    istringstream ss( s );
    vector <string> record;

    while (ss)
    {
      string s;
      if (!getline( ss, s, ',' )) break;
      record.push_back( s );

    }
  for (int i =0; i<record.size(); i++)
  {

         count++;
         if (count == 1)
         {
             names = record[i];

         }

         if (count == 2)
         {
             age = record[i];

         }
         if (count == 3)
         {
             birthdate = record[i];
             process_data(names, age, birthdate);
             count = 0;
}


  }


  data.push_back( record );


  }




  if (!infile.eof())
  {
    cerr << "ERROR!\n";
  }

}
void readMoreData()
{
    vector <vector <string> > data;
  ifstream infile( "more-input.dat" );

  while (infile)
  {
    string s;
    if (!getline( infile, s )) break;

    istringstream ss( s );
    vector <string> record;

    while (ss)
    {
      string s;
      if (!getline( ss, s, ',' )) break;
      record.push_back( s );

    }
  for (int i =0; i<record.size(); i++)
  {

         count++;
         if (count == 1)
         {
             names = record[i];

         }

         if (count == 2)
         {
             age = record[i];

         }
         if (count == 3)
         {
             birthdate = record[i];
            processMoredata(names, age, birthdate);
             count = 0;
}


  }


  data.push_back( record );


  }




  if (!infile.eof())
  {
    cerr << "ERROR!\n";
  }
}
void processMoredata(string names2, string age2, string birthdate2)
{
     Element object (names2, age2, birthdate2);
     obj1.b3.append(&object);
}
