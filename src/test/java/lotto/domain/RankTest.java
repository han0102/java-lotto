package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class RankTest {

    @ParameterizedTest(name = "일치하는 갯수의 랭크를 반환")
    @MethodSource("providedRanks")
    void create(int count, Rank rank) {
        assertThat(Rank.of(count)).isEqualTo(rank);
    }

    static Stream<Arguments> providedRanks() {
        return Stream.of(
            Arguments.of(0, Rank.NONE),
            Arguments.of(3, Rank.FORTH),
            Arguments.of(4, Rank.THIRD),
            Arguments.of(5, Rank.SECOND),
            Arguments.of(6, Rank.FIRST)
        );
    }
}