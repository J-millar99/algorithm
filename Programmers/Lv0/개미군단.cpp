#include <string>
#include <vector>

using namespace std;

int solution(int hp) {
    int answer = 0;
    while (hp >= 5)
    {
        hp -= 5;
        answer += 1;
    }
    while (hp >= 3)
    {
        hp -= 3;
        answer += 1;
    }
    while (hp >= 1)
    {
        hp -= 1;
        answer += 1;
    }
    return answer;
}