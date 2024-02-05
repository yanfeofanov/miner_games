package yanfeofanov.com.example.controller;

import org.springframework.web.bind.annotation.*;
import yanfeofanov.com.example.model.GameMines;
import yanfeofanov.com.example.model.MinesweeperGame;
import yanfeofanov.com.example.model.MovePlayer;
import yanfeofanov.com.example.service.MinesweeperService;

@RestController
@RequestMapping("/api")
public class MinesweeperController {

    private final MinesweeperService minesweeperService;

    public MinesweeperController(MinesweeperService minesweeperService) {
        this.minesweeperService = minesweeperService;
    }

    @PostMapping("/new")
    public MinesweeperGame newGame(@RequestBody GameMines gameMines){
        return minesweeperService.newGame(gameMines);
    }

    @PostMapping("/turn")
    public void movePlayer(@RequestBody MovePlayer movePlayer){
        minesweeperService.movePlayer(movePlayer);
    }

}
