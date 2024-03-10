#include <string>
#include <vector>

using namespace std;

int solution(int order) {
    string str = to_string(order);
    int cnt = 0;
    for (char ch : str)
        if (ch != '0' && (ch - '0') % 3 == 0)
            cnt++;
    return cnt;
}