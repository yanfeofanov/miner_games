package yanfeofanov.com.example.repository;

import org.springframework.stereotype.Repository;
import yanfeofanov.com.example.model.MinesweeperGame;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GameRepository {
    private final Map<String, MinesweeperGame> gameRepositoryMap = new HashMap<>();

    public void save(MinesweeperGame game){
        gameRepositoryMap.put(game.getgame_id(),game);
    }

    public MinesweeperGame findById(String game_id){
        return gameRepositoryMap.get(game_id);
    }
}
