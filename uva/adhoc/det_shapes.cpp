#include <fstream>
#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <cstdio>

using namespace std;

double length(int *xy1, int *xy2) {
    return sqrt( pow(xy2[0] - xy1[0], 2) + pow(xy2[1] - xy1[1], 2));
}

double gradient(int *xy1, int *xy2) {
   return (double) (xy2[1] - xy1[1]) / (double) (xy2[0] - xy1[0]);
}

double sqr(double base) {
    return base * base;
}

double angle_between(int p2[], int p1[], int p3[]) {
    if (p1 == p3) {
        return 0;
    }
    double length12 = length(p1, p2);
    double length13 = length(p1, p3);
    double length23 = length(p2, p3);
    double angle = acos(((sqr(length12) + sqr(length13) - sqr(length23)) / (2 * length12 * length13)));
    return angle;
}

int x_axis[] = {10000, 0};
int *p;

bool compare(int *i,int *j) {
    return (angle_between(x_axis, p, i) < angle_between(x_axis, p, j));
}

void swap(int points [][2], int i, int j) {
    int temp[2] = points[i];
    points[i] = points[j];
    points[j] = temp;
}

int compare(int[] i, int[] j) {
    return (int) (angle_between(x_axis, p, i) - angle_between(x_axis, p, j));
}

void sort(int[][] xy) {
    // find point with lowest y val
    int lowest_index = 0;
    for (int i = 1; i < 4; ++i) {
        if (xy[i][1] < xy[lowest_index][1]) {
            lowest_index = i;
        } else if (xy[i][1] == xy[lowest_index][1]
                && xy[i][0] > xy[lowest_index][0]) {
            lowest_index = i;
        }
    }
    p = xy[lowest_index];
    swap(xy, 1, lowest_index);
    sort(xy, xy+4, comp);
}

int main() {
    ifstream cin("shapes.in");
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        int xy[4][2];
        for (int j = 0; j < 4; ++j) {
            cin >> xy[j][0] >> xy[j][1];
        }
        double grad1 = gradient(xy[0], xy[1]);
        double grad2 = gradient(xy[1], xy[2]);
        if (grad1 == -1/grad2) { // sqr or rect
            double length1 = length(xy[0], xy[1]);
            double length2 = length(xy[1], xy[2]);
            if (length1 == length2){
                cout << "Case " << (i+1) << ": Square\n";
            } else {
                cout << "Case " << (i+1) << ": Rectangle\n";
            }
        } else {
            double length1 = length(xy[0], xy[1]);
            double length2 = length(xy[1], xy[2]);
            double length3 = length(xy[2], xy[3]);
            double length4 = length(xy[3], xy[0]);
//            printf("%lf, %lf, %lf, %lf \n", length1, length2, length3, length4);
            if (length1 == length2 && length2 == length3 && length3 == length4){ // Rohmbus
                cout << "Case " << (i+1) << ": Rhombus\n";
            } else if (length1 == length3 && length2 == length4) { // parallelogram
                cout << "Case " << (i+1) << ": Parallelogram\n";
            } else if (grad1 == gradient(xy[2], xy[3]) || grad2 == gradient(xy[3], xy[0])) { //trapezium
                cout << "Case " << (i+1) << ": Trapezium\n";
            } else {
                cout << "Case " << (i+1) << ": Ordinary Quadrilateral\n";
            }
        }
    }
}
