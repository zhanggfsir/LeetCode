package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

 */
public class _27_数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int arr[] ={1,2,3,2,2,2,5,4,2};
        MoreThanHalfNum_Solution4(arr) ;
    }

    /*
  巧解
思路一：数组排序后，如果符合条件的数存在，则一定是数组中间那个数。（比如：1，2，2，2，3；或2，2，2，3，4；或2，3，4，4，4等等）
这种方法虽然容易理解，但由于涉及到快排sort，其时间复杂度为O(NlogN)并非最优；
     */
    public int MoreThanHalfNum_Solution(int [] array)
    {
        HashMap<Integer,Integer> hash = new HashMap<>();
        if(array.length == 1)
            return array[0];//数组长度为1，单独考虑
        for(int i=0; i<array.length; i++)
        {
            if(hash.containsKey(array[i]))
            {
                int count = hash.get(array[i]);
                hash.put(array[i], ++count);//注意是++count，若改为count++，则错误
                if(count > (array.length )/2)
                {
                    return array[i];
                }
            }
            else //如果不包含key
            {
                hash.put(array[i], 1);
            }

        }
        return 0;

    }
    // 方法1 基于hashmap 等价于做wc  同上
        public int MoreThanHalfNum_Solution1(int [] array) {
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

            for(int i=0;i<array.length;i++){

                if(!map.containsKey(array[i])){
                    map.put(array[i],1);
                }else{
                    int count = map.get(array[i]);
                    map.put(array[i],++count);
                }
            }
            Iterator iter = map.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry)iter.next();
                Integer key =(Integer)entry.getKey();
                Integer val = (Integer)entry.getValue();
                if(val>array.length/2){
                    return key;
                }
            }
            return 0;
        }

        // 方法3 基于快排思想 等再过一次快排再看吧
    public class Solution {
        public int MoreThanHalfNum_Solution3(int [] array) {
            if(array.length<=0)
                return 0;

            int start = 0;
            int length = array.length;
            int end  = length-1;
            int middle = length>>1;

            int index = Partition(array,start,end);


            while(index!=middle){

                if(index>middle){
                    index = Partition(array,start,index-1);
                }
                else{
                    index = Partition(array,index+1,end);
                }
            }
            int result = array[middle];

            int times = 0;
            for(int i=0;i<length;++i){
                if(array[i] == result)
                    times++;
            }
            if(times*2<length){
                System.out.println(times);
                return 0;
            }else{
                return result;
            }
        }
        public int Partition(int[] array,int start,int end){
            int flag = (array[start]+array[end])/2;

            while(start<end){
                while(array[end]>flag){
                    end--;
                }
                swap(array,start,end);
                while(array[start]<=flag){
                    start++;
                }
                swap(array,start,end);
            }
            return start;
        }
        public void swap(int[] array,int num1,int num2){
            int temp =array[num1];
            array[num1] =array[num2];
            array[num2] =temp;
        }
    }

    /**
     * 这个方法可以放弃了 不知道在 干啥，还写这么复杂
     * @param array
     * @return
     */

    public static int MoreThanHalfNum_Solution4(int [] array) {
        if(array.length<=0){
            return 0;
        }
        int result = array[0];
        int times = 1;

        // 找到出现次数最多的那个result
        //int arr[] ={1,2,3,2,2,2,5,4,2};
        for(int i=0;i<array.length;i++){
            if(times==0){
                result = array[i];
                times =1;
            }else if(array[i]==result){
                times++;
                System.out.println(times+"  "+array[i] + "  ");
            }
            else
                times--;
        }
        // 对 出现最多的result进行计数
        int time = 0;
        for(int i=0;i<array.length;++i){
            if(array[i] == result)
                time++;
        }
        if(time*2<array.length){
            System.out.println(time);
            return 0;
        }else{
            return result;
        }
    }
}
