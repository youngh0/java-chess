package view;

import domain.piece.*;

import java.util.Map;

public class OutputView {
    public void printChessBoard(Map<Position, Piece> chessBoard) {
        for (Rank rank : Rank.values()) {
            for (File file : File.values()) {
                Piece piece = chessBoard.get(Position.of(file.getText(), rank.getText()));
                System.out.print(piece.getCategory().getPieceValue());
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printLoadGameMessage() {
        System.out.println("> 게임 새로 시작 : new");
        System.out.println("> 기존 게임 불러오기 : load");
    }

    public void printGameGuideMessage() {
        System.out.println("> 체스 게임을 시작합니다.");
        System.out.println("> 게임 시작 : start");
        System.out.println("> 게임 종료 : end");
        System.out.println("> 게임 이동 : move source위치 target위치 - 예. move b2 b3");
    }

    public void printGameScores(Map<Side, Double> scores) {
        System.out.println("white팀: " + scores.get(Side.WHITE) + "점");
        System.out.println("black팀: " + scores.get(Side.BLACK) + "점");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public void printSide(Side side) {
        System.out.println("현재 차례: " + side + " 진영");
    }

    public void printWinner(Side winner) {
        if (winner == Side.NEUTRAL) {
            System.out.println("무승부입니다.");
            return;
        }
        System.out.println("승자는 " + SideConverter.valueOf(winner.name()) + "입니다.");
    }

    public void printGameSaveMessage() {
        System.out.println("게임을 저장하고 종료합니다.");
    }

    public void printKingDeadMessage(Side side) {
        System.out.println(side + "진영의 King이 죽었습니다.");
    }
}
