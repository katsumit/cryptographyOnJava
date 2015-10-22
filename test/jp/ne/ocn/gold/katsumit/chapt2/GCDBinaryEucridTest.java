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
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k.takushima
 */
public class GCDBinaryEucridTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void 入力aが負の数の場合例外発生() {
        // Setup
        BigInteger a = BigInteger.valueOf(-1l);
        BigInteger b = BigInteger.TEN;
        BigInteger expected = BigInteger.ZERO;
        // Exercise
        GCDBinaryEucrid sut = new GCDBinaryEucrid();
        BigInteger actual = sut.gcd(a, b);
        // Verify
        fail();
        assertThat(actual, is(expected));
        // TearDown
    }
    @Test(expected = IllegalArgumentException.class)
    public void 入力bが負の数の場合例外発生() {
        // Setup
        BigInteger a = BigInteger.TEN;
        BigInteger b = BigInteger.valueOf(-1l);
        BigInteger expected = BigInteger.ZERO;
        // Exercise
        GCDBinaryEucrid sut = new GCDBinaryEucrid();
        BigInteger actual = sut.gcd(a, b);
        // Verify
        fail();
        assertThat(actual, is(expected));
        // TearDown
    }

    @Test
    public void 入力aが780入力bが660の場合は最大公約数60() {
        // Setup
        BigInteger a = BigInteger.valueOf(780l);
        BigInteger b = BigInteger.valueOf(660l);
        BigInteger expected = BigInteger.valueOf(60l);
        // Exercise
        GCDBinaryEucrid sut = new GCDBinaryEucrid();
        BigInteger actual = sut.gcd(a, b);
        // Verify
        assertThat(actual, is(expected));
        // TearDown
    }

    @Test
    public void 入力aが135632入力bが44461の場合は最大公約数173() {
        // Setup
        BigInteger a = BigInteger.valueOf(135632l);
        BigInteger b = BigInteger.valueOf(44461l);
        BigInteger expected = BigInteger.valueOf(173l);
        // Exercise
        GCDBinaryEucrid sut = new GCDBinaryEucrid();
        BigInteger actual = sut.gcd(a, b);
        // Verify
        assertThat(actual, is(expected));
        // TearDown
    }
    
    @Test
    public void 入力がそこそこ巨大な場合() {
        // Setup
        BigInteger a = BigInteger.valueOf(2l).pow(35)
                .multiply(BigInteger.valueOf(3l).pow(51))
                .multiply(BigInteger.valueOf(5l).pow(76));
        BigInteger b = BigInteger.valueOf(2l).pow(32)
                .multiply(BigInteger.valueOf(3l).pow(53))
                .multiply(BigInteger.valueOf(5l).pow(74));
        BigInteger expected = BigInteger.valueOf(2l).pow(32)
                .multiply(BigInteger.valueOf(3l).pow(51))
                .multiply(BigInteger.valueOf(5l).pow(74));
        // Exercise
        GCDBinaryEucrid sut = new GCDBinaryEucrid();
        BigInteger actual = sut.gcd(a, b);
        // Verify
        assertThat(actual, is(expected));
        // TearDown
    }

    // TODO 10秒以上かかったらOKとしたいけどIgnoreで。
    // パフォーマンス的には試行割り算法と同じみたいなので一旦スキップ。
    // @Ignore
    @Test
    public void 入力がとてつもなく巨大な場合計算に10秒以上かかる() throws Exception {
        // Setup
        BigInteger a = BigInteger.valueOf(2l).pow(35)
                .multiply(BigInteger.valueOf(3l).pow(51))
                .multiply(BigInteger.valueOf(5l).pow(76));
        BigInteger b = BigInteger.valueOf(7l).pow(25)
                .multiply(BigInteger.valueOf(11l).pow(29))
                .multiply(BigInteger.valueOf(13l).pow(49));
        BigInteger expected = BigInteger.valueOf(2l).pow(35)
                .multiply(BigInteger.valueOf(3l).pow(51))
                .multiply(BigInteger.valueOf(5l).pow(76))
                .multiply(BigInteger.valueOf(7l).pow(25))
                .multiply(BigInteger.valueOf(11l).pow(29))
                .multiply(BigInteger.valueOf(13l).pow(49));
        // Exercise
        GCDBinaryEucrid sut = new GCDBinaryEucrid();
        BigInteger actual = sut.gcd(a, b);
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("expected:");
        System.out.println(expected);
        System.out.println("actual:");
        System.out.println(actual);
        System.out.println("Calc by BigInteger:");
        System.out.println(a.gcd(b));
        System.out.println(b.gcd(a));
        // Verify
        assertThat(actual, is(expected));
        // TearDown
    }

}
