package algorithm;

import java.util.Arrays;

/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

B[i]中 没有乘 i ...



B[0] = A[1] * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[0]）
B[1 ]= A[0] * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[1]）
B[2] = A[0] * A[1] * A[3] * A[4] *....*A[n-1] ;（没有A[2]）
....
即B[i]项等于A数组所有数的乘积，但是去除A[i]项。由于是乘法，所以直接令A[i]项等于1即可。
代码中加个flag标志做判断即可。
 */
public class _51_构建乘积数组 {

    public static void main(String[] args) {
        //其实有一个变态的解法，设定A[i]*A[i-1]*A[i-2]...*1=a，则获得B[i]=a/A[i]
        int arr[]={1,2,3,4,5,6};
//        multiply(arr);
        multiply0(arr);

    }


//最复杂 用双层for循环，当A中索引与B中索引相同时，不做处理，否则乘上A中元素
    public static int[] multiply0(int[] A) {
        int[] B = new int[A.length];
        if (A.length != 0) {
            for (int i = 0; i < A.length; i++) {  // B[i]的小标 -- 每次B[i]被赋值为1
                B[i] = 1;
                for (int j = 0; j < A.length; j++) { // A[i]的小标
                    if (i != j) {
                        System.out.println("B["+i+"]"+"="+"B["+i+"]"+"*"+"A["+j+"]"+" B[i]->"+B[i]+"  A[j]="+A[j]);
                        B[i] =B[i] * A[j];
                    }
                }
            }
        }
        return B;
    }

    /*
     // 中规中矩的做法  每次获取B[i]数字，都要将a[j]相乘一遍。且 i!=j。
    //方法论 遍历数组，当 B 的下标 等于A 的下标时，跳过，继续循环。 [可以考虑一下 直接break的场景]

    为了方便理解  思考一个极端情况
    B[0] = A[1] * A[2] * A[3] * A[4] *....*A[n-1]   *A[0];（有A[0]）
    B[1 ]= A[0] * A[2] * A[3] * A[4] *....*A[n-1]   *A[1];（有A[1]）
    B[2] = A[0] * A[1] * A[3] * A[4] *....*A[n-1]   *A[0];（有A[2]）
     */


    public static int[] multiply(int[] A) {
        //新建一个数组B
        int[] B = new int[A.length];
        //遍历B ，循环添加元素
        for(int i = 0; i < B.length; i++){
            // 因为初始B 中元素全为0，考虑后续自乘,全设为1
            B[i] = 1;
            //遍历 数组 A，
            for(int j = 0; j < A.length; j++){
                //当 A中的下标等于B 的下标时，跳出循环体，继续下一次循环
                if(j == i){
                continue;
                //否则，就自乘以 A[i]
            }else{
                B[i] = B[i]*A[j];
            }
        }
    }
    //赋值结束，返回数组B
        System.out.println(Arrays.toString(B));
        return B;
}

    //使用额外的数组让代码更容易被理解了  参考图片比较好理解
    /*
    B0
     */
    public static  int[] multiply1(int[] A) {
        if(A==null||A.length==0)
            return A;
        int[] left = new int[A.length];//记录除了自己，左边的乘积
        int[] right = new int[A.length];//记录除了自己，右边的乘积
        // 右边乘积好理解  上三角
        right[A.length-1] = 1;
        for(int i = A.length-2;i>=0;i--){
            right[i] = right[i+1]*A[i+1];// right[n-2]=right[n-1]*A[n-1]
        }
        // 左边乘积好理解 下三角
        System.out.println(Arrays.toString(right));
        left[0] = 1;
        for(int i = 1;i<A.length;i++){  // i从1开始 0已经初始化了
            left[i] = left[i-1]*A[i-1];     //left[1]=left[0]*A[0] // left[n]=left[n-1]*a[n-1]
        }
        System.out.println(Arrays.toString(left));
        int[] B = new int[A.length];
        for(int i = 0;i<A.length;i++){  // 左边乘积*右边乘积
            B[i] = left[i]*right[i];
        }
        System.out.println(Arrays.toString(B)); //  [720, 360, 240, 180, 144, 120]-
        return B;
    }



    //#-------------------------------------以下方法可以不用看啦--------------------------------------

    /**
     * 构建乘积数组       剑指Offer-构建乘积数组
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     * 不能使用除法。
     */
    // 看懂了        牛逼的不行 multiply1 使用一个数组实现
    public  static   int[] multiply2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];  // B[1]=B[0]*A[0]
            }
            System.out.println(Arrays.toString(B));
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
            System.out.println(Arrays.toString(B));
        }
        return B;
    }





// 动态规划  有时间再看吧
        public int[] multiply4(int[] A) {
            int[] B = new int[A.length];
            if(A.length == 1) return B; // A的长度为1 的特殊情况
            int[][] dp = new int[A.length][A.length];
            // 上三角矩阵 dp[i][j]意为：A[i] * A[i + 1] * ... * A[j]
            for(int i = A.length - 1;i >= 0;i--){
                for(int j = i;j <= A.length - 1;j++){
                    if(j == i) dp[i][j] = A[i];
                    else{
                        dp[i][j] = dp[i][j - 1] * dp[j][j];
                    }
                }
            }
            // 先处理两种越界情况
            B[0] = dp[1][B.length - 1];
            B[B.length - 1] = dp[0][B.length - 2];
            for(int i = 1;i < B.length - 1;i++){
                B[i] = dp[0][i - 1]*dp[i + 1][B.length - 1];
            }
            return B;
        }


}
