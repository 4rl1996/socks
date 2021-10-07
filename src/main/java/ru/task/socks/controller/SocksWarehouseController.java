package ru.task.socks.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.task.socks.exception.SocksCustomException;
import ru.task.socks.model.dto.SocksDTO;
import ru.task.socks.service.SocksWarehouseService;

@Controller
@RequestMapping(path = "api/socks")
public class SocksWarehouseController {

    private final SocksWarehouseService socksWarehouseService;

    public SocksWarehouseController(SocksWarehouseService socksWarehouseService) {
        this.socksWarehouseService = socksWarehouseService;
    }

    @PostMapping(path = "/income")
    public ResponseEntity<?> socksIncome(@RequestBody SocksDTO socks) throws SocksCustomException {
        socksWarehouseService.socksIncome(socks);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(path = "/outcome")
    public ResponseEntity<?> socksOutcome(@RequestBody SocksDTO socks) throws SocksCustomException {
        socksWarehouseService.socksOutcome(socks);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping()
    public ResponseEntity<?> param(@RequestParam(value = "color") String color,
                                   @RequestParam(value = "operation") String operation,
                                   @RequestParam(value = "cottonPart") Integer cottonPart) throws SocksCustomException {
        if (socksWarehouseService.getSocksQuantityByParams(color, operation, cottonPart) == null) {
            return ResponseEntity.status(HttpStatus.OK).body("0");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(socksWarehouseService.getSocksQuantityByParams(color, operation, cottonPart)));
        }
    }

}
