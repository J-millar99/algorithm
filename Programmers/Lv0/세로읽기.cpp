#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int m, int c) {
    string answer = "";
    for (int i = 0; i * m + c - 1 < my_string.length(); i++)
        answer += my_string[i * m + c - 1];
    return answer;
}