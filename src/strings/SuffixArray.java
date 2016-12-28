package strings;

import java.util.Arrays;

public class SuffixArray {

    public int[] suffixrank;//  using namespace std   int main using namespace syd
    public Tuple[] T;

    public class Tuple implements Comparable<Tuple> {

        int orgigindex;
        int firstHalf, secondHalf;

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
        int n = s.length();
        suffixrank = new int[n];
        T = new Tuple[n];
        for (int i = 0; i < n; i++) {
            suffixrank[i] = s.charAt(i) - 'a';
            T[i] = new Tuple();
        }
        for (int cnt = 1, stp = 1; cnt < n; cnt *= 2, stp++) {
            for (int i = 0; i < n; i++) {
                T[i].firstHalf = suffixrank[i];
                T[i].secondHalf = i + cnt < n ? suffixrank[i + cnt] : -1;
                T[i].orgigindex = i;
            }
            // sortieren
            int[] C = new int[27];
            Tuple[] b = new Tuple[n];
            for(int i = 0; i < n; i++) C[T[i].secondHalf + 1]++;
            for(int i = 1; i < 27; i++) C[i] += C[i - 1];
            for(int i = n - 1; i >= 0; i--) b[--C[T[i].secondHalf + 1]] = T[i];
            T = b;
            
            C = new int[27];
            b = new Tuple[n];
            for(int i = 0; i < n; i++) C[T[i].firstHalf + 1]++;
            for(int i = 1; i < 27; i++) C[i] += C[i - 1];
            for(int i = n - 1; i >= 0; i--) b[--C[T[i].firstHalf + 1]] = T[i];
            T = b;
            //endsortieren
            // newrank
            int[] nrank = new int[n];
            nrank[T[0].orgigindex] = 0;
            for (int i = 1, currRank = 0; i < n; i++) {
                if (T[i].firstHalf != T[i - 1].firstHalf || T[i].secondHalf != T[i - 1].secondHalf) {
                    currRank++;
                }
                //System.out.println(stp + " " + cnt);
                nrank[T[i].orgigindex] = currRank;
            }
            suffixrank = nrank;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(T[i].orgigindex + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(suffixrank[i] + " ");
        }
    }
}
