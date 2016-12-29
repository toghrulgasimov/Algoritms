package strings;

import datastructure.SparsaTable;
import java.util.Arrays;

public class SuffixArray {

    public int[][] suffixrank;//  using namespace std   int main using namespace syd
    public Tuple[] T;
    public int[] lcp;
    public int n;
    public int stp;

    public class Tuple implements Comparable<Tuple> {

        public int orgigindex;
        public int firstHalf, secondHalf;

        @Override
        public int compareTo(Tuple t) {
            if (this.firstHalf == t.firstHalf) {
                return Integer.compare(this.secondHalf, t.secondHalf);
            } else {
                return Integer.compare(this.firstHalf, t.firstHalf);
            }
        }
    }

    public SuffixArray(String s) {
        n = s.length();
        suffixrank = new int[30][n];
        T = new Tuple[n];

        for (int i = 0; i < n; i++) {
            suffixrank[0][i] = s.charAt(i) - 'a';
            T[i] = new Tuple();
        }
        for (int cnt = 1, stp = 1; cnt < n; cnt *= 2, stp++) {
            this.stp = stp;
            for (int i = 0; i < n; i++) {
                T[i].firstHalf = suffixrank[stp - 1][i];
                T[i].secondHalf = i + cnt < n ? suffixrank[stp - 1][i + cnt] : -1;
                T[i].orgigindex = i;
            }
            Arrays.sort(T);
            suffixrank[stp][T[0].orgigindex] = 0;
            for (int i = 1, currRank = 0; i < n; i++) {
                if (T[i].firstHalf != T[i - 1].firstHalf || T[i].secondHalf != T[i - 1].secondHalf) {
                    currRank++;
                }
                //System.out.println(stp + " " + cnt);
                suffixrank[stp][T[i].orgigindex] = currRank;
            }
        }

    }

    public void computeLCP(String s) {
        lcp = new int[n];
        lcp[0] = 0;
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (suffixrank[stp][i] != 0) {
                int j = T[suffixrank[stp][i] - 1].orgigindex;
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) {
                    h++;
                }
                lcp[suffixrank[stp][i]] = h;
                if (h > 0) {
                    h--;
                }
            }
        }

    }

    public int getPreffix(int i, int j) {
        SparsaTable t = new SparsaTable(n);
        t.init(lcp);
        int l = suffixrank[stp][i], r = suffixrank[stp][j];
        if (l > r) {
            int tmp = l;
            l = r;
            r = tmp;
        }
        if(l == r) return n - i;
        return t.get(l + 1, r);
    }
    public long disticsubstring() {
        long ans = this.n - this.T[0].orgigindex;
        for(int i = 1; i < this.n; i++) {
            ans += (this.n - this.T[i].orgigindex - this.lcp[i]);
        }
        return ans;
    }
}
