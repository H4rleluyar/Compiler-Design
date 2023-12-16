#include <asdf>

int i;
int j;
int a;
int b;
int c;
int k;
int x;
int y;
string line;

void testprocedure() {
    cout << "procedure test 1";
    cout << "\n";
}

void testtwo(boolean b) {
    if (b) {
        cout << "the boolean was true";
        cout << "\n";
    }
}

void max(int x, int y) {
    if (x > y) {
        cout << "the bigger number is ";
        cout << x;
        cout << "\n";
    }

    if (y > x) {
        cout << "the bigger number is ";
        cout << y;
        cout << "\n";
    }
}

void testt(int p) {
    cout << p;
}

void testtt(boolean w) {
    if (w) {
       cout << "hi";
    }
}

double testfunc(double x, double y) {
    return x+y;
}

int testfunction(int x, int y) {
    return x+y;
}

int min(int x, int y) {
    int temp;
    temp = x;
    if (y < x) {
        temp = y;
    }
    cout << "you are calling the min function!";
    cout << "\n";
    return temp;
}

string testfuncc(string one, string two) {
    string newstring;
    newstring = one + two;
    return newstring;
}

main() {
    line = "Hello World";
    i = 1;
    j = 2;
    if (i == j) {
        x = 3;
    } else {
        x = -5;
    }
    if (i != j) {
        y = 3;
    } else {
        y = -5;
    }
    cout << i;
    cout << "\n";
    cout << j;
    cout << "\n";
    cout << x;
    cout << "\n";
    cout << y;
    cout << "\n";
    cout << "Hello World\n";

    if (i == j) {
        x = -7;
    } else {
        x = 8;
    }
    if (i != j) {
        y = 14;
    }
    else {
        y = -2;
    }
    line = "Goodbye World!\n";
    cout << i;
    cout << "\n";
    cout << j;
    cout << "\n";
    cout << x;
    cout << "\n";
    cout << y;
    cout << "\n";
    cout << line;

    if(10 >= 12){
    cout << "Ten is not bigger than 12 dummy!";
    }

     cout << "\n";

     if(10 <= 12){
        cout << "Ten is less than 12";
        cout << "\n";
     }

    testprocedure();
    testtwo(true);
    max(i,j);
    max(i, testfunction(i, j));
    cout << min(i, j);
    cout << "\n";
    cout << testfunc(1.5, 2.3);
    cout << "\n";
    cout << testfuncc("hi", "bye");
    cout << "\n";
}
