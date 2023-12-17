//This sample program will be demonstrate and test Basic arithmetic operations with operator precedence, Assignment statements, and At least one conditional control statement (e.g., IF).

#include <SampleTestIf>

int i, j;
double x, y;
string line, text;

main() {

    //examples of assignment statements here
    line = "Hello World";
    i = 1;
    j = 2;

    if (i == j) { //if else using  ==
        x = 3.14;
    } else {
        x = -5;
    }

    cout << "i = ";
    cout << i;
    cout << "\n";
    cout << "j = ";
    cout << j;
    cout << "\n";
    cout << "x = ";
    x= 42.3;
    cout << x;
    cout << "\n";
    cout << "y = ";
    y= 4.3;
    cout << y;
    cout << "\n";

    if (i != j) { //example of if else using !=
        y = 3.14;
    } else {
        y = -5;
    }
    cout << "y = ";
    cout << y;
    cout << "\n";
    cout << line;
    cout << "\n";
    cout << "Goodbye World!";
    cout << "\n";

    if(10 >= 1){ // example of if statement using >=
    cout << x + 10; //exmaple of double + int
    }
    if(10 >= 12){ //
        text = "Nope";
        cout << text;
    }

     cout << "\n";

    if(10 <= 12){ //example if statement using <=
       cout << "Ten is less than 12";
       cout << "\n";
    }
    if(111 <= 12){
           cout << "This statement is wrong";
           cout << "\n";
    }


    cout << 10 - 2 * 20 + 5 * 10 + 3 - 4 * 2 ; //example of Basic arithmetic operations with operator precedence, the result should be 15

}

