#include <string>
#include <vector>

using namespace std;

int solution(vector<int> rank, vector<bool> attendance) {
    int _map[rank.size() + 1];
    for (int i = 0; i < rank.size() + 1; i++)
        _map[i] = -1;

    int index = 0;
    for (int r : rank) {
        if (attendance[index] == true)
            _map[r] = index;
        ++index;
    }

    int ret[3];
    int j = 0;
    for (int idx = 0; idx < rank.size() + 1 && j != 3; idx++) {
        if (_map[idx] != -1) {
            ret[j] = _map[idx];
            j++;
        }
    }
    return 10000 * ret[0] + 100 * ret[1] + ret[2];
}