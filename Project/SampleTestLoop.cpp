//This sample programs is used to demonstrate and test looping control statement (while loops and for loops)

#include <SampleTestLoops>

int i, j, k;

main() {
    //Assignment statements here
    i = 0;
    j = 60;

   cout << "Testing while loop (less than)  here";
   cout << "\n";
   while(i < 30){
        cout << i;
        cout << "\n";
        i = i + 1;
    }

   cout << "Testing while loop (less than equal)  here";
   cout << "\n";
   while(i <= 30){
        cout << i;
        cout << "\n";
        i = i + 1;
    }

   cout << "Testing while loop (greater than equal)  here";
   cout << "\n";
   while(j >= 30){
        cout << j;
        cout << "\n";
        j = j - 1;
    }


   cout << "Testing while loop (greater than)  here";
   cout << "\n";
   while(j > 30){
        cout << j;
        cout << "\n";
        j = j - 1;
    }

   cout << "Testing For Loop (less than) here";
   cout << "\n";
   for (int z = 0; z < 30; z++) {
        cout << z;
        cout << "\n";
   }

   cout << "Testing For Loop (greater than) here";
   cout << "\n";
   for (int x = 60; x > 30; x--) {
        cout << x;
        cout << "\n";
   }


}
