package chapter1_fundamentals;

public class H_ImmutableHolder {
    /*
    This tells us why defensive copying makes the object immutable.

    Because we use defensive copying in OneValueCache,
    instead of assigning the incoming array directly (which is mutable), it creates a copy.
    This prevetnts the caller from modifying the internal array after the object is created.
    Without this code, the user can do as below:

    BigInteger[] input = { BigInteger.ONE };
    OneValueCache cache = new OneValueCache(BigInteger.TWO, input);
    input[0] = BigInteger.ZERO; // This would modify the internal state if not copied

    Same applies for defensive copying in getter.
    Without this defensive coding, the user can do as below:

    BigInteger[] factors = cache.getFactors(BigInteger.TWO);
    factors[0] = BigInteger.ZERO; // This would mutate internal state if not copied

     */

}
