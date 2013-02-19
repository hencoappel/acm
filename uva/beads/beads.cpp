#include <fstream>
#include <iostream>
#include <string>
#include <algorithm>
#include <cstdio>
using namespace std;

int find_best_break(string beads) {
    int num_beads = beads.length();

    int len, best, id, prev, w, oldw;
    len = best = id = prev = oldw = w = 0;

    beads = beads + beads;
    char c;

    for (int i = 0; i <= num_beads;) {
        c = beads[i];
        while (c == beads[id] || beads[id] == 'w') {
            if (beads[id] == 'w') {
                ++w;
            } else {
                w = 0;
            }
            ++len, ++id;
        }
        if(max(prev + len, best) != best){
            //printf("len %d prev %d best %d new best %d id %d\n", len, prev, best, max(prev + len, best), id);
        }
        best = max(prev + len, best);
        prev = len;
        len = w;
        i = id;
    }

    return min(best, num_beads);
}

int main() {
    ifstream fin("beads4.in");
    ofstream fout("beads.out");

    int n;
    string beads;
    fin >> n >> beads;
    printf("Best break gives %d\n", find_best_break(beads));
    //fout << find_best_break(beads) << endl;
}

