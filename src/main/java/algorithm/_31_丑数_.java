package algorithm;

import java.util.ArrayList;

/*
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class _31_丑数_ {
    public static void main(String[] args) {
//        Queue<Integer> q=new LinkedList<Integer>();
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        System.out.println(q.peek());
//        System.out.println(q.poll());

        System.out.println( GetUglyNumber_Solution2(10));;
    }
    /*
    方法1
   方法论
     // 3个指针，分别指向*2 *3 *5移动指针，标识为 i2 i3 i5；对应值为 m2 m3 m5
     //　当*n 匹配到的时候，将对应in++
   解释
丑数的定义是1或者因子只有2 3 5，可推出丑数=丑数*丑数，假定丑数有序序列为：a1,a2,a3.......an
所以可以将以上序列（a1除外）可以分成3类，必定满足：
包含2的有序丑数序列：2*a1, 2*a2, 2*a3 .....
包含3的有序丑数序列：3*a1, 3*a2, 3*a3 .....
包含5的有序丑数序列：5*a1, 5*a2, 5*a3 .....
以上3个序列的个数总数和为n个，而且已知a1 = 1了，将以上三个序列合并成一个有序序列即可
程序中t2,t3,t5实际就是合并过程中三个序列中带排序的字段索引

感觉厉害的地方在于根据已知求到结果，再把这个结果当成已知，求下一个结果。。直到目标结果出现
     */
        public static int GetUglyNumber_Solution2(int n)
        {
            if(n<=0)
                return 0;
            ArrayList<Integer> list=new ArrayList<Integer>();
            list.add(1);
            int i2=0,i3=0,i5=0;
            while(list.size()<n) {
                int m2=list.get(i2)*2;
                int m3=list.get(i3)*3;
                int m5=list.get(i5)*5;
                int min=Math.min(m2,Math.min(m3,m5));
                System.out.print("list.get(i2="+i2+")*2"+"="+m2+" "+"list.get(i3="+i3+")*3"+"="+m3+" "+"list.get(i5="+i5+")*5"+"="+m5+ " --> "+" min="+min+"  ");
                list.add(min);
                if(min==m2)i2++;
                if(min==m3)i3++;
                if(min==m5)i5++;
                System.out.println(list.size()+ " ="+list);
            }
//            System.out.println(list.get(list.size()));  // 会报错
            return list.get(list.size()-1); // list 的下表是从0开始
        }



////动态规划，对于第i个数，它一定是之前已存在数的2倍，3倍或5倍
// 7也是质因子，前面的数都是丑数
    public static int GetUglyNumber_Solution3(int index) {
        if(index<7) return index;
        int[] ret = new int[index];
        ret[0]=1;
        int t2=0,t3=0,t5=0;
        for(int i=1;i<index;i++) {
            ret[i] = min(min(ret[t2]*2,ret[t3]*3),ret[t5]*5);
            if(ret[i] == ret[t2]*2) t2++;
            if(ret[i] == ret[t3]*3) t3++;
            if(ret[i] == ret[t5]*5) t5++;
        }
        return ret[index-1];
    }
    public static int min(int a,int b) {
        return a<b ? a : b;
    }

        /*
        方法2  解法太难了。。。。 有时间再看吧
清清雪落 ：emmm 我看了一个晚上加一个上午才看懂。。果然我还是太笨了：
找出最小值之后的替换 是指之前顺序排列的丑数数组的每个值（！）都要乘以2,3,5的比较，
一开始1*2和1*3和1*5 比较，找出最小的是2，把2放进a数组，这时候替换2的数就是2*2,；
比较2*2,1*3,1*5，找到最小的是3，把3放进a数组，替换3的是2*3；
比较2*2,2*3,1*5，找到最小是4,4放进a数组，这时候替换的用来乘以2的数就是3即3*2。

         */
    final int d[] = { 2, 3, 5 };
    public int GetUglyNumber_Solution(int index) {
        if(index == 0) return 0;
        int a[] = new int[index];
        a[0] = 1;
        int p[] = new int[] { 0, 0, 0 };
        int num[] = new int[] { 2, 3, 5 };
        int cur = 1;

        while (cur < index) {
            int m = finMin(num[0], num[1], num[2]);
            System.out.println(m+" m -> " );
            if (a[cur - 1] < num[m])
                a[cur++] = num[m];
            p[m] += 1;
            num[m] = a[p[m]] * d[m];
        }
        return a[index - 1];
    }

/*
说下思路，如果p是丑数，那么p=2^x * 3^y * 5^z
那么只要赋予x,y,z不同的值就能得到不同的丑数。
如果要顺序找出丑数，要知道下面几个特（fei）点（hua）。
对于任何丑数p：
（一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
（二）如果 p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
现在说说算法思想：
    由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1
的下一个丑数，也就是2*1，
    这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是
(3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。
    上面的暴力方法也应该能解决，但是如果在面试官用这种方法，估计面试官只会摇头吧
。下面说一个O（n）的算法。
    在上面的特（fei）点（hua）中，既然有p<q, 那么2*p<2*q，那么
“我”在前面比你小的数都没被选上，你后面生成新的丑数一定比“我”大吧，那么你乘2
生成的丑数一定比我乘2的大吧，那么在我选上之后你才有机会选上。
其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
数。也就是比较(2*x , 3*y, 5*z) ，x>=y>=z的，
重点说说下面代码中p的作用：int p[] = new int[] { 0, 0, 0 }; p[0]表示最小用于
乘2比较数在数组a中的【位置】。 */

    private int finMin(int num2, int num3, int num5) {
        int min = Math.min(num2, Math.min(num3, num5));
        return min == num2 ? 0 : min == num3 ? 1 : 2;
    }


}
