package com.xp.rps;

public class RPS {
    public static Result play(Throw p1,Throw p2){
        if(p1.equals(Throw.SCISSOR) & p2.equals(Throw.PAPER)) return Result.P1_WINS;
        if(p1.equals(Throw.SCISSOR) & p2.equals(Throw.ROCK)) return Result.P2_WINS;
        if(p1.equals(Throw.SCISSOR) & p2.equals(Throw.SCISSOR)) return Result.DRAW;
        if(p1.equals(Throw.ROCK) & p2.equals(Throw.SCISSOR)) return Result.P1_WINS;
        if(p1.equals(Throw.ROCK) & p2.equals(Throw.PAPER)) return Result.P2_WINS;
        if(p1.equals(Throw.ROCK) & p2.equals(Throw.ROCK)) return Result.DRAW;
        if(p1.equals(Throw.PAPER) & p2.equals(Throw.ROCK)) return Result.P1_WINS;
        if(p1.equals(Throw.PAPER) & p2.equals(Throw.SCISSOR)) return Result.P2_WINS;
        if(p1.equals(Throw.PAPER) & p2.equals(Throw.PAPER)) return Result.DRAW;

       return Result.DRAW;
    }

}
