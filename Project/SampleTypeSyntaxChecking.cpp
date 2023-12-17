//This sample programs will give errors when compiling it but its purpose is to be used in order to demonstrate and test that "At least two data types with type checking"
//It also demonstrate and test Basic syntax error detection and recovery (this could seen in the errors that are shown when trying to compile this program)
#include <SampleTypeSyntax>

int i, j, k;
double a,s,f;
string line,text, tex;

main() {
    //Assignment statements here in order to check for if values are assignment-compatible
    i = 11.12; //should not work because i is an int  not double
    j = "Hello"; //should not work because j is an int not string
    k = 8; //work
    a = "Hello"; // should not work because double can't be a string
    s = 11.12; //work
    f = 10;
    line = 10; //should not work because line is a string
    text = "10"; //work


    //comparison between operands and of they are type compatible with their operands
    cout << 2 * "1"; //string cannot be multply by int
    cout << 4.1 * "1"; //string cannot be multply by double

    //check a simple comparison-compatible
    if(line > k){  //should not work because you cant do > or < with  string and int
    cout << "Hello";
    }

    if(line < k){  //should not work because you cant do > or < with  string and int
        cout << "Hello";
    }

     if(line >= k){  //should not work because you cant do > or < with  string and int
        cout << "Hello";
     }

     if(line <= k){  //should not work because you cant do > or < with  string and int
             cout << "Hello";
     }

    if(10.1 == "10.1"){  //should not work because you cant compare string to double
        cout << "Hello";
    }



}
