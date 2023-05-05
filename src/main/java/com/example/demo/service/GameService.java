package com.example.demo.service;

import com.example.demo.common.PageDto;
import com.example.demo.dto.GameDto;

public interface GameService {

    PageDto<GameDto> getList(Integer pageIndex, Integer pageSize, String keyWord);
}
