package io.hhplus.tdd.point.service;

import io.hhplus.tdd.database.PointHistoryTable;
import io.hhplus.tdd.database.UserPointTable;
import io.hhplus.tdd.point.PointHistory;
import io.hhplus.tdd.point.TransactionType;
import io.hhplus.tdd.point.UserPoint;
import io.hhplus.tdd.point.dto.ChargeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PointService {
    private final UserPointTable userPointTable;
    private final PointHistoryTable pointHistoryTable;

    public UserPoint selectById(long userId) {
        return userPointTable.selectById(userId);
    }

    public UserPoint charge(long userId, ChargeRequest request) {
        userPointTable.insertOrUpdate(userId, request.amount());
        pointHistoryTable.insert(userId, request.amount(), TransactionType.CHARGE, Instant.now().toEpochMilli());
        return selectById(userId);
    }

    public List<PointHistory> selectByUserId(long userId) {
        return pointHistoryTable.selectAllByUserId(userId);
    }
}
