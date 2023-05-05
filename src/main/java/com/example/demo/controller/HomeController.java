package com.example.demo.controller;

import com.example.demo.common.PageDto;
import com.example.demo.dto.GameDto;
import com.example.demo.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/users")
@PermitAll
public class HomeController {

    private final GameService _gameService;

    public HomeController(GameService gameService) {
        _gameService = gameService;
    }

    @GetMapping("list")
    @PermitAll
    public PageDto<GameDto> getList(@RequestParam("pageIndex") Integer pageIndex,
                                    @RequestParam("pageSize") Integer pageSize,
                                    @RequestParam(value = "keyWord", required = false) String keyWord) {
        return _gameService.getList(pageIndex, pageSize, keyWord);
    }
}
