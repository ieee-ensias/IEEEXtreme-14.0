/*
 IEEEXtreme 14.0 solutions

 Authors: team TLE - https://github.com/mhamedouadghiri - https://github.com/aaiit

 Verdict: 80.36 points (100%)
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLife2020 implements Runnable {
    private void solve() throws IOException {
        String[] rules = nextLine().split(";");
        int n = nextInt();
        int m = nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        String ruleEmpty = rules[0];
        String ruleAlive = rules[1];
        List<Integer> e1pos = new ArrayList<>();
        List<Integer> a1pos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (ruleEmpty.charAt(i) == '1') {
                e1pos.add(i + 1);
            }
        }
        for (int i = 0; i < 5; i++) {
            if (ruleAlive.charAt(i) == '1') {
                a1pos.add(i + 1);
            }
        }

        int[][] nextGrid = new int[n][n];

        for (int iter = 0; iter < m; iter++) {
            for (int x = 0; x <= n; x++) {
                for (int y = 0; y <= n; y++) {
                    int aliveNeighbors = 0;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i * j == 0) {
                                aliveNeighbors += grid[(x + i + n) % n][(y + j + n) % n];
                            }
                        }
                    }
                    aliveNeighbors -= grid[x % n][y % n];


                    // update the grid
                    if (grid[x % n][y % n] == 0) {
                        for (Integer e1po : e1pos) {
                            if (e1po - 1 == aliveNeighbors) {
                                nextGrid[x % n][y % n] = 1;
                                break;
                            }
                        }
                    } else if (grid[x % n][y % n] == 1) {
                        for (Integer a1po : a1pos) {
                            if (a1po - 1 == aliveNeighbors) {
                                nextGrid[x % n][y % n] = 1;
                                break;
                            }
                        }
                    }
                }
            }

            if (iter == m - 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        pw.print(nextGrid[i][j]);
                    }
                    pw.println();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = nextGrid[i][j];
                    nextGrid[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        new GameOfLife2020().run();
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
