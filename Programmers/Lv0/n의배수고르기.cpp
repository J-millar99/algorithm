#include <string>
#include <vector>
using namespace std;

vector<int> solution(int n, vector<int> numlist)
{
    vector<int>::iterator it = numlist.begin();
    while (it != numlist.end())
    {
        if (*it % n != 0)
            numlist.erase(it);
        else
            it++;
    }
    return numlist;
}
