package chess.domain.piece.black;

import chess.domain.piece.Position;
import chess.domain.piece.condition.CatchingPieceBlackPawnMoveCondition;
import chess.domain.piece.condition.FirstTurnBlackPawnMoveCondition;
import chess.domain.piece.condition.MoveCondition;
import chess.domain.piece.condition.NormalBlackPawnMoveCondition;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BlackQueen extends BlackPiece {
    private static final String NOTATION = "Q";

    public BlackQueen(Position position, List<MoveCondition> moveConditions) {
        super(position, moveConditions);
    }

    public static BlackQueen createWithCoordinate(int row, int column) {
        return new BlackQueen(
                new Position(row, column),
                Arrays.asList(
                        new FirstTurnBlackPawnMoveCondition(),
                        new NormalBlackPawnMoveCondition(),
                        new CatchingPieceBlackPawnMoveCondition()
                )
        );
    }

    @Override
    public double getScore() {
        return 9;
    }

    @Override
    public String getNotation() {
        return NOTATION;
    }

    @Override
    public boolean equals(Object o) {
        return isSamePiece(o);
    }

    @Override
    public int hashCode() {
        return toHashCode();
    }

    @Override
    protected boolean isSamePiece(Object o) {
        if (o == this) return true;
        return o instanceof BlackQueen && isSamePosition(((BlackQueen) o).getPosition());
    }

    @Override
    protected int toHashCode() {
        return Objects.hash(NOTATION, "BLACK", getPosition().hashCode());
    }

}
