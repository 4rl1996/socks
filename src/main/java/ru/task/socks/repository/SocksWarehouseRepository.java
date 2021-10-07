package ru.task.socks.repository;

import ru.task.socks.exception.SocksCustomException;
import ru.task.socks.model.entity.SocksEntity;

public interface SocksWarehouseRepository {

    void socksIncome(SocksEntity socks);

    void socksOutcome(SocksEntity socks);

    Long getSocksQuantityByParams(String color, String operation, Integer cotonPart) throws SocksCustomException;
}
