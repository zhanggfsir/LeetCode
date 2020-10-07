package algorithm;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。

 */
public class _1_二维数组中的查找 {
    public static void main(String[] args) {
        ConcurrentHashMap cmap=new ConcurrentHashMap<>();
        System.out.println(4>>1);
        int arr[][]={
                {1,2,3,4},
                {2,3,4,5},
                {3,4,5,6}
        };
        System.out.println( Find(arr,4));

        // ------------------------------常用算法考察------------------------------
        // hashmap遍历
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // List<Integer> valuesList1 = (List<Integer>) map.values(); 此方法不行，报错
        List<Integer> valuesList = new ArrayList<Integer>(map.values()); //此方法是获得map.values()的正解
        // table数组 延续了jdk1.7的写法  1.8之后为Node数组Node<K,V>[] table;
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        ArrayList<Integer> list=new ArrayList();
        //对一个list逆序 同一list中元素逆序
        int midIndex = (list.size()-1)/ 2 ;
        int totalSize = list.size();
        for (int i = 0; i <= midIndex; i++) {
            int tmp = list.get(i);
            list.set(i, list.get(totalSize - 1 - i)); // 怎么对称： a+b=totalSize-1 (下标为0)
            list.set(totalSize - 1 - i, tmp);
        }

    }

/*
方法论 1.for循环遍历每一行 ； 2.对每一行进行二分查找
一种是：
把每一行看成有序递增的数组，
利用二分查找，
通过遍历每一行得到答案，
时间复杂度是nlogn     二分的时间复杂度是 O()=O(logn).由于外层遍历了一层n，故nlogn
 */
    public static boolean Find(int [][] array,int target) {
        for(int i=0;i<array.length;i++){ // 再遍历就是一维数组了
            int low=0;
            int high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target>array[i][mid])
                    low=mid+1;
                else if(target<array[i][mid])
                    high=mid-1;
                else
                    return true;
            }
        }
        return false;
    }


/*
方法论 1.定义右上角元素的下标
2.while循环下 row col满足条件
target==arr[row][col]);return true;
当target > arr[row][col];row++；        (那么target必定在元素arr[row][col]所在列的下边)
当target < arr[row][col];col--；


另外一种思路是：
利用二维数组由上到下， ，
那么选取右上角或者左下角的元素a[row][col]与target进行比较，
当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
即col--；
当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
即row++；
O(M + N)

 */

    public static boolean Find2(int [][] array,int target) {
        int row=0;
        int col=array[0].length-1;
        while(row<=array.length-1&&col>=0){
            if(target==array[row][col])
                return true;
            else if(target>array[row][col]) //  右上角开始 arr[0][3]
                row++;
            else
                col--;
        }
        return false;
    }

    // 对一个数组逆序--通常用于对一个字符串[字符数组]的逆序操作 或者对一个数组的逆序
    public void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }




}

// 单例模式
class Single {
    private static Single instance;
    private Single (){}
    public static synchronized Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }
}










