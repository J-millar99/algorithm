#include <string>
#include <vector>
#include <cmath>
using namespace std;

int solution(int n) {
    for (size_t i = 0; i < sqrt(n) + 1; i++)
        if (i * i == n)
            return 1;
    return 2;
}

// 나누어 떨어지지않는 제곱수라면 소수점 손실이 발생하여, 제곱하더라도 n값에 도달하지 못할것이다
int solution(int n) {
    int q = sqrt(n);
    return q * q == n ? 1 : 2;
}