#include <string>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

vector<int> solution(int n) {
    set<int> _set;
    while (n != 1)
        for (int div = 2; div <= n; div++)
            if (n % div == 0) {
                n /= div;
                _set.insert(div);
                break ;
            }
    vector<int> answer(_set.begin(), _set.end());
    return answer;
}