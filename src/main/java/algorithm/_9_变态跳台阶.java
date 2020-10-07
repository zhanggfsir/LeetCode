package algorithm;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class _9_变态跳台阶 {
    public static void main(String[] args) {

    }

/*方法1
每个台阶可以看作一块木板，让青蛙跳上去，n个台阶就有n块木板，最后一块木板是青蛙到达的位子， 必须存在，
其他 (n-1) 块木板可以任意选择是否存在，则每个木板有存在和不存在两种选择，(n-1) 块木板 就有 [2^(n-1)] 种跳法，可以直接得到结果。
 */


    public static int jumpFloor(int target) {
        if (target <= 0) return 0;
        return (int) Math.pow(2, target - 1);
    }
    /* 方法2
     a[n]=a[n-1]+a[n-2]+......+a[1];..........................a
    a[n-1]=        a[n-2]+......+a[1];..........................b
    两式相减可知：a[n]=2*a[n-1];
     */

//       第二种做法
	public static int jumpFloor2(int target) {
		if (target <= 0) return 0;
		if (target == 1) return 1;
		int a = 1;
		int b = 2;
		for (int i = 2; i <= target; i++) {
			b = 2 * a;
			a = b;
		}
		return b;
	}


    /*

关于本题，前提是n个台阶会有一次n阶的跳法。分析如下:
f(1) = 1
f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
f(3) = f(3-1) + f(3-2) + f(3-3)
...
f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)


说明：

1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。
2）n = 1时，只有1种跳法，f(1) = 1
3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)
4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
    那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
    因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
    f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：
    f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
    f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
    可以得出：
    f(n) = 2*f(n-1)

7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：

              | 1       ,(n=0 )

f(n) =        | 1       ,(n=1 )

              | 2*f(n-1),(n>=2)

     */



    public class Solution3 {
        public int JumpFloorII(int target) {
            if (target <= 0) {
                return -1;
            } else if (target == 1) {
                return 1;
            } else {
                return 2 * JumpFloorII(target - 1);
            }
        }
    }

}
