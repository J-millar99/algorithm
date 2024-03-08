#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    for (size_t idx = 0; idx < num_list.size(); idx++)
        if (num_list[idx] < 0)
            return idx;
    return -1;
}