package cavemaze;
public class Player {    
    private int x, y;

    enum Direction { forward,  back, left, right};
    
    /**
     * @return プレイヤーのx座標
     */
    public int GetX(){
        return x;
    }
    /**
     * @return プレイヤーのy座標
     */
    public int GetY(){
        return y;
    }
    
    /**
    * @param direct 進む方向
    */
    public void Move(Direction direct){
    }   
    
    /**
   * @return int
   * 0なら異常なし
   * １は進めない
   * ２ならゴール
    */
    private int Judge(){
        return 0;
    }
}
