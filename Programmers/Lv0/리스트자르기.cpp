#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(int n, vector<int> slicer, vector<int> num_list) {
    if (n == 1) {
        vector<int> answer(num_list.begin(), num_list.begin() + slicer[1] + 1);
        return answer;
    }
    else if (n == 2) {
        vector<int> answer(num_list.begin() + slicer[0], num_list.end());
        return answer;
    }
    else if (n == 3) {
        vector<int> answer(num_list.begin() + slicer[0], num_list.begin() + slicer[1] + 1);
        return answer;
    }
    else if (n == 4) {
        vector<int> answer;
        for (auto it = num_list.begin() + slicer[0]; it <= num_list.begin() + slicer[1]; it += slicer[2])
            answer.push_back(*it);
        return answer;
    }
}