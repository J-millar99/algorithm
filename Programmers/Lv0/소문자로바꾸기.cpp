#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    string answer = "";
    for (auto ch : myString)
    {
        isupper(ch) ? ch += ('a' - 'A') : 0;
        answer += ch;
    }
    return answer;
}