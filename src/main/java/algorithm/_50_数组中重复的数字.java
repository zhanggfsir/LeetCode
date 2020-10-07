package algorithm;

import java.util.HashSet;

/*
在一个长度为n的数组里的所有数字都在0到n-1的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。


 */
public class _50_数组中重复的数字 {
    public static void main(String[] args) {
        //第一想法 hashmap 做wc
        //新学了一招 参照扑克牌顺子 数组下表是 数，值是出现的次数
    }


    //boolean只占一位，所以还是比较省的
    //方法和hashmap差不多 ，时间和空间复杂度都是O（n）

    /*

    一句话总结
        boolean单独存在占4字节，在boolean[]中占1字节。boolean[]用的妙


(1)boolean不是占1位，计算机处理处理数据的最小单元是1字节，一般1位的话，其余7位会被0补齐。
(2)在java虚拟机规范中，JVM没有用于操作boolean的字节码指令，在编译后用int的数据类型代替boolean，此时boolean占4字节。
(3)boolean[]数组编译后会被byte[]数组代替，此时的boolean占1字节。
总结:boolean单独存在占4字节，在boolean[]中占1字节。
     */
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        boolean[] k = new boolean[length];   //boolean型默认值是false
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {       // 2 当再有true的时候 就是重复的值了
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;  // 1 第一次先赋值true，
        }
        return false;
    }




    //  方法有bug 必须有顺序，否则就肯定跑动了
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
//方法1 434567890-
        if (numbers == null || numbers.length == 0) return false;
        //        Arrays.sort(numbers); // 要求输出第一个，不能排序
        int flag = 0;//做标记
            for (int i = 0; i < length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                flag = 1;
                break;
            }
        }
        return flag == 1 ? true : false;
    }
//方法2：
        public boolean duplicate2_2(int numbers[],int length,int [] duplication) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<length;i++) {
            if(!hs.add(numbers[i])) {       // 当hashset里 如果add一个新的值，此时返回true；已经存在某一个元素，此时add，会返回false 。[当然这个返回值，平常很少用到...]
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }




    /*  方法1中 boolean -- > Integer
    由于所有元素值是有范围的，因此可以用一个长度为n的数组，下标表示序列中的每一个值，下标对应的值表示该下标出现的次数。
    只需扫描一次原序列，就统计出所有元素出现的次数；
    再扫描一次哈希数组，找到一个出现次数大于1的值即可。
    这种方法时间复杂度和空间复杂度都为O(n)。
     */


    public boolean duplicate(int array[],int length,int [] duplication) {
        if ( array==null ) return false;

        // 判断数组是否合法（每个数都在0~n-1之间）
        for ( int i=0; i<length; i++ ) {
            if ( array[i]<0 || array[i]>length-1 ) {
                return false;
            }
        }

        // key step
        int[] hash = new int[length];
        for( int i=0; i<length; i++ ){
            hash[array[i]]++;
        }
        for(int i=0; i<length; i++){
            if ( hash[i]>1 ) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }
}
