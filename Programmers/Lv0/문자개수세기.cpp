#include <string>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> solution(string my_string) {
    vector<int> answer(52, 0);
    for (char ch : my_string) {
        if (islower(ch))
            answer[int(ch - 'a') + 26] += 1;
        else
            answer[int(ch - 'A')] += 1;
    }
    return answer;
}