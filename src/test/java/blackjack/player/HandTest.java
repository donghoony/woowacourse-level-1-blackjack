package blackjack.player;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.card.Card;
import blackjack.card.Number;
import blackjack.card.Shape;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandTest {

    @Test
    @DisplayName("플레이어의 점수를 계산한다.")
    void calculateScoreTest() {
        // given
        List<Card> cards = List.of(
                new Card(Shape.SPADE, Number.KING),
                new Card(Shape.HEART, Number.EIGHT)
        );
        Hand hand = new Hand(cards);
        // when, then
        assertThat(hand.getScore()).isEqualTo(18);
    }

    @Test
    @DisplayName("플레이어의 점수를 계산할 때, Ace의 점수를 유리한 방향(11)으로 결정한다.")
    void calculateAceAsElevenTest() {
        // given
        List<Card> cards = List.of(
                new Card(Shape.HEART, Number.TEN),
                new Card(Shape.CLOVER, Number.ACE)
        );
        Hand hand = new Hand(cards);
        // when, then
        assertThat(hand.getScore()).isEqualTo(21);
    }

    @Test
    @DisplayName("플레이어의 점수를 계산할 때, Ace의 점수를 유리한 방향(1)으로 결정한다.")
    void calculateAceAsOneTest() {
        // given
        List<Card> cards = List.of(
                new Card(Shape.HEART, Number.TEN),
                new Card(Shape.CLOVER, Number.ACE),
                new Card(Shape.DIAMOND, Number.TEN)
        );
        Hand hand = new Hand(cards);
        // when, then
        assertThat(hand.getScore()).isEqualTo(21);
    }
}
