#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int cnt = 0;
    for (int i = 1; i <= n; i++)
    {
        int divCnt = 0;
        for (int j = 1; j <= i; j++)
            if (i % j == 0)
                divCnt++;
        if (divCnt >= 3)
            cnt++;
    }
    return cnt;
}