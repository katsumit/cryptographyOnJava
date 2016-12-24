/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ne.ocn.gold.katsumit.chapt2;

import java.math.BigInteger;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author k.takushima
 */
public class GCDTrialDivisionTest {

    @Test(expected = IllegalArgumentException.class)
    public void 入力aが負の数の場合例外発生() {
        // Setup
        BigInteger a = BigInteger.valueOf(-1l);
        BigInteger b = BigInteger.TEN;
        BigInteger expected = BigInteger.ZERO;
        // Exercise
        GCDTrialDivision sut = new GCDTrialDivision();
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
        GCDTrialDivision sut = new GCDTrialDivision();
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
        GCDTrialDivision sut = new GCDTrialDivision();
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
        GCDEuclidian sut = new GCDEuclidian();
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
        GCDTrialDivision sut = new GCDTrialDivision();
        BigInteger actual = sut.gcd(a, b);
        // Verify
        assertThat(actual, is(expected));
        // TearDown
    }

    // TODO 10秒以上かかったらOKとしたいけどIgnoreで。
    //@Ignore
    @Test(expected=Exception.class, timeout=1000)
    public void 入力がとてつもなく巨大な場合計算に10秒以上かかる() throws Exception {
        // Setup
        BigInteger a = BigInteger.valueOf(2l).pow(35)
                .multiply(BigInteger.valueOf(3l).pow(51))
                .multiply(BigInteger.valueOf(5l).pow(76));
        BigInteger b = BigInteger.valueOf(7l).pow(25)
                .multiply(BigInteger.valueOf(11l).pow(29))
                .multiply(BigInteger.valueOf(13l).pow(49));
                // a, bは互いに素
        BigInteger expected = BigInteger.ONE;

        // Exercise
        GCDTrialDivision sut = new GCDTrialDivision();
        BigInteger actual = sut.gcd(a, b);
        assertThat(actual, is(expected));

        // Verify
        fail();
        // TearDown
    }

}
