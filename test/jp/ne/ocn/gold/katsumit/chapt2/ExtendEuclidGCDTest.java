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
public class ExtendEuclidGCDTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void 入力aが負の数の場合例外発生() {
        // Setup
        BigInteger a = BigInteger.valueOf(-1l);
        BigInteger b = BigInteger.TEN;
        BigInteger expected = BigInteger.ZERO;
        // Exercise
        ExtendedEuclidGCD sut = new ExtendedEuclidGCD();
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
        ExtendedEuclidGCD sut = new ExtendedEuclidGCD();
        BigInteger actual = sut.gcd(a, b);
        // Verify
        fail();
        assertThat(actual, is(expected));
        // TearDown
    }

    @Test
    public void 入力aが2793入力bが828の場合は最大公約数3() {
        // Setup
        BigInteger a = BigInteger.valueOf(2793l);
        BigInteger b = BigInteger.valueOf(828l);
        BigInteger expected = BigInteger.valueOf(3l);
        // Exercise
        ExtendedEuclidGCD sut = new ExtendedEuclidGCD();
        BigInteger actual = sut.gcd(a, b);
        // Verify
        assertThat(actual, is(expected));
        // TearDown
    }    
    @Test
    public void 入力aが828入力bが2793の場合は最大公約数3() {
        // Setup
        BigInteger a = BigInteger.valueOf(828l);
        BigInteger b = BigInteger.valueOf(2793l);
        BigInteger expected = BigInteger.valueOf(3l);
        // Exercise
        ExtendedEuclidGCD sut = new ExtendedEuclidGCD();
        BigInteger actual = sut.gcd(a, b);
        // Verify
        assertThat(actual, is(expected));
        // TearDown
    }    
}
