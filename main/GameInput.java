package main;


import java.util.List;

public class GameInput {
    private final List<List<String>> mLandOrder;
    private final List<List<String>> mPositions;
    private final List<List<String>> mMoves;
    private int n;
    private int m;
    private int p;
    private int r;
    public GameInput() {
        mLandOrder = null;
        mPositions = null;
        mMoves = null;
        n = m = 0;
        p = r = 0;
    }

    public GameInput(final int n, final int m,
                     final int p, final int r,
                     final List<List<String>> mLandOrder,
                     final List<List<String>> mPositions,
                     final List<List<String>> mMoves) {
        this.n = n;
        this.m = m;
        this.p = p;
        this.r = r;
        this.mLandOrder = mLandOrder;
        this.mPositions = mPositions;
        this.mMoves = mMoves;
    }

    public final List<List<String>> getLand() {
        return mLandOrder;
    }

    public final List<List<String>> getPositions() {
        return mPositions;
    }

    public final List<List<String>> getMoves() {
        return mMoves;
    }

    public final int getN() {
        return n;
    }

    public final int getM() {
        return m;
    }

    public final int getR() {
        return r;
    }

    public final int getP() {
        return p;
    }
}