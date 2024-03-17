#include <string>
#include <vector>

using namespace std;

int solution(vector<int> common) {
    if (common[0] + common[2] == 2 * common[1]) //등차
        return common.back() + (common[1] - common[0]);
    else // 등비 common[0] * common[2] == common[1] * commom[1]
        return common.back() * (common[1] / common[0]);
}