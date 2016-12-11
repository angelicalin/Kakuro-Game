/**
 * Created by Leqi on 11/16/16.
 */

import acm.graphics.GCompound;

import java.util.HashMap;


public class CheckboardGraphics extends GCompound{
    private static final double BOARD_WIDTH = 350.0;
    private static final double BOARD_HEIGHT = 350.0;
    private static final double CELL_LENGTH = 50.0;
  //  private static final int row_num_cells = 7;
  final int ROW_NUM = 4;
    final int COLUMN_NUM = 5;
    private HashMap<Integer, SingleCellGraphics> cellGraphicsMap = new HashMap<>();



    public CheckboardGraphics(int [][] cell_values)  {

        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++){
                Integer VALUE_UP = cell_values[2*i][j];
                Integer VALUE_DOWN = cell_values[2*i+1][j];
                boolean fillable = true;

                if (VALUE_UP !=0 | (VALUE_DOWN != 0)) {
                    fillable = false;
                }
                SingleCellGraphics singleCell = new SingleCellGraphics(VALUE_UP, VALUE_DOWN, fillable);

                double xPos = j*CELL_LENGTH;
                double yPos = i*CELL_LENGTH;
                add(singleCell, xPos, yPos);
                cellGraphicsMap.put((2*i*100+j),singleCell);
            }

        }


    }
    public void changeDisplayNum(int loc, Integer newNum){
        SingleCellGraphics singleCellGraphics = cellGraphicsMap.get(loc);
        singleCellGraphics.setNewNum(newNum);
    }



    public static double getBoardWidth() {
        return BOARD_WIDTH;
    }

    public static double getBoardHeight() {
        return BOARD_HEIGHT;
    }
}
