package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Простая программа
*/

public class SymbolGame extends Game {

    //напишите тут ваш код

    @Override
    public void initialize() {
        setScreenSize(8, 3);
        setCellValueEx(0, 1, Color.ORANGE, "J");
        setCellValueEx(1, 1, Color.ORANGE, "A");
        setCellValueEx(2, 1, Color.ORANGE, "V");
        setCellValueEx(3, 1, Color.ORANGE, "A");
        setCellValueEx(4, 1, Color.ORANGE, "R");
        setCellValueEx(5, 1, Color.ORANGE, "U");
        setCellValueEx(6, 1, Color.ORANGE, "S");
        setCellValueEx(7, 1, Color.ORANGE, "H");
    }
    /*
    public void writeString(String str,int y){
        for(int x = 0; x<str.length();x++){
            setCellValueEx(x,y,Color.ORANGE,str.substring(x,x+1));
        }
    }
     */
}
