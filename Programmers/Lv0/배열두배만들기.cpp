#include <string>
#include <vector>
using namespace std;

// 새로운 배열을 생성
vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    for (auto num : numbers)
        answer.push_back(num * 2);
    return answer;
}

// 참조변수 활용
vector<int> solution(vector<int> numbers) {
    for (auto &num : numbers)
        num *= 2;
    return numbers;
}