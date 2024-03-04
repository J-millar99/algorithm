#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    int even = 0;
    int odd = 0;
    for (int num : num_list)
        num % 2 == 0 ? ++even : ++odd;
    answer.push_back(even);
    answer.push_back(odd);
    return answer;
}

// vector의 생성자를 이용한 방법 1
vector<int> solution(vector<int> num_list) {
    vector<int> answer(2, 0);
    for (int num : num_list) {
        answer[num % 2]++;
    }
    return answer;
}
