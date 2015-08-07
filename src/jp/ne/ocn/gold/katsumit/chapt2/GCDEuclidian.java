/*
 * Javaで作って学ぶ暗号技術
 * http://www.amazon.co.jp/Java%E3%81%A7%E4%BD%9C%E3%81%A3%E3%81%A6%E5%AD%A6%E3%81%B6%E6%9A%97%E5%8F%B7%E6%8A%80%E8%A1%93-RSA-SHA%E3%81%AE%E5%9F%BA%E7%A4%8E%E3%81%8B%E3%82%89SSL%E3%81%BE%E3%81%A7-%E7%A5%9E%E6%B0%B8-%E6%AD%A3%E5%8D%9A/dp/4627847610
 * 
 * 第2章　公開鍵暗号RSA 計算方法
 * 
 * Copyright 2015 k.takushima.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.ne.ocn.gold.katsumit.chapt2;

import java.math.BigInteger;

/**
 * 最大公約数を求めるアルゴリズム ユークリッドの互除法
 *
 * @author k.takushima
 */
public class GCDEuclidian {

    /**
     *
     * [STEP 1]<br>
     * aをbで割った余りをrとし、r ≠ 0である間、以下を繰り返し: <br>
     *      [STEP 1-1] a = r とする。<br>
     *      [STEP 1-2] aとbを入れ替える。<br>
     * [STEP 2]bを出力して終了する。<br>
     *
     * @param a 正の整数
     * @param b 正の整数
     * @return gcd(a, b)
     */
    public BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.signum() != 1 || b.signum() != 1) {
            throw new IllegalArgumentException();
        }

        for(BigInteger r = a.remainder(b); !r.equals(BigInteger.ZERO); r = a.remainder(b)) {
            a = b;
            b = r;
        }
        return b;
    }
}
