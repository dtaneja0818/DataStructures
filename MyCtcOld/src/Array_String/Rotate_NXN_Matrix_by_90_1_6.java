/*The rotation can be performed in layers when we perform a cyclic swap on the edges on 
 * each layer. In the first for loop,we rotate the first layer(outermost edge).
 * we rotate the edges by doing a four way swap first on the corners then on the elem clockwise
 * from the edges then on the element three steps away.
 */
package Array_String;
import java.util.*;
public class Rotate_NXN_Matrix_by_90_1_6 {

    public static void main(String[] args) {
        System.out.println("Enter the order of matrix");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int matrix[][]=new int[n][n];
        System.out.println("enter the elem");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=in.nextInt();
            }
        }
        System.out.println("Matrix entered is: ");
        for(int i=0;i<n;i++){System.out.println();
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]);
            }
        }
      rotate(matrix,n);
    }
    public static void rotate(int[][] matrix,int n){
       for(int layer=0;layer<n/2;++layer){
           int first=layer;
           int last=n-1-layer;
           for(int i=first;i<last;++i){
               int offset=i-first;
               int top=matrix[first][i];		//save top
               matrix[first][i]=matrix[last-offset][first];		//left->top
               matrix[last-offset][first]=matrix[last][last-offset];//bottom->left
               matrix[last][last-offset]=matrix[i][last];		//right->bottom
               matrix[i][last]=top;		//top->right
           }
       }
       System.out.println("Matrix after rotation is: ");
       for(int i=0;i<n;i++){System.out.println();
           for(int j=0;j<n;j++){
               System.out.print(matrix[i][j]);
           }
       }
    }
}    