package algorithm;

/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39

F(0)=0,F(1)=1 当n>=2时，F(n)=F(n-1)+F(n-2)
F(2)=F(1)+F(0)=1 F(3)=F(2)+F(1)=1+1=2
F(0)-F(N) 依次为 0 1 1 2 3 5 8 13 21 34
 */
public class _7_斐波那契数列 {


    public int Fibonacci1(int n) {
        int preNum=1;
        int prePreNum=0;
        int result=0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(int i=2;i<=n;i++){
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;

    }

    // 递归写法肯定是必问的！  时间的复杂度为O(2^n)，即2的n次方.而不用递归是 n
    // TODO 此方法记住   时间复杂度 K^n
    /**
     * 传入参数n  返回值类型为long,若为int可能出现溢出
     */
    public static long f(int n){
        if(n <= 2){//参数1或者2时
            return 1;
        }else{
            return f(n - 1) + f(n - 2);
        }
    }


    public int Fibonacci(int n) {
        return Fibonacci(n,0,1);
    }

    private static int Fibonacci(int n,int acc1,int acc2){
        if(n==0) return 0;
        if(n==1) return acc2;
        else     return Fibonacci(n - 1, acc2, acc1 + acc2);

    }
}


