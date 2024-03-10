#include <string>
#include <vector>

using namespace std;

int solution(int a, int d, vector<bool> included) {
    int answer = 0;
    for (int idx = 0; idx < included.size(); idx++)
        if (included[idx] == true)
            answer += a + d * idx;
    return answer;
}