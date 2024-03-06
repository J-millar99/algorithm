#include <string>
#include <vector>
using namespace std;

int solution(int n) {
    int cnt = 0;
    for (int i = 1; i <= n; i++)
        n % i == 0 ? cnt++ : 0;
    return cnt;
}