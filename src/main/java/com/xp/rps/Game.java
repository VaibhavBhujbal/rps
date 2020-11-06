package com.xp.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    int id;
    String player1;
    String player2;
    int roundNo;
    String deision;

    List<Round> roundList = new ArrayList<>();

    public Game() {
    }

    public Game(String player1, String player2, int roundNo, String deision) {
        this.player1 = player1;
        this.player2 = player2;
        this.roundNo = roundNo;
        this.deision = deision;
    }

    public Game(int id, String player1, String player2, int round_no, String decision) {
        this.id=id;
        this.player1=player1;
        this.player2=player2;
        this.roundNo = round_no;
        this.deision = decision;
    }

    public Result getResult(){
        //based on roundList data, to decide the final result
        //
        int p1 = 0;
        int p2 = 0;

        for (Round round: roundList) {
            if(Result.P1_WINS.equals(round.getResult())){
                p1 = p1 + 1;
            }
            if(Result.P2_WINS.equals(round.getResult())){
                p2=p2+1;
            }
            return round.getResult();
        }
        if(p1<p2){
            return Result.P2_WINS;
        }
        else if(p1>p2){
            return Result.P1_WINS;
        }
        else{
            return Result.DRAW;
        }

    }
    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", player1='" + player1 + '\'' +
                ", player2='" + player2 + '\'' +
                ", roundNo=" + roundNo +
                ", deision='" + deision + '\'' +
                ", roundList=" + roundList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id &&
                roundNo == game.roundNo &&
                player1.equals(game.player1) &&
                player2.equals(game.player2) &&
                deision.equals(game.deision) &&
                roundList.equals(game.roundList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, player1, player2, roundNo, deision, roundList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public int getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }

    public String getDeision() {
        return deision;
    }

    public void setDeision(String deision) {
        this.deision = deision;
    }
}
