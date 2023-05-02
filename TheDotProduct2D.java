public class TheDotProduct2D {


    public static int[][] Dotprod2D(int[][] first, int[][] second){
        if(first[0].length != second.length){
            System.out.println("Can not Calculate");
        }
        int r = first.length;
        int c = second[0].length;
        int[][] re = new int [r][c];
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                int num = first[0].length;
                for(int k=0; k<num; ++k) {
                    re[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        for(int[] x:re){
            for(int y:x){
                System.out.print(y+" ");
            }
            System.out.println();
        }
        return re;



    }
    public static void main(String[] args){
        int[][] first = {{21,32,23,34},{13,14,15,16}};
        int[][] second = {{21,13},{32,14},{23,15},{34,16}};
        int[][] re = Dotprod2D(first,second);

    }


}
