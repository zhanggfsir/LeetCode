package algorithm;

//num1,num2  分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class _38_数组中只出现一次的数字_ {
    public static void main(String[] args) {
        int arr[]={2,3,3,5,5,4,4,8,7,7};
        int num1[]=new int[1];
        int num2[]=new int[1];

        findNumsAppearOnce2(arr,num1,num2);

//        public static int find1From3(int[] a)
//        public static int find1From2(int[] a)
//        public static void findNumsAppearOnce(int [] array,int num1[] , int num2[])

    }
    // wc
    public static void findNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        if(array==null&&array.length<=1){
            num1[0]=num2[0]=0;
            return;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],2);
            }
            else{
                map.put(array[i],1);
            }
        }
        num1[0]=0;
        for(Map.Entry entry:map.entrySet()){
            if((Integer)entry.getValue()==1){
                if(num1[0]==0){
                    num1[0]=(Integer)entry.getKey();
                }else{
                    num2[0]=(Integer)entry.getKey();
                }
            }
        }
        System.out.println(Arrays.toString(num1)+" "+Arrays.toString(num2));
    }


//---------------------------------感觉一个hashmap就挺好呀，---------------------------------------------------------
// ---------------------------------以下几种方法 让人感觉 需要 细琢磨---------------------------------------------------------

    /**
     * 数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字
     * @param array
     * @param num1
     * @param num2
     */
    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for(int i = 0; i < len; i++){
            sum ^= array[i];
        }
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) break;
        }
        for(int i = 0; i < len; i++){
            if((array[i] & (1 << index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }
    }
    /**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     * @param a
     * @return
     */
    public static int find1From2(int[] a){
        int len = a.length, res = 0;
        for(int i = 0; i < len; i++){
            res = res ^ a[i];
        }
        return res;
    }
    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     * @param a
     * @return
     */
    public static int find1From3(int[] a){
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ( (a[i]>>>j) & 1);
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] % 3 !=0){
                res = res | (1 << i);
            }
        }
        return res;
    }





    /*
不知道这个方法讲的啥了 暂时不看了 过
两个相同数字异或=0，一个数和0异或还是它本身。
 */
    public static void findNumsAppearOnce2(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        //int arr[]={2,3,3,5,5,4,4,8,7,7};
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
            System.out.print(bitResult+" ");
        }
        int index = findFirst1(bitResult);  // 1
        System.out.println("index="+ index);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private static int findFirst1(int bitResult){
        int index = 0;
        System.out.println(bitResult & 1);
        while(((bitResult & 1) == 0) && index < 32){  // & 同1得到1
            System.out.print("before="+bitResult+" ");
            bitResult >>= 1;
            System.out.print("after="+bitResult+"       ");
            index++;
        }
        return index;
    }

    private static boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}
