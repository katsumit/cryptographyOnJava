/*
 * Javaで作って学ぶ暗号技術
 * http://www.amazon.co.jp/Java%E3%81%A7%E4%BD%9C%E3%81%A3%E3%81%A6%E5%AD%A6%E3%81%B6%E6%9A%97%E5%8F%B7%E6%8A%80%E8%A1%93-RSA-SHA%E3%81%AE%E5%9F%BA%E7%A4%8E%E3%81%8B%E3%82%89SSL%E3%81%BE%E3%81%A7-%E7%A5%9E%E6%B0%B8-%E6%AD%A3%E5%8D%9A/dp/4627847610
 * 
 * 第2章　公開鍵暗号RSA 計算方法
 * 
 * Copyright 2016 k.takushima.
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
 * 指数計算（逆数計算）
 *
 * @author k.takushima
 */
public class ModInverse {

    private BigInteger d;
    
    private BigInteger gcd;
    
    /**
     * 
     * [STEP 1]　変数初期化 <br>
     * [STEP 2]　指数計算ループ
     * [STEP 3]　剰余計算<br>
     * [STEP 4]　パラメータ再計算<br>
     * [STEP 3]　変数再設定<br>
     *
     * @param e
     * @param l
     * @return gcd(e, l)
     */
    public BigInteger gcd(BigInteger e, BigInteger l){
        // [STEP1]
        if(e.signum() != 1 || l.signum() != 1) {
            throw new IllegalArgumentException();
        }
        BigInteger dPrev = BigInteger.ONE;
        BigInteger d = BigInteger.ZERO;
        BigInteger rPrev = e;
        BigInteger r = l;
        
        // [STEP2]
        while(!r.equals(BigInteger.ZERO)) {
            // [STEP3]
            BigInteger dNext = rPrev.divide(r);
            BigInteger rNext = rPrev.remainder(l);
            
            //  [STEP4]
            BigInteger xNext = dPrev.subtract(dNext.multiply(d));
            
            // [STEP5]
            dPrev  = d;
            d = xNext;
            rPrev = r;
            r = rNext;
        }
        this.d= d;
        this.gcd = dPrev.mod(l);
        
        return dPrev.mod(l);
    }

    /**
     * @return the d
     */
    public BigInteger getD() {
        return d;
    }

    /**
     * @return the gcd
     */
    public BigInteger getGcd() {
        return gcd;
    }
}
