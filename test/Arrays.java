import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Arrays {
  public static void main(String[] args) {
      ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
      int[][] arr = {
              {0,0,0,0,0,0,0,0},
              {0,1,1,1,1,1,0,0},
              {0,1,0,0,0,0,0,0},
              {0,1,1,1,1,1,0,0},
              {0,1,0,0,0,0,0,0},
              {0,1,0,0,0,0,0,0},
              {0,0,0,0,0,0,0,0}};
      int xBound = arr[0].length;
      int yBound = arr.length;
      for (int worldRow = 0; worldRow < yBound; worldRow++) {
          ArrayList<Integer> a = new ArrayList<>();
          for (int worldCol = 0; worldCol < xBound; worldCol++) {
              System.out.print(arr[worldRow][worldCol] + " ");
              a.add(arr[worldRow][worldCol]);
          }
          System.out.println("");
          arrList.add(a);
      }
    System.out.println("VS");
    for(int i = 0; i < arrList.size(); i++){
        for(int j = 0; j < arrList.get(i).size(); j++){
            System.out.print(arrList.get(i).get(j) + " ");
        }
        System.out.println();
    }
  }
  public void arr1(){
      int[][] map = {
              {1, 2, 2, 2, 2, 2, 0, 0, 0, 0},
              {1, 2, 0, 0, 0, 2, 0, 0, 0, 0},
              {1, 2, 0, 0, 0, 0, 0, 0, 0, 0},
              {1, 2, 0, 0, 0, 2, 0, 0, 0, 0},
              {1, 2, 2, 2, 2, 2, 0, 0, 0, 0},
              {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
      };
      for (int i = 0; i < 7; i++) {
          for(int j = 0; j < 10; j++){
              System.out.print("[" + map[i][j] + "] ");
          }
          System.out.println();
    }
  }
    public static void print(){
      try{
          BufferedReader br = new BufferedReader(new FileReader("maps/map01.txt"));
          List<String[]> lines = new ArrayList();
          for(String line = br.readLine();line != null;line = br.readLine()) {
              // split by " "
              String[] fields = line.split(" ");
              lines.add(fields);
          }
          String[][] strings = (String[][]) lines.toArray(new String[lines.size()][]);
          System.out.println("Lines="+strings.length);
      } catch (Exception e){
          e.printStackTrace();
      }
  }
  public static void print2(){
      for(int i = 0; i < 50; i++){
          for(int j = 0; j < 50; j++){
              System.out.print((i + j) % 3 + " ");
          }
          System.out.println();
      }
  }
}
