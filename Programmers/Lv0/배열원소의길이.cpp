#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<string> strlist) {
    vector<int> answer;
    for(vector<string>::iterator it = strlist.begin(); it != strlist.end(); ++it)
    {
        string tmp = *it;
        answer.push_back(tmp.length());
    }
    return answer;
}

// c++에서는 auto를 사용하여 컨테이너를 순회할 수 있다. ->enhanced for loop
#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<string> strlist) {
    vector<int> answer;
    for(auto str : strlist)
        answer.push_back(str.length());

    return answer;
}