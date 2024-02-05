package yanfeofanov.com.example.model;

import java.util.Arrays;

public class MinesweeperGame {

    private  String game_id;
    private  int width;
    private  int height;

    private  int mines_count;

    private char[][] field;
    private boolean completed;

    public MinesweeperGame() {
    }

    public MinesweeperGame(String game_id, int width, int height, int mines_count) {
        this.game_id = game_id;
        this.width = width;
        this.height = height;
        this.mines_count = mines_count;
        this.field = new char[height][width];
        this.completed = false;
    }

    private void gameField(){
        for(char[] row : field){
            Arrays.fill(row,' ');
        }
    }

    public void move(int row,int col){
        if (row < 0 || row >= height || col < 0 || col >= width || field[row][col] != ' ') {
            return;
        }
        if (field[row][col] == 'X') {
            completed = true;
            return;
        }
        int minesAround = countMinesAround(row, col);
        if (minesAround > 0) {
            field[row][col] = (char) ('0' + minesAround);
        } else {
            field[row][col] = '0';
            expandEmptyCells(row, col);
        }
        if (isGameCompleted()) {
            completed = true;
        }
    }
    private int countMinesAround(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < height && j >= 0 && j < width && field[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    private void expandEmptyCells(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < height && j >= 0 && j < width && field[i][j] == ' ') {
                    move(i, j);
                }
            }
        }
    }

    private boolean isGameCompleted() {
        for (char[] row : field) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public String getgame_id() {
        return game_id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getmines_count() {
        return mines_count;
    }

    public char[][] getField() {
        return field;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setgame_id(String game_id) {
        this.game_id = game_id;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setmines_count(int mines_count) {
        this.mines_count = mines_count;
    }

    public void setField(char[][] field) {
        this.field = field;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
