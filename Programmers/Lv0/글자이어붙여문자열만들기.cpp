#include <string>
#include <vector>

using namespace std;

string solution(string my_string, vector<int> index_list) {
    string str = "";
    for (int idx : index_list)
        str += my_string[idx];
    return str;
}