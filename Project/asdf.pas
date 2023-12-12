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
}
