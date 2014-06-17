package cavemaze;
public class Map {    
    private int[][] map;
    
    /**
     * @return マップ情報
     */
    public int[][] GetMap(){
        return map;
    }
    
    /**
    * @param height 迷路の縦幅
    * @param width  迷路の横幅
    */
    public void MakeMap(int height, int width){
    }
    
    
    /**
    * @param px 自機のx座標
    * @param py 自機のy座標
    */
    public void ShowMap(int px, int py){
        for(int x = 0; x < map.length - 1; x++){
            for(int y = 0; y < map[0].length - 1; y++){
                System.out.print("");
            }
        }
    }
}
