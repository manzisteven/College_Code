#ifndef ELEMENT_H
#define ELEMENT_H
#include <string>
#include <sstream>
#include <iostream>
using namespace std;
class Element
{
  public:
	Element();
	Element(string name1,string age1,string birthdate1);
	string getNames();
	string getAge();
	string getBirthday();
	string to_string();
	bool operator> (Element& other);
	bool operator< (Element& other);
	bool operator<= (Element& other);
	bool operator>= (Element& other);
	bool operator== (Element& other);
	bool operator!= (Element& other);
  private:
    string names;
    string age;
    string birthdate;
};

#endif // ELEMENT_H
