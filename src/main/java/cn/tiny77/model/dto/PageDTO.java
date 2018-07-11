package cn.tiny77.model.dto;

import lombok.Data;

@Data
public class PageDTO {

    private int page;

    private int pageSize;

    public int getOffset(){
        return (page - 1)*pageSize;
    }

}
