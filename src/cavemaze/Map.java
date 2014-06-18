package cavemaze;

public class Map {    
    private int[][] map;
    int height;
    int width;
    
    /**
     * @return マップ情報
     */
    public int[][] GetMap(){
    }
    
    /**
    * @param height 迷路の縦幅
    * @param width  迷路の横幅
    * @throws cavemaze.Map.ImpossibilityException
    */
    public void MakeMap() throws ImpossibilityException{
    }
    
    /**
     * 実際に迷路を作っていく
     * @param x 掘り始めるx座標
     * @param y 掘り始めるy座標
     * @return 1で完成0は未完成
     */
    private int DelveMap(int x, int y){
    }
    
    /**
    * @param px 自機のx座標
    * @param py 自機のy座標
    */
    public void ShowMap(int px, int py){
    }
    
    public Map(int h, int w){
    }
    
    class ImpossibilityException extends Exception {
    }
}
