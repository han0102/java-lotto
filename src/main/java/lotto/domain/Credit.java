package lotto.domain;

import calculator.PositiveNumber;

/**
 * @author han
 */
public class Credit {
    private static final int price = 1_000;
    private final PositiveNumber number;

    private Credit(PositiveNumber positiveNumber) {
        this.number = positiveNumber;
    }

    public Credit(String input) {
        this(new PositiveNumber(Integer.parseInt(input) / price));
    }

    public int getLottoCount() {
        return number.getNumber();
    }

    public int getPurchaseAmount() {
        return number.getNumber() * price;
    }
}
