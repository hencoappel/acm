/*
ID: sebasti21
LANG: C++
TASK: beads
*/

#include <algorithm>
#include <fstream>
#include <iostream>
#include <string>

using namespace std;

int main()
{
    ifstream fin("beads3.in");
    ofstream fout("beads.out");

    int n;
    string bead;
    fin >> n >> bead;

    bead = bead + bead;
    int max_len = 0;
    for (int i = 0; i < n; ++i) {
        char c;
        int len = 0;
        int id = i;
        // skip those that are white
        while (id < n + i && bead[id] == 'w') 
            ++id, ++len;
        c = bead[id];
        // going from first to last
        while (id < n + i && (bead[id] == c || bead[id] == 'w'))
            ++id, ++len;

        id = n + i - 1;
        // skip those that are white
        while (id >= i && bead[id] == 'w') 
            --id, ++len;
        c = bead[id];
        // going from last to first
        while (id >= i && (bead[id] == c || bead[id] == 'w'))
            --id, ++len;

        max_len = max(max_len, min(len, n));
    }
    fout << max_len << endl;
    printf("Best break gives %d\n", max_len);

    return 0;
}
