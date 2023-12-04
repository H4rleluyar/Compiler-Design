#include <iostream>
#include <iomanip>

int i;
int j;
double x;
double y;
bool p;
bool q;
int k; 

int main() {
    i = 1;
    j = 2;
    if (i == j) {
        x = 3.14;
    } else {
        x = -5.0;
    }
    if (i != j) {
        y = 3.14;
    } else {
        y = -5.0;
    }
    std::cout << "i = " << i << ", j = " << j << ", x = " << std::fixed << std::setprecision(2) << x << ", y = " << y << std::endl;

    if (i == j) {
        x = -7.0;
    } else {
        x = 8.0;
    }
    if (i != j) {
        y = 14.0;
    } else {
        y = -2.0;
    }
    std::cout << "i = " << i << ", j = " << j << ", x = " << std::fixed << std::setprecision(2) << x << ", y = " << y << std::endl;

    p = i == j;
    if (p) {
        x = 55.55;
    } else {
        x = 77.77;
        y = 88.88;
    }
    std::cout << "i = " << i << ", j = " << j << ", x = " << std::fixed << std::setprecision(2) << x << ", y = " << y << std::endl;

    q = i <= j;
    k = 10;
    if (p) {
        i = 33;
    } else {
        if (!q) {
            i = 44;
        } else {
            if (i == j) {
                i = 55;
            } else {
                i = 6;
            }
        }
    }
    if (!p) {
        if (q) {
            j = 9;
        } else {
            j = -9;
        }
    }
    if (p) {
        if (q) {
            k = 11;
        } else {
            k = 12;
        }
    }
    std::cout << "i = " << i << ", j = " << j << ", x = " << std::fixed << std::setprecision(2) << x << ", y = " << y << std::endl;
    std::cout << "k = " << k << std::endl;
    std::cout << std::endl;

    if (!p && q && (i != j) && (x < y)) {
        std::cout << "Good-bye";
    }
    if (!p) {
        if (q) {
            if (i != j) {
                if (x < y) {
                    std::cout << ", world!" << std::endl;
                }
            }
        }
    }

    return 0;
}


