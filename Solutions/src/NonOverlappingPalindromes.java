/*
 IEEEXtreme 14.0 solutions

 Authors: team TLE - https://github.com/mhamedouadghiri - https://github.com/aaiit

 Verdict: 83.42 points (100%)
 */

import java.io.*;

/***
 * One word for you: manachar!
 */
public class NonOverlappingPalindromes implements Runnable {
    String[] ends = new String[2];

    private void solve() throws IOException {
        int T = nextInt();
        while (T-- != 0) {
            String s = nextLine();
            int n = s.length();
            if (n == 2) {
                pw.println(2);
                continue;
            }
            String longest = longest(s, n);
            String longestLeft = longestRunnerUp(ends[0], ends[0].length());
            String longestRight = longestRunnerUp(ends[1], ends[1].length());
            if (longest.length() == n) {  // both palindromes must be non empty
                pw.println(n - 1);
            } else {
                pw.println(longest.length() + Math.max(longestLeft.length(), longestRight.length()));
            }
            ends = new String[2];
        }
    }

    // returns right and left indices of longest palindrome in string S of length n
    private int[] manachar(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        for (int i = 0; i < n; i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#!");
        String modified = sb.toString();
        int len = modified.length();
        int[] P = new int[len];
        int c = 0, r = 0;
        for (int i = 1; i < len - 1; i++) {
            int mir = 2 * c - i;
            if (i < r) {
                P[i] = Math.min(r - i, P[mir]);
            }
            while (modified.charAt(i + 1 + P[i]) == modified.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            if (i + P[i] > r) {
                c = i;
                r = i + P[i];
            }
        }
        int maxLen = 0, center = 0;
        for (int i = 1; i < len - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                center = i;
            }
        }
        int left = (center - 1 - maxLen) / 2;
        int right = maxLen + (center - 1 - maxLen) / 2;
        return new int[]{left, right};
    }

    // longest palindrome in either end
    public String longestRunnerUp(String s, int n) {
        int[] manachar = manachar(s, n);
        int left = manachar[0];
        int right = manachar[1];
        return s.substring(left, right);
    }

    // longest main palindrome, stores the indices in ends[]
    public String longest(String s, int n) {
        int[] manachar = manachar(s, n);
        int left = manachar[0];
        int right = manachar[1];
        ends[0] = (s.substring(0, left));
        ends[1] = (s.substring(right));
        return s.substring(left, right);
    }

    public static void main(String[] args) {
        new NonOverlappingPalindromes().run();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.close();
    }

    private static final PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final int BUFFER_SIZE = 1 << 16;
    private static final DataInputStream din = new DataInputStream(System.in);
    private static final byte[] buffer = new byte[BUFFER_SIZE];
    private static int bufferPointer = 0, bytesRead = 0;

    private static String nextLine() throws IOException {
        byte[] buf = new byte[(int) Math.pow(10, 7)];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.')
            while ((c = read()) >= '0' && c <= '9')
                ret += (c - '0') / (div *= 10);
        if (neg) return -ret;
        return ret;
    }

    private static byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
        return buffer[bufferPointer++];
    }
}
