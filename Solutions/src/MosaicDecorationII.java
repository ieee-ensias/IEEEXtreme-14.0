/*
 IEEEXtreme 14.0 solutions

 Authors: team TLE - https://github.com/mhamedouadghiri - https://github.com/aaiit

 Verdict: 65.29 points (100%)
 */

import java.io.*;

public class MosaicDecorationII implements Runnable {
    private void solve() throws IOException {
        long w = nextLong();
        long h = nextLong();
        long a = nextLong();
        long b = nextLong();
        long m = nextLong();
        long c = nextLong();

        long x = ((w + a - 1) / a), y = ((h + b - 1) / b);
        long rx = (w % a == 0) ? 0 : w, ry = (h % b == 0) ? 0 : h;
        long r1 = (rx + ry) * c;
        long r2 = ((x * y + 9) / 10) * m;
        pw.println(r1 + r2);
    }

    public static void main(String[] args) {
        new MosaicDecorationII().run();
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
