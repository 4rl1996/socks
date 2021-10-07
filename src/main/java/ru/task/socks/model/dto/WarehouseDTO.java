package ru.task.socks.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class WarehouseDTO {

    @NotBlank
    private String color;

    @NotBlank
    private String operation;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private Integer cottonPart;

    public WarehouseDTO() {
    }

    public WarehouseDTO(String color, String operation, Integer cottonPart) {
        this.color = color;
        this.operation = operation;
        this.cottonPart = cottonPart;
    }

    public String getColor() {
        return color;
    }

    public String getOperation() {
        return operation;
    }

    public Integer getCottonPart() {
        return cottonPart;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setCottonPart(Integer cottonPart) {
        this.cottonPart = cottonPart;
    }
}
