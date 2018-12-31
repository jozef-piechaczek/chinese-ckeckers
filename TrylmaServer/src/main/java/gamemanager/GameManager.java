package gamemanager;

import gamemanager.board.Board;
import player.Player;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class GameManager {
    public static boolean gameInProgerss = false;
    public static int numberOfPawns = 0;
    public static int numberOfPlayers = 0;
    public static int freePlacesForGame = 1;
    public static Board board;
    public static ArrayList<Player> players;
    public static ArrayList<ObjectOutputStream> playersobjout;
    public static Player actualplayer;


    public static void nextPlayer()
    {
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getId().equals(actualplayer.getId()))
            {
                actualplayer = players.get((i+1)%numberOfPlayers);
                return;
            }
        }
    }
    public static Player checkWin()
    {
        for(Player player : players)
        {
            if(player.checkWin())
            {
                return player;
            }
        }
        return null;
    }
    public static void initialize()
    {
        actualplayer = null;
        playersobjout = new ArrayList<ObjectOutputStream>();
        board = new Board();
        players = new ArrayList<Player>();
    }

}
