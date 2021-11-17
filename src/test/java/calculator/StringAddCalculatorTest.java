package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * @author han
 */
class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource()
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName(value = "하나의 숫자")
    public void splitAndSum_숫자하나() {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "쉼표를 포함한 숫자")
    public void splitAndSum_쉼표구분자() {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName(value = "쉼표와 콜론을 포함한 숫자")
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName(value = "커스텀 구분자를 포함한 숫자")
    public void splitAndSum_custom_구분자() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName(value = "음수")
    public void splitAndSum_negative() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"));
    }

    @Test
    @DisplayName(value = "숫자 이외의 값")
    public void splitAndSum_숫자_이외의_값() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> stringAddCalculator.splitAndSum("a,2,3"));
    }
}
