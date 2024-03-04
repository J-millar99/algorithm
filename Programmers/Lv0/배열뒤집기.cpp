#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    for (vector<int>::reverse_iterator it = num_list.rbegin(); it != num_list.rend(); ++it)
        answer.push_back(*it);
    return answer;
}

// STL에서 reverse를 사용하면 배열을 뒤집을 수 있다.
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> num_list) {
    reverse(num_list.begin(), num_list.end());
    return num_list;
}