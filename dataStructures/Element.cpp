#include "Element.h"
#include<iostream>
#include<string>
using namespace std;
Element::Element()
{

}
Element::Element(string names1, string age1, string birthdate1)
{
    names = names1;
    age = age1;
    birthdate = birthdate1;
}
string Element::getNames()
{
    return names;
}
string Element::getAge()
{
    return age;
}
string Element::getBirthday()
{
    return birthdate;
}
