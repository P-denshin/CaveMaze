package cavemaze;
import java.util.Random;

public class Map {    
    int[][] map;
    int height;
    int width;
    enum Direction { forward,  back, left, right, here};
    
    /**
     * @return マップ情報
     */
    public int[][] GetMap(){
        return map;
    }
    
    /**
    * @throws cavemaze.Map.ImpossibilityException
    */
    public void MakeMap() throws ImpossibilityException{   
        //できない場合
        if(height % 2 == 0 || width % 2 == 0){
            throw new ImpossibilityException();
        }
        
        map = new int[width][height];
        
        //すべて壁
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                map[i][j] = -1;
            }
        }
        
        //一つごとに番号作成
        int count = 0;
        for(int i = 1; i < width - 1; i += 2){
            for(int j = 1; j < height -1; j += 2){
                map[i][j] = count;
                count++;
            }
        }
        
        //迷路を作っていく
        DelveMap(width - 2, height - 2, Direction.here);        
    }
    
    /**
     * 実際に迷路を作っていく
     * @param x 掘り始めるx座標
     * @param y 掘り始めるy座標
     */
    private void DelveMap(int x, int y, Direction d) {
            Random rm = new Random();
            int dir = rm.nextInt();    //1234上下左右

            if (dir % 4 == 0 && y >= 2 && d != Direction.forward) {  //上
                if (map[x][y - 1] != map[x][y] && map[x][y - 2] != map[x][y]) {
                    map[x][y - 1] = map[x][y];
                    //map[x][y-2]の値をすべてmap[x][y]にする。
                    Combine(map[x][y - 2], map[x][y]);
                    d = Direction.forward;
                }
            } else if (dir % 4 == 1 && y <= height - 3 && d != Direction.back) { //下
                if (map[x][y + 1] != map[x][y] && map[x][y + 2] != map[x][y]) {
                    map[x][y + 1] = map[x][y];
                    //map[x][y+2]の値をすべてmap[x][y]にする。
                    Combine(map[x][y + 2], map[x][y]);
                    d = Direction.back;
                }
            } else if (dir % 4 == 2 && x >= 2 && d != Direction.left) {  //左
                if (map[x - 1][y] != map[x][y] && map[x - 2][y] != map[x][y]) {
                    map[x - 1][y] = map[x][y];
                    //map[x-2][y]の値をすべてmap[x][y]にする。
                    Combine(map[x - 2][y], map[x][y]);
                    d = Direction.left;
                }
            } else if (dir % 4 == 3 && x <= width - 3 && d != Direction.right) {//右
                if (map[x + 1][y] != map[x][y] && map[x + 2][y] != map[x][y]) {
                    map[x + 1][y] = map[x][y];
                    //map[x+2][y]の値をすべてmap[x][y]にする。
                    Combine(map[x + 2][y], map[x][y]);
                    d = Direction.right;
                }
            }
        

        //完成判定。してないことが発覚次第すぐにその処理。
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (map[j][i] != map[1][1] && map[j][i] != -1) {
                    DelveMap(j, i, d);
                }
            }
        }
    }
    
    private void Combine(int from, int to){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(map[i][j] == from)
                    map[i][j] = to;
            }
        }
    }
    
    /**
    * @param px 自機のx座標
    * @param py 自機のy座標
    */
    public void ShowMap(int px, int py){
        for(int i = 0; i < width; i ++){
            for(int j = 0; j < height; j++){
                
                if(map[i][j] == -1)
                    System.out.print("■");
                else
                    System.out.print("　");
            }
            System.out.println("");
        }
        System.out.println();
    }
    
    public Map(int h, int w){
        height = h; width = w;
    }
    
    class ImpossibilityException extends Exception {
        public ImpossibilityException(){
            super("作成される迷路は縦横の長さは奇数でなければ作れません。");
        }
    }
}