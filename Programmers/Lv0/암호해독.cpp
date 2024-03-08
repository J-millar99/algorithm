#include <string>
#include <vector>

using namespace std;

string solution(string cipher, int code) {
    string answer = "";
    for (int idx = code - 1; idx < cipher.length(); idx += code)
        answer += cipher[idx];
    return answer;
}