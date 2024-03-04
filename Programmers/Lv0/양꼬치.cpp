#include <string>
#include <vector>
using namespace std;

// k - discount가 음수가 될 수 있다면
int solution(int n, int k) {
    int discount = n / 10;
    k = k - discount > 0 ? k - discount : 0;
    return 12000 * n + 2000 * k;
}

// k - discount가 음수가 될 수 없다면
int solution(int n, int k) {
    return 12000 * n + 2000 * (k - (n / 10));
}