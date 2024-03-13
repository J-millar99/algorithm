#include <string>
#include <vector>

using namespace std;

int solution(string my_string) {
    int answer = 0;
    int num = 0;
    for (char ch : my_string) {
        if (isdigit(ch)) {
            num *= 10;
            num += ch - '0';
        }
        else {
            answer += num;
            num = 0;
        }
    }
    answer += num;
    return answer;
}