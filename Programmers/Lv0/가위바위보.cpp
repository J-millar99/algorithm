#include <string>
#include <vector>

using namespace std;

string solution(string rsp) {
    string answer = "";
    for (char ch : rsp)
        if (ch == '0')
            answer += "5";
        else if (ch == '2')
            answer += "0";
        else if (ch == '5')
            answer += "2";
    return answer;
}