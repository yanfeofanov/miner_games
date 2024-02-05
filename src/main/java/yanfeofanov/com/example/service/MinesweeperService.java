package yanfeofanov.com.example.service;

import org.springframework.stereotype.Service;
import yanfeofanov.com.example.model.GameMines;
import yanfeofanov.com.example.model.MinesweeperGame;
import yanfeofanov.com.example.exception.MinesweeperExceptionBadRequest;
import yanfeofanov.com.example.model.MovePlayer;
import yanfeofanov.com.example.repository.GameRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class MinesweeperService {

    private GameRepository gameRepository;

    private MinesweeperGame games;
    public MinesweeperGame newGame(GameMines gameMines){
        int wight = gameMines.getWight();
        int height = gameMines.getHeight();
        int mines_count = gameMines.getMines_count();
        String game_id = genGameId();
        MinesweeperGame game = new MinesweeperGame(game_id,wight,height,mines_count);
        if(game.getHeight() == 0 || game.getWidth() == 0){
            throw  new MinesweeperExceptionBadRequest();
        }
        gameRepository.save(game);
        return game;
    }

    public void movePlayer(MovePlayer movePlayer){
        String game_id = movePlayer.getGame_id();
        int row = movePlayer.getRow();
        int col = movePlayer.getCol();
        MinesweeperGame minesweeperGame = gameRepository.findById(game_id);
        if(minesweeperGame == null || minesweeperGame.isCompleted()){
            throw new MinesweeperExceptionBadRequest();
        }
        minesweeperGame.move(row,col);
        gameRepository.save(minesweeperGame);
    }

    private String genGameId(){
        return games.getgame_id();
    }





}
