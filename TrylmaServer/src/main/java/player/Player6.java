package player;

import gamemanager.GameManager;
import gamemanager.MoveManager;
import serializable.Field;
import serializable.FieldsSet;

import java.util.ArrayList;

public class Player6 implements Player {

    private String id;
    private ArrayList<Pawn> pawns;
    private int numOfPawns;
    private boolean bot;
    private Pawn botchoosenpawn=null;
    private FieldsSet botchoosenpath = null;
    private Field botchoosendestination = null;

    public Player6(int numOfPawns,boolean bot)
    {
        this.id = "6";
        this.bot = bot;
        this.numOfPawns = numOfPawns;
        this.pawns = new ArrayList<Pawn>();
        int initialy = numOfPawns+1;
        int initialz = -1;
        int x = numOfPawns;
        for(int k = numOfPawns; x>0;x--,k--) {
            int y = initialy;
            int z = initialz;
            for (int i = 0; i < k; i++) {
                Pawn pawn = new Pawn(x,y,z);
                this.pawns.add(pawn);
                GameManager.board.getFieldById(pawn.getId()).changeState();
                y++;
                z--;
            }
            initialz--;
        }
    }
    public Pawn getPawnById(String id)
    {
        for (Pawn pawn : pawns) {
            if (pawn.getId().equals(id)) {
                return pawn;
            }
        }
        return null;
    }
    public ArrayList<Pawn> getPawns()
    {
        return pawns;
    }

    public boolean isBot() {
        return bot;
    }

    public Pawn getBotchoosenpawn() {
        return botchoosenpawn;
    }

    public Field getBotchoosendestination() {
        return botchoosendestination;
    }

    public FieldsSet getBotchoosenpath() {
        return botchoosenpath;
    }

    public String getId() {
        return id;
    }

    public boolean checkWin() {

        for (Pawn pawn : pawns) {
            if (pawn.getY() >= -numOfPawns) {
                return false;
            }
        }
        return true;
    }

    public void botMove() {
        int y = 2*numOfPawns;
        for (Pawn pawn : pawns) {
            MoveManager.generateMovePaths(pawn);

            for (int i = 0; i < MoveManager.paths.size(); i++) {

                if (MoveManager.paths.get(i).end.getY() < y) {

                    this.botchoosenpawn = pawn;
                    y = MoveManager.paths.get(i).end.getY();
                    this.botchoosenpath = MoveManager.paths.get(i);
                    System.out.println("Bot 6 -----------------");

                    for(Field field : this.botchoosenpath.getPath())
                    {
                        System.out.println(field.getId());
                    }
                    System.out.println("----------------------------");
                }
            }
        }
        this.botchoosendestination = this.botchoosenpath.end;

    }

    public void movePawn(Pawn pawn, Field destination) {
        for (Pawn pawn1 : pawns) {
            if (pawn1.getId().equals(pawn.getId())) {
                pawn1.setXYZ(destination.getX(), destination.getY(), destination.getZ());
            }
        }
    }
}
