#include <string>
#include <vector>

using namespace std;

int solution(vector<int> date1, vector<int> date2) {
    return (date1[0] * 365 + date1[1] * 30 + date1[2] >= date2[0] * 365 + date2[1] * 30 + date2[2]) ? 0 : 1;
}