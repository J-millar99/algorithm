#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> dots) {
    int answer = 0;
    int xmax = dots[0][0], xmin = dots[0][0], ymax = dots[0][1], ymin = dots[0][1];
    for (vector<int> dot : dots) {
        if (dot[0] > xmax)
            xmax = dot[0];
        else if (dot[0] < xmin)
            xmin = dot[0];
        
        if (dot[1] > ymax)
            ymax = dot[1];
        else if (dot[1] < ymin)
            ymin = dot[1];
    }
    return (xmax - xmin) * (ymax - ymin);
}