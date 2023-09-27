package com.chrisdempewolf.projecteuler.problems;

import com.chrisdempewolf.projecteuler.AbstractBaseResult;
import com.chrisdempewolf.projecteuler.Problem;
import com.chrisdempewolf.projecteuler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.chrisdempewolf.projecteuler.util.Math.sumIntegersTill;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
@Lazy
@Component
public class Problem0001 implements Problem {
    private static final int TARGET_NUMBER = 1000;
    private static final int FIZZ = 3;
    private static final int BUZZ = 5;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            int result = 0;

            for (int i = 0; i < TARGET_NUMBER; i++) {
                if (i % FIZZ == 0 || i % BUZZ == 0) {
                    result += i;
                }
            }

            return result;
        }

        /**
         * This method makes heavy use of the Gaussian function to sum integers within a range i.e.:  ((n + 1) * n) / 2
         * E.g., to sum integers 1 - 100:  (101 * 100) / 2
         * To get the sum of the numbers divisible by 3 below 100:  (((100 / 3) + 1) * (100 / 3)) / 2
         * Do the same for 5, add the result, and subtract the coincidences (n % 15 == 0)
         */
        @Override
        public Number nonNaively() {
            final int fizzBuzzProduct = FIZZ * BUZZ;  //don't count coincidences twice

            final int numberOfTimesDivisibleByFizz = (TARGET_NUMBER - 1) / FIZZ;  //subtract 1, b/c problem specifies strictly *below* 1000
            final int numberOfTimesDivisibleByBuzz = (TARGET_NUMBER - 1) / BUZZ;
            final int numberOfTimesDivisibleByProduct = (TARGET_NUMBER - 1) / fizzBuzzProduct;

            final int fizzSum = sumIntegersTill(numberOfTimesDivisibleByFizz) * FIZZ;  //if not divisible, result could be negative - check & set to 0 if so
            final int buzzSum = sumIntegersTill(numberOfTimesDivisibleByBuzz) * BUZZ;
            final int prodSum = sumIntegersTill(numberOfTimesDivisibleByProduct) * fizzBuzzProduct;

            return fizzSum + buzzSum - prodSum;
        }
    }

}
