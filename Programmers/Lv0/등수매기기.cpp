#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<vector<int>> scores) {
    vector<float> score;
    for (auto s : scores)
        score.push_back((float)(s[0] + s[1]) / 2);
    int i = 1, adj;
    vector<int> rank(score.size(), 0);

    while (find(rank.begin(), rank.end(), 0) != rank.end()) {
        adj = 0;
        float max_value = *max_element(score.begin(), score.end());
        printf("%f\n", max_value);
        if (count(score.begin(), score.end(), max_value) == 1) {
            rank[distance(score.begin(), find(score.begin(), score.end(), max_value))] = i;
            score[distance(score.begin(), find(score.begin(), score.end(), max_value))] = -1;
            i += 1;
        }
        else {
            vector<int> max_indexes;
            for (size_t idx = 0; idx < score.size(); ++idx)
                if (score[idx] == max_value)
                    max_indexes.push_back(idx); // 조건을 만족하는 인덱스 저장
            for (int idx : max_indexes) {
                rank[idx] = i;
                score[idx] = -1;
                ++adj;
            }
        }
        i += adj;
    }
    return rank;
}