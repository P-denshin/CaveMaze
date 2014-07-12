package cavemaze;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CaveMaze {
    public static void main(String[] args) {
        int width = 0, height = 0;
        Scanner in = new Scanner(System.in);
        do{
            System.out.print("横幅（奇数）？　＞");
            width = in.nextInt();
        }while(width % 2 == 0);
        do{
            System.out.print("縦幅（奇数）？　＞");
            height = in.nextInt();
        }while(height % 2 == 0);
        
        Map mp = new Map(width,height);
        try {
            mp.MakeMap();
        }catch(Map.ImpossibilityException a){
            System.out.println(a.getMessage());
        }
        mp.ShowMap();
        
        FileWriter fw;
        try {
            fw = new FileWriter(".\\maze.txt");
            String mapstr = mp.MapToString();
            fw.write(width + " × " + height + "の大きさの迷路\n\n" + mapstr);
            fw.close();
        } catch(IOException e){
            System.out.println("ファイルエラー");
        }
    }    
}
