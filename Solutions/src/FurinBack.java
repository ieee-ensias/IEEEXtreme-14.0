/*
 IEEEXtreme 14.0 solutions

 Authors: team TLE - https://github.com/mhamedouadghiri - https://github.com/aaiit

 Verdict: 48.08 points (50%)
 */

import java.io.*;

/***
 * The given program (weird looking string...) is basically written in
 * an esoteric language https://en.wikipedia.org/wiki/Brainfuck (an acquired taste ;)),
 * and the purpose is to return the output as if the input is processed by this program.
 *
 * The interpret function needs to be optimised in order to get a perfect success rate;
 * this version Exceeds the Time Limit -TLE- in the official competition in 2 out of 4 tests
 * 3696ms ie. 16ms slower than the max time allowed!
 * First step may be optimising the loops, inc and dec the data pointer.
 */
public class FurinBack implements Runnable {
    private static StringBuilder answer = new StringBuilder();

    private void solve() throws IOException {
        String program = ">,<>>,>,<[->->+<><<]+->>[-<<+>>]<+-><><<<[-+->-<+-<+>]<[->+<]><>>>>>><>++->>+->>>>>+[>><>>>[-]<[-<>-+]<<>[-+-]-++-+-<[-]<><<>[+---+]<><<<<+-<<<<>-+<><<<><+-<<[->>>>>>>+>>>>>-+>+<<<><<<><<<<<<<<<]>[->>>>><><>><>>+>>>>>>+<<<<<><<<<<+-<<<<]>[->>>>>>><>+>>>>-+><>>+<<<<<<+-<<<<><<<<-+><]>>-++-+>+-+[<-]<[->><>++-<<<]>>>>[-<<<+--+<<<<+>><>>>>>>]>[-<<-+<<<<<+<>>+->>>>>>]>[-<<<<><<<><<+>>>>>>>]>>>>>><>>+[-<<<<+--+<><+-<<<<<<[->>+>>+<<<<]+->[->>+>>+-+<<<<]>[-<<+>>]>[-<<+>>]+[[<>-]-++>[<-]<+-[+--><>><>-<<<]>>-+->>>+>[<-]<+-[->+>[-<-]<[>>[-<<-+->]-<<[->><->+->-+-<<<<]]<]>>-<<<<<+>[><<-]<[>+->[-+<<->]<<[<]]>-+-]>>>>><>>>><>+]-<<<>+-<<<>+>-++[<-]<[-+>>+[<<<>->-+]<<[>>>+[<-+<<->>]<<<[<]]]>-]>>>>[-]<<<<<<<-+<><<<<<<<[-]>>+>+[<-]<[->>+<><<<]>+>[<-]<[>>[<<->]<<[<]]>-[+>>>>>>><++-+++++++++<<<<<<+>+-[<<>-]<[>>[<<->]<<[<]]>-[++>[<-]<[->>-<<<]>>->>+>>+>-[<-]<[<<[->>>+<<><<]+->>>>>+>+[<><-]<><[->>+<<<]<<-<]<<<<+>[<-]<[>>[<<->]<<[<]]>-]>>++++++++[->++++++<]>[-<<<<+>>>>]>>>>>+><>-+[<-]<[>>[<<->]<<[<]]>-[++>[<-]<[->>-<<<]>>-<<<<<<<<+>+[<-]<[->>+<<<]>>>>>>>>+>[<-]<[>>[<<->]<<[<]]>-]<<[-]<<<<<+>[<-]<[>>[<<->]<<[<]]>-]<<[.<]!";

        int t = nextInt();
        while (t-- != 0) {
            char[] inputChars = nextLine().toCharArray();
            interpret(program, inputChars);
            pw.println(answer);
            answer = new StringBuilder();
        }
    }

    private static int ptr;
    private static final int length = 65535;
    private static final byte[] memory = new byte[length];

    private void interpret(String s, char[] chars) {
        int charCount = 0;
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '>') {
                if (ptr == length - 1)
                    ptr = 0;
                else
                    ptr++;
            } else if (s.charAt(i) == '<') {
                if (ptr == 0)
                    ptr = length - 1;
                else
                    ptr--;
            } else if (s.charAt(i) == '+')
                memory[ptr]++;
            else if (s.charAt(i) == '-')
                memory[ptr]--;
            else if (s.charAt(i) == '.')
                answer.append((char) (memory[ptr]));
            else if (s.charAt(i) == ',') {
                memory[ptr] = (byte) (chars[charCount++]);
            } else if (s.charAt(i) == '[') {
                if (memory[ptr] == 0) {
                    i++;
                    while (c > 0 || s.charAt(i) != ']') {
                        if (s.charAt(i) == '[')
                            c++;
                        else if (s.charAt(i) == ']')
                            c--;
                        i++;
                    }
                }
            } else if (s.charAt(i) == ']') {
                if (memory[ptr] != 0) {
                    i--;
                    while (c > 0 || s.charAt(i) != '[') {
                        if (s.charAt(i) == ']')
                            c++;
                        else if (s.charAt(i) == '[')
                            c--;
                        i--;
                    }
                    i--;
                }
            }
        }
    }


    public static void main(String[] args) {
        new FurinBack().run();
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
