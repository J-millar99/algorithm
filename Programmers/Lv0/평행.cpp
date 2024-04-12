#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> dots) {
    vector<double> inc;
    for (size_t i = 0; i < dots.size() - 1; i++) {
        for (size_t j = i + 1; j < dots.size(); j++) {
            if ((dots[i][1] - dots[j][1]) == 0 && (dots[i][0] - dots[j][0]) == 0)
                return 1;
            if ((dots[j][0] - dots[i][0]) == 0)
                inc.push_back((dots[i][1] - dots[j][1]) / double(dots[i][0] - dots[j][0]));
            else
                inc.push_back((dots[j][1] - dots[i][1]) / double(dots[j][0] - dots[i][0]));
        }
    }
    for (int i = 0; i < inc.size() / 2; i++)
        if (inc[i] == inc[inc.size() - i - 1])
            return 1;
    return 0;
}