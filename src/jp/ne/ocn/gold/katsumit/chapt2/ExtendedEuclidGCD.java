/*
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
 * 最大公約数を求めるアルゴリズム
 * 拡張ユークリッド互除法
 *
 * @author k.takushima
 */
public class ExtendedEuclidGCD {

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
        throw new IllegalArgumentException();
    }
    
}
