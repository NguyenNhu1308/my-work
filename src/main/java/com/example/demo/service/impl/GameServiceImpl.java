package com.example.demo.service.impl;

import com.example.demo.common.PageDto;
import com.example.demo.dto.GameDto;
import com.example.demo.service.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Override
    public PageDto<GameDto> getList(Integer pageIndex, Integer pageSize, String keyWord) {
        return null;
    }
}
