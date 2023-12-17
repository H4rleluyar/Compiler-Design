//This sample program is used to demonstrate Procedures or functions with calls and returns and Parameters passed by value or by reference.

#include <SampleTestProcedureAndFunction>

int i;
int j;
int a;
int b;
int c;
int x;
int y;
string line;

//Simple procedure to test output
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

void squareloop(int n) {
    int i;
    i = 0;
    for (int j = 0; j <= n; j++) {
        i = j * j;
        cout << j;
        cout << " squared is ";
        cout << i;
        cout << "\n";
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

int testfor(int x) {
    int i;
    i = 0;
    for (int h = x; h >= 6; h--) {
        cout << h;
        cout << "\n";
        i = h;
    }
    return i;
}

main() {

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

    i = testfor(10);
    cout << "the final number was: ";
    cout << i;
    cout << "\n";

    squareloop(10);
}
