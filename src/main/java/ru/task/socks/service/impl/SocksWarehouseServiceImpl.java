package ru.task.socks.service.impl;

import org.springframework.stereotype.Service;
import ru.task.socks.exceptionHandler.SocksCustomException;
import ru.task.socks.model.dto.SocksDTO;
import ru.task.socks.repository.SocksWarehouseRepository;
import ru.task.socks.service.SocksWarehouseService;
import ru.task.socks.service.mapper.SocksMapper;

@Service
public class SocksWarehouseServiceImpl implements SocksWarehouseService {

    private final SocksWarehouseRepository socksWarehouseRepository;

    private final SocksMapper socksMapper;

    public SocksWarehouseServiceImpl(SocksWarehouseRepository socksWarehouseRepository, SocksMapper socksMapper) {
        this.socksWarehouseRepository = socksWarehouseRepository;
        this.socksMapper = socksMapper;
    }

    @Override
    public void socksIncome(SocksDTO socksDTO) throws SocksCustomException {
        if (socksDTO.getQuantity() < 1) {
            throw new SocksCustomException();
        }
        if (socksDTO.getCottonPart() < 0 || socksDTO.getCottonPart() > 100) {
            throw new SocksCustomException();
        }
        socksWarehouseRepository.socksIncome(socksMapper.dtoToEntity(socksDTO));
    }

    @Override
    public void socksOutcome(SocksDTO socksDTO) throws SocksCustomException {
        if (socksDTO.getQuantity() < 1) {
            throw new SocksCustomException();
        }
        if (socksDTO.getCottonPart() < 0 || socksDTO.getCottonPart() > 100) {
            throw new SocksCustomException();
        }
        socksWarehouseRepository.socksOutcome(socksMapper.dtoToEntity(socksDTO));
    }

    @Override
    public Long getSocksQuantityByParams(String color, String operation, Integer cotonPart) throws SocksCustomException {
        if (color == null) {
            throw new SocksCustomException();
        }
        if (operation == null) {
            throw new SocksCustomException();
        }
        if (cotonPart == null || cotonPart < 0 || cotonPart > 100) {
            throw new SocksCustomException();
        }
        return socksWarehouseRepository.getSocksQuantityByParams(color, operation, cotonPart);
    }
}


