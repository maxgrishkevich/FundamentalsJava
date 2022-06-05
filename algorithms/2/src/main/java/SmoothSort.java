import java.util.Arrays;

public class SmoothSort {
    private static int[] leonardoMemo = { 1, 1 };

    public static int leonardo(int n) {
        if (n < leonardoMemo.length) {
            if (leonardoMemo[n] != 0) {
                return leonardoMemo[n];
            }
        } else {
            int newLength = leonardoMemo.length * 2;
            leonardoMemo = Arrays.copyOf(leonardoMemo,
                    (newLength > n) ? newLength : (n + 1));
        }
        return leonardoMemo[n] = leonardo(n - 1)
                + leonardo(n - 2) + 1;
    }

    private static void sift(Integer[] v, int head,
    int exp) {
        Integer t = v[head];
        while (exp > 1) {
            int r = head - 1;
            int l = head - 1 - leonardo(exp - 2);
            if (t.compareTo(v[l]) >= 0 &&
                    t.compareTo(v[r]) >= 0) {
                break;
            }
            if (v[l].compareTo(v[r]) >= 0) {
                v[head] = v[l];
                head = l;
                exp -= 1;
            } else {
                v[head] = v[r];
                head = r;
                exp -= 2;
            }
        }
        v[head] = t;
    }

    private static void arrange(Integer [] v,
    int head, long frac, int exp) {
        Integer t = v[head];
        while (frac > 1) {
            int next = head - leonardo(exp);
            if (t.compareTo(v[next]) >= 0) {
                break;
            }
            if (exp > 1) {
                int r = head - 1;
                int l = head - 1 - leonardo(exp - 2);
                if (v[l].compareTo(v[next]) >= 0
                        || v[r].compareTo(v[next]) >= 0) {
                    break;
                }
            }
            v[head] = v[next];
            head = next;
            int trail = Long.numberOfTrailingZeros(frac - 1);
            frac >>>= trail;
            exp += trail;
        }
        v[head] = t;
        sift(v, head, exp);
    }

    public void sort(Integer[] v) {
        if (v.length == 0) return;
        int head = 0;
        long frac = 0;
        int exp = 0;
        while (head < v.length) {
            if ((frac & 3) == 3) {
                frac >>>= 2;
                exp += 2;
            } else if (exp > 1) {
                frac <<= exp - 1;
                exp = 1;
            } else {
                frac <<= exp;
                exp ^= 1;
            }
            frac++;
            if (exp > 0 && v.length - head - 1 <
                    leonardo(exp - 1) + 1) {
                arrange(v, head, frac, exp);
            }
            sift(v, head, exp);
            head++;
        }
        arrange(v, head - 1, frac, exp);
        while (head > 0) {
            head--;
            if (exp > 1) {
                frac <<= 2;
                frac--;
                exp -= 2;
                arrange(v, head - leonardo(exp) - 1, frac >> 1, exp + 1);
                arrange(v, head - 1, frac, exp);
            } else {
                int trail = Long.numberOfTrailingZeros(frac - 1);
                frac >>= trail;
                exp += trail;
            }
        }
    }

}

