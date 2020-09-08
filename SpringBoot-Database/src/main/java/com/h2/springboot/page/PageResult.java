package com.h2.springboot.page;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by: huhao
 * Date: 2020/9/8
 */
@Data
public class PageResult<T> {
    List<T> list;
    Long totalRecord;
    int pageNo;
    int pageSize;
    int totalPages;

    public PageResult(Page page) {
        this.list=page.getContent();
        this.totalRecord=page.getTotalElements();
        this.pageNo=page.getNumber();
        this.pageSize=page.getSize();
        this.totalPages=page.getTotalPages();
    }
}
