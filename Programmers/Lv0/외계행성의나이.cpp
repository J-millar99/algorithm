#include <string>
#include <vector>

using namespace std;

string solution(int age) {
    string sAge = to_string(age);
    string answer = "";
    for (char ch : sAge) {
        ch = ch - '0' + 'a';
        answer += ch;
    }
    return answer;
}