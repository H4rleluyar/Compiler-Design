#include <iostream>
#include <chrono>

int i;
int j;

void doWhileExample() {
    i = 1;
    while (i <= 5) {
        std::cout << "i = " << i << std::endl;
        i = i + 1;
    }
}

void nestedWhileExample() {
    i = 1;
    while (i <= 5) {
        j = 10;
        while (j <= 30) {
            std::cout << "i = " << i << ", j = " << j << std::endl;
            j = j + 10;
        }
        i = i + 1;
    }
}

int main() {
    auto _start = std::chrono::high_resolution_clock::now();

    doWhileExample();

    std::cout << std::endl;

    nestedWhileExample();

    auto _end = std::chrono::high_resolution_clock::now();
    long long _elapsed = std::chrono::duration_cast<std::chrono::milliseconds>(_end - _start).count();
    std::cout << "\n[" << _elapsed << " milliseconds execution time.]\n";

    return 0;
}
