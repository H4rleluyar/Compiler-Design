program TestIf;

var
    i, j, k : integer;
    x, y : real;
    p, q : boolean;
    str, txt : string;

int main() {
    i := 1;
    j := 2;

    if(i == j)
        cout << "if true";
    else {
        x := -5;
        cout << "if else, compound";
    }
    cout << "outside if";

    while (i > 9000) {
        cout << "in while";
    }

}
