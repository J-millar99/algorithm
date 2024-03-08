#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer;
    if (num_list.size() > 10)
    {
        answer = 0;
        for (int num : num_list)
            answer += num;
    }
    else
    {
        answer = 1;
        for (int num : num_list)
            answer *= num;
    }
    return answer;
}