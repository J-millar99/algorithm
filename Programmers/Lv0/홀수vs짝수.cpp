#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int num1 = 0, num2 = 0;
    for (size_t idx = 0; idx < num_list.size(); idx += 2)
        num1 += num_list[idx];
    for (size_t idx = 1; idx < num_list.size(); idx += 2)
        num2 += num_list[idx];
    return num1 >= num2 ? num1 : num2;
}