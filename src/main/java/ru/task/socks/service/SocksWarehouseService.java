package ru.task.socks.service;

import ru.task.socks.exceptionHandler.SocksCustomException;
import ru.task.socks.model.dto.SocksDTO;

public interface SocksWarehouseService {

    void socksIncome(SocksDTO socksDTO) throws SocksCustomException;

    void socksOutcome(SocksDTO socksDTO) throws SocksCustomException;

    Long getSocksQuantityByParams(String color, String operation, Integer cotonPart) throws SocksCustomException;
}
