#include <iostream>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    n % 2 == 0 ? cout << n << " is even" : cout << n << " is odd";
    return 0;
}