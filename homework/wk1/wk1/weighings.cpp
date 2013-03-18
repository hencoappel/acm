#include <iostream>
#include <queue>
#include <set>
using namespace std;

// http://acm.sgu.ru/problem.php?contest=0&problem=230

/*
 * This was not accepted, I couldn't work out how to do it. I tried lots of things.
 * Simple checks such as for circular reference are added. You can't have a solution if
 * 4 > 6 and 6 > 4. If there is no clear start, a node with degree 0, then there can't be
 * a solution. I then do breadthfirst search starting at a node with degree 0. If there
 * are elements that haven't been seen during the breadth first search, then no solution.
 * Then I use topological sort to find a solution. I think that was what I tried.
 */

#define MAX 101

int graph[MAX][MAX];
int deg[MAX];

int main() {
    int n, m;
    cin >> n >> m;
    int j, k;
    set<int> seen;
    for(int i = 0; i < m; i++) {
        cin >> j >> k;
        graph[j][k] = 1;
        // Circular reference
        if(graph[k][j] == 1) {
            cout << "No solution\n";
            return 0;
        }
        deg[k]++;
    }

    queue<int> q;
    queue<int> final;

    for(int i = 1; i <= n; i++){
        if (deg[i] == 0) {
            q.push(i);
        }
    }

    if (q.empty()){
        cout << "No solution\n";
        return 0;
    }

    queue<int> bfs;
    bfs.push(q.front());

    while(!bfs.empty()) {
        int j = bfs.front();
        bfs.pop();
        for(int i = 1; i <= n; i++) {
            if(seen.count(i) == 0 && (graph[j][i] == 1 || graph[i][j] == 1)) {
                bfs.push(i);
            }
        }
        seen.insert(j);
    }

    // Some have not been weighed
    if(seen.size() != n) {
        cout << "No solution\n";
        return 0;
    }


    while(!q.empty()) {
        int temp = q.front();
        q.pop();
        final.push(temp);
        for(int i = 1; i <= n; i++) {
            if(graph[temp][i] == 1 && --deg[i] == 0) {
                q.push(i);
            }
        }
    }

    if(final.size() != n) {
        cout << "No solution\n";
        return 0;
    }

    while(final.size() > 1){
        cout << final.front() << " ";
        final.pop();
    }
    cout << final.front();
    cout << endl;

}
