#include <string>
#include <vector>
using namespace std;

int solution(int n) {
    int answer = 0;
    while (n > 0)
    {
        answer += n % 10;
        n /= 10;
    }
    return answer;
}

// 파이썬의 방식처럼 문자열로 바꾸어 자릿수를 추출하여 더함
int solution(int n) {
    int answer = 0;
    string s = to_string(n);
    for(char c : s)
        answer += (c - '0');
    return answer;
}