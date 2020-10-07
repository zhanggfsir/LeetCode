package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,
嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。

 */
public class _45_扑克牌顺子_66 {
public static void main(String[] args) {

//    int arr[]={0,3,2,6,4};
//    int arr[]={3,0,2,6,4};
//    int arr[]={0,0,0,0,0};
//    int arr[]={0,0,0,0,2};
    int arr[]={0,0,10,11,12};

    System.out.println(isContinuous1(arr));
}
/**
很棒 很优秀
解题方法论：
max 记录 最大值
min 记录  最小值
min ,max 都不记0
满足条件
        1 max - min <5
        2 除0外没有重复的数字(牌)
        3 数组长度 为5

解题关键
d[m]=n  很经典 m是输入某个数，n就是该数字出现的次数，次数默认是0。怎么变为1呢，d[m]++
总结
//    continue 数组计数

 */
    public static boolean isContinuous1(int [] numbers) {
        int[]d = new int[14];      // d[m]=n  很经典 m是某个数，n就是出现的次数，次数默认是0。怎么变为1呢，d[m]++
        d[0] = -5;  // d 数组只是初始化了第一个值   // 允许5个都是0 刚好 d[numbers[i]]++ 的值为5
        int len = numbers.length; // d的大小是写死的，表示下标，共14个数字，len是传入numbers数组参数的长度
        int max = -1;
        int min = 14;
        for(int i =0;i<len;i++){  // 如下4个if 都是对number[i]进行的操作，i出现的次数
            d[numbers[i]]++;  //第2次 d[number[1]]=d[3]
            if(numbers[i] == 0){      // 如果是0就不用比较了 numbers[i]={0,3,2,6,4}
                continue;
            }
            if(d[numbers[i]]>1){    // 某个数字出现了2次.肯定不对，直接返回
                return false;
            }
            if(numbers[i] >max){       // 记录最大值
                max = numbers[i];
            } if(numbers[i] <min){     // 记录最小值 方便最差 max-min < 5
                min = numbers[i];
            }
        } //0   1  2  3  4  5  6  7 ...
        // [-4, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(d));
        System.out.println(max+"  "+min);
        if(max -min<5){
            return true;
        }

        return false;
    }

    /*
    方法论：
    仍然是 max-min<5 无重复。
    HashSet.add(x); 当已经存在就会返回false
set里面元素是无法重复的，所以如果有重复的add方法就会false，后面的是判断除去大小王的情况
if(!set.add(a) && a!=0) return false;


         Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(2);
        System.out.println(set.add(3)); // true
        System.out.println(set.add(2)); // false
     */
    public boolean isContinuous2(int [] numbers) {
        if(numbers.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        int maxn = -1, minn = 14;
        for(int a: numbers)
        {
            if(!set.add(a) && a!=0) return false; // 那么需要注意了 0可以出现多次
            if(a!=0) {
                maxn = Math.max(maxn, a);
                minn = Math.min(minn, a);
            }
        }
        if(maxn - minn <=4) return true;
        return false;

    }
    /*
比较暴力的一种。但是例如 0,0,1,2,13应该也能当顺子啊 这种不是顺子
1、排序
2、计算所有相邻数字间隔总数
3、计算0的个数
4、如果2、3相等，就是顺子
5、如果出现对子，则不是顺子

     */


    public boolean isContinuous3(int[] numbers) {
        int numOfZero = 0;
        int numOfInterval = 0;
        int length = numbers.length;
        if(length == 0){
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < length - 1; i++) {
            // 计算癞子数量
            if (numbers[i] == 0) {
                numOfZero++;
                continue;
            }
            // 对子，直接返回
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            numOfInterval += numbers[i + 1] - numbers[i] - 1;
        }
        if (numOfZero >= numOfInterval) {
            return true;
        }
        return false;
    }

    /*  bitmap  这个方法需要继续研究
如果说了这么多还没明白什么是Bit-map，那么我们来看一个具体的例子，假设我们要对0-7内的5个元素(4,7,2,5,3)排序（这里假设这些元素没有重复）。那么我们就可以采用Bit-map的方法来达到排序的目的。要表示8个数，我们就只需要8个Bit（1Bytes），首先我们开辟1Byte的空间，将这些空间的所有Bit位都置为0
然后遍历这5个元素，首先第一个元素是4，那么就把4对应的位置为1（可以这样操作 p+(i/8)|(0×01<<(i%8)) 当然了这里的操作涉及到Big-ending和Little-ending的情况，这里默认为Big-ending）,因为是从零开始的，所以要把第五位置为1。
然后再处理第二个元素7，将第八位置为1,，接着再处理第三个元素，一直到最后处理完所有的元素，将相应的位置为1。
然后我们现在遍历一遍Bit区域，将该位是一的位的编号输出（2，3，4，5，7），这样就达到了排序的目的。
其实就是把计数排序用的统计数组的每个单位缩小成bit级别的布尔数组
     */

    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number < 0 || number > 13) return false;
            if(number == 0) continue;
            if(((flag >> number) & 1) == 1) return false;
            flag |= (1 << number);
            if(number > max) max = number;
            if(number < min) min = number;
            if(max - min >= 5) return false;
        }
        return true;
    }

    /**
     * 此方法扑街，对于 不成立，暂时不看吧 {0,0,10,11,12}
     *
     */
    public static boolean isContinuous5(int [] numbers) {
        int[] a=new int[14];
        for(int i=0;i<numbers.length;i++){
            a[ numbers[i] ]++;
        }

        for(int i=1;i<a.length-6;i++){// 最多输入5张牌
            if(a[i]!=0){	// 如果为0不做处理
                int count=0;
                for(int j=i;j<i+5;j++){
                    if(a[j]==0){
                        count++;
                    }
                }
                if(count==a[0]){
                    return true;
                }
                break;
            }
        }
        return false;
    }



}
