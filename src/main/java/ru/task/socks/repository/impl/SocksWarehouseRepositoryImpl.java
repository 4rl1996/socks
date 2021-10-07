package ru.task.socks.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.task.socks.model.entity.SocksEntity;
import ru.task.socks.repository.SocksWarehouseRepository;

@Repository
public class SocksWarehouseRepositoryImpl implements SocksWarehouseRepository {

    private JdbcTemplate jdbcTemplate;

    public SocksWarehouseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void socksIncome(SocksEntity socks) {
        jdbcTemplate.update("insert into socks (color, cotton_part, quantity) " +
                        "values (?, ?, ?) on conflict (color, cotton_part) do update "
                        + "set quantity = socks.quantity + ?",
                socks.getColor(),
                socks.getCottonPart(),
                socks.getQuantity(),
                socks.getQuantity());
    }

    @Override
    public void socksOutcome(SocksEntity socks) {
        jdbcTemplate.update("update socks set quantity = socks.quantity - ? where (color = ? and cotton_part = ?)",
                socks.getQuantity(),
                socks.getColor(),
                socks.getCottonPart());
    }

    @Override
    public Long getSocksQuantityByParams(String color, String operation, Integer cottonPart) {
        switch (operation) {
            case "moreThan":
                return jdbcTemplate.queryForObject("select sum(quantity) from socks " +
                                "where (color = ? and cotton_part > ?)",
                        Long.class,
                        color,
                        cottonPart);
            case "lessThan":
                return jdbcTemplate.queryForObject("select sum(quantity) from socks " +
                                "where (color = ? and cotton_part < ?)",
                        Long.class,
                        color,
                        cottonPart);
            case "equal":
                return jdbcTemplate.queryForObject("select sum(quantity) from socks " +
                                "where (color = ? and cotton_part = ?)",
                        Long.class,
                        color,
                        cottonPart);
            default:
                return 0L;
        }
    }
}
