#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    for (int i = 1; i < n + 1; i++) {
        i % 2 == 1 ? answer.push_back(i) : (void) 0;
    }
    return answer;
}