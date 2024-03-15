#include <string>
#include <vector>

using namespace std;

string solution(int q, int r, string code) {
    string answer = "";
    for (size_t idx = 0; idx < code.length(); idx++)
        if (idx % q == r)
            answer += code[idx];
    return answer;
}