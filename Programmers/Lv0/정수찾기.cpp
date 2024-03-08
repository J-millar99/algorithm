#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> num_list, int n) {
    return num_list.end() != find(num_list.begin(), num_list.end(), n) ? 1 : 0;
}