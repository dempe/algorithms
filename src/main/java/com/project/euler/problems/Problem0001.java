package com.project.euler.problems;

import com.project.euler.AbstractBaseResult;
import com.project.euler.Problem;
import com.project.euler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.project.euler.util.Math.isNegative;
import static com.project.euler.util.Math.sumIntegersTill;

@Lazy
@Component
public class Problem0001 implements Problem {
    private static int NUMBER = 1000;
    private static int FIZZ = 3;
    private static int BUZZ = 5;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            int result = 0;

            for (int i = 0; i < NUMBER; i++) {
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
            final int numberOfTimesDivisibleByFizz = (NUMBER - 1) / FIZZ;  //subtract 1, b/c problem specifies strictly *below* 1000
            final int numberOfTimesDivisibleByBuzz = (NUMBER - 1) / BUZZ;
            final int numberOfTimesDivisibleByProduct = (NUMBER - 1) / fizzBuzzProduct;
            final int fizzSum = (sumIntegersTill(isNegative(numberOfTimesDivisibleByFizz) ? 0 : numberOfTimesDivisibleByFizz) * FIZZ);  //if not divisible, result could be negative - check & set to 0 if so
            final int buzzSum = (sumIntegersTill(isNegative(numberOfTimesDivisibleByBuzz) ? 0 : numberOfTimesDivisibleByBuzz) * BUZZ);
            final int prodSum = (sumIntegersTill(isNegative(numberOfTimesDivisibleByProduct) ? 0 : numberOfTimesDivisibleByProduct) * fizzBuzzProduct);

            return fizzSum + buzzSum - prodSum;
        }
    }

}
