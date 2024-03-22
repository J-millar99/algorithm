#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
        ++answer;
        string aString = to_string(answer);
        while (answer % 3 == 0 || aString.find("3") != string::npos)
        {
            ++answer;
            aString = to_string(answer);
        }
    }
    return answer;
}