package cavemaze;

public class Map {    
    private int[][] map;
    int height;
    int width;
    
    /**
     * @return マップ情報
     */
    public int[][] GetMap(){
        return map;
    }
    
    /**
    * @param height 迷路の縦幅
    * @param width  迷路の横幅
    * @throws cavemaze.Map.ImpossibilityException
    */
    public void MakeMap() throws ImpossibilityException{   
        //できない場合
        if(height % 2 == 0 || width % 2 == 0){
            throw new ImpossibilityException();
        }
        
        map = new int[width][height];
        
        //すべて壁
        for(int i = 0; i < width - 1; i++){
            for(int j = 0; j < height -1; j++){
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
    }
    
    /**
     * 実際に迷路を作っていく
     * @param x 掘り始めるx座標
     * @param y 掘り始めるy座標
     * @return 1で完成0は未完成
     */
    private int DelveMap(int x, int y){
        
        //完成判定
        int tmp = map[1][1];
        for(int i = 1; i < width -1; i++){
            for(int j = 1; j < height -1; j++){
                if(tmp != map[i][j] && map[i][j] != -1)
                    return 0;
            }
        }
    }
    
    /**
    * @param px 自機のx座標
    * @param py 自機のy座標
    */
    public void ShowMap(int px, int py){
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