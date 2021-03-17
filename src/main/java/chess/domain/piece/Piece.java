package chess.domain.piece;

import chess.domain.position.Position;

import java.util.Locale;
import java.util.Objects;

public abstract class Piece {
    private final String name;
    protected final boolean isBlack;

    public Piece(final boolean isBlack, final String initialName) {
        this.isBlack = isBlack;
        if (isBlack) {
            name = initialName.toUpperCase();
            return;
        }
        name = initialName.toLowerCase(Locale.ROOT);
    }

    protected boolean isOpponent(final Piece piece) {
        return isBlack != piece.isBlack;
    }

    public abstract boolean canMove(final Position source, final Position target, final Piece piece);

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(name, piece.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
