#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b)
{
    while (b > 0) {
        int tmp = a;
        a = b;
        b = tmp % b;
    }
    return a;
}

int solution(int a, int b) {
    int den = b / gcd(a, b);
    while (den != 1) {
        if (den % 2 == 0)
            den /= 2;
        if (den % 5 == 0)
            den /= 5;
        if (den == 1)
            return 1;
        if (den % 2 != 0 && den % 5 != 0)
            return 2;
    }
    return 1;
}