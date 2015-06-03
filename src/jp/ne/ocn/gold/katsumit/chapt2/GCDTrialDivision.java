/*
 * 第２章　公開鍵暗号RSA 計算方法
 */
package jp.ne.ocn.gold.katsumit.chapt2;

import java.math.BigInteger;

/**
 * 最大公約数を求めるアルゴリズム
 * 試行割り算法
 * 
 * @author k.takushima
 */
public class GCDTrialDivision {

    /**
     * 
     * [STEP 1]<br>
     * g = 1とする. a < b であれば, a, bを入れ替え, a >= b となるようにする.<br>
     * [STEP 2]<br>
     * n = 2とし, n <=bが満たされる間, nを1ずつ増加させつつ以下を繰り返し:<br>
     *      [STEP 2-1]<br>
     *      a, bともにnで割り切れる間, 以下を繰り返し:<br>
     *          [STEP 2-1-1]<br>
     *          g = ng,<br> 
     *          a = a/n, <br>
     *          b = b/n<br>
     * [STEP3]<br>
     * g を出力して終了.
     * 
     * @param a
     * @param b
     * @return gcd(a, b)
     */
    public BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.signum() != 1 || b.signum() != 1) {
            throw new IllegalArgumentException();
        }

        // [STEP 1] 
        BigInteger g = BigInteger.ONE;
        if (a.compareTo(b) < 0) {
            BigInteger t = a;
            a = b;
            b = t;
        }

        // [STEP 2]
        for (BigInteger n = BigInteger.valueOf(2);
                n.compareTo(b) <= 0;
                n = n.add(BigInteger.ONE)) {
            // [STEP 2-1]
            while(a.remainder(n).equals(BigInteger.ZERO)
                    && b.remainder(n).equals(BigInteger.ZERO)) {
                // [STEP 2-1-1]
                g = n.multiply(g);
                a = a.divide(n);
                b = b.divide(n);
            }

        }
        // [STEP 3]
        return g;
    }
}
