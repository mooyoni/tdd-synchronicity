package io.hhplus.tdd.point.exception;

public class InsufficientPointException extends RuntimeException {
    private final long currentPoint;
    private final long requestedAmount;

    public InsufficientPointException(long currentPoint, long requestedAmount) {
        super(String.format("You has insufficient points. Current: %d, Requested: %d",
                currentPoint, requestedAmount));
        this.currentPoint = currentPoint;
        this.requestedAmount = requestedAmount;
    }

    public long getCurrentPoint() {
        return currentPoint;
    }

    public long getRequestedAmount() {
        return requestedAmount;
    }

}
