#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    for (int even = 0; even <= n; even += 2)
        answer += even;
    return answer;
}