package com.example.capstoneweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.capstoneweb.model.Board;
import com.example.capstoneweb.service.BoardService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<Map> getAllBoards(@RequestParam(value = "p_num", required=false) Integer p_num) {
        if (p_num == null || p_num <= 0) p_num = 1;

        return boardService.getPagingBoard(p_num);
    }
    @PostMapping("/board")
    public Board createBoard(@RequestBody Board board){
        return boardService.createBoard(board);
    }
    @GetMapping("/board/{num}")
    public ResponseEntity<Board> getBoardByNum(
            @PathVariable Integer num){
        return boardService.getBoard(num);
    }
    
}
