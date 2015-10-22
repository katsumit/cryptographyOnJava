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
 * 最大公約数を求めるアルゴリズム
 * バイナリー・ユークリッド互除法
 *
 * @author k.takushima
 */
public class GCDBinaryEucrid {

    /**
     * 
     * [STEP 1]g=1とおく．<br>
     * [STEP 2]a>0が満たされる間、以下を繰り返し:<br>
     *      [STEP 2-1] aが偶数であり、かつbも偶数であるとき、a=a/2、b=b/2、
     *      g=2gとして、STEP2に戻る。<br>
     *      [STEP 2-2] aが偶数であり、かつbが奇数であるとき、a=a/2とし、STEP2に戻る。<br>
     *      [STEP 2-3] aが奇数であり、かつbが偶数であるとき、b=b/2とし、STEP2に戻る。<br>
     *      [STEP 2-4] aが奇数であり、かつbも奇数であるとき、t=|a-b|/2に対し、
     *      もし、a>=bであれば、a=tとし、a<bであれば、b=tとしてSTEP2に戻る。<br>
     * [STEP 3]g=gbを出力する<br>
     * @param a
     * @param b
     * @return gcd(a, b)
     */
public BigInteger gcd(BigInteger a, BigInteger b){
        if(a.signum() != 1 || b.signum() != 1) {
            throw new IllegalArgumentException();                    
        }
        // [STEP 1]
        int g = 0;
        // [STEP 2]
        while(a.signum() > 0) {
            boolean aIsOdd = a.testBit(0);
            boolean bIsOdd = b.testBit(0);
            // [STEP 2-1]
            if((!aIsOdd && !bIsOdd)) {
                a = a.shiftRight(1);
                b = b.shiftRight(1);
                g++;
            // [STEP 2-2]
            } else if((!aIsOdd && bIsOdd)) {
                a = a.shiftRight(1);
            // [STEP 2-3]
            } else if (aIsOdd && !bIsOdd) {
                b = b.shiftRight(1);
            // [STEP 2-4]
            } else if (aIsOdd && bIsOdd) {
                if(a.compareTo(b) >= 0) {
                    a = a.subtract(b).shiftRight(1);
                } else {
                    b = b.subtract(a).shiftRight(1);
                }
            }
        }
        return b.shiftLeft(g);
    }
}
