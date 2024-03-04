#include <string>
#include <vector>

using namespace std;

double solution(vector<int> numbers) {
    double answer = 0;
    for (vector<int>::iterator it = numbers.begin(); it != numbers.end(); ++it)
        answer += *it;
    return answer / numbers.size();
}

// 추가사항
#include <string>
#include <vector>
#include <numeric> // 새로운 라이브러리
using namespace std;

double solution(vector<int> numbers) {
    double answer = 0;
    // accumulate 함수로 0부터 누적을 int로 더할 수 있는가 보다
    int sum = accumulate(begin(numbers), end(numbers), 0, plus<int>());
    answer = (double)sum / numbers.size();
    return answer;
}