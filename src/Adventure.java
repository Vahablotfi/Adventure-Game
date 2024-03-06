public class Adventure {
    private Map gameMap;
    private Player gamePlayer;

    public Adventure(){
        gameMap = new Map();
        gamePlayer = new Player(gameMap.getRoom1());
    }

    public Map getGameMap() {
        return gameMap;
    }

    public Player getGamePlayer() {
        return gamePlayer;
    }

    public void setGameMap(Map gameMap) {
        this.gameMap = gameMap;
    }

    public void setGamePlayer(Player gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
}
