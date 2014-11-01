#include <iostream>
using namespace std;

class Rectangle {
    int width, height;
  public:
    Rectangle() {}
    Rectangle (int x, int y) : width(x), height(y) {}
    int area() {return width * height;}
    friend Rectangle* duplicate (const Rectangle&);
};

Rectangle* duplicate (const Rectangle& param)
{
  Rectangle* res = new Rectangle();
  res->width =1; //param.width*2;
  res->height =2; //param.height*2;
  return res;
}

int main () {
  Rectangle* foo;
  Rectangle bar (2,3);
  foo = duplicate (bar);
  cout << foo->area() << '\n';
  return 0;
}