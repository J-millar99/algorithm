#include <string>
#include <vector>
using namespace std;

int fact(int i)
{
    if (i != 0)
        return i * fact(i - 1);
    return 1;
}

int solution(int n) {
    int i = 1;
    while (fact(i) <= n)
        i++;
    return i - 1;
}