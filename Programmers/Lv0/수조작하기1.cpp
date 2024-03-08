#include <string>
#include <vector>
#include <map>
using namespace std;

int solution(int n, string control) {
    for (char cmd : control)
    {
        if (cmd == 'w')
            n = n + 1;
        else if (cmd == 's')
            n = n - 1;
        else if (cmd == 'a')
            n = n - 10;
        else if (cmd == 'd')
            n = n + 10;
    }
    return n;
}

// associative container를 이용한 방법
map <char, int> m = {{'w', 1}, {'s', -1}, {'d', 10}, {'a', -10}};
int solution(int n, string control) {
    int answer = n;
    for(char ch : control)
        answer += m[ch];
    return answer;
}