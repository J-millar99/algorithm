#include <string>
#include <vector>
using namespace std;

// 진수 변환 풀이법
int changeDecimal(string bin)
{
    int num = 0;
    for (char ch : bin) {
        num *= 2;
        if (ch == '1')
            num += 1;
    }
    return num;
}

string changeBinary(int num)
{
    static string ret = "";
    if (num >= 2)
        changeBinary(num / 2);
    ret += to_string(num % 2);
    return ret;
}

string solution(string bin1, string bin2) {
    return changeBinary(changeDecimal(bin1) + changeDecimal(bin2));
}