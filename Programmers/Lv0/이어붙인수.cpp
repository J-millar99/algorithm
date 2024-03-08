#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    std::string odd = "";
    std::string even = "";
    for (auto num : num_list)
        num % 2 == 0 ? even += to_string(num) : odd += to_string(num);
    return stoi(even) + stoi(odd);
}