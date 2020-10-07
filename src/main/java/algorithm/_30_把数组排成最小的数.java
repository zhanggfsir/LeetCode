package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

 */
public class _30_把数组排成最小的数 {
    public static void main(String[] args) {
        int arr[]={3,32,321};
        PrintMinNumber(arr);
    }

/*
 * 解题思路：
            * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
            * 排序规则如下：
            * 若ab > ba 则 a > b，
            * 若ab < ba 则 a < b，
            * 若ab = ba 则 a = b；
            * 解释说明：
            * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
            */
/*
重写compare方法(调用字符串的CompareTo方法间接实现），实现Comparetor接口（用函数式编程、匿名内部类，省得再写一个类）

Comparator接口，两个对象要使用compareTo方法比较大小，就必须实现Comparator接口的compare方法，
比如String就实现了这个方法，所以可以直接使用compareTo进行比较。sort(List，Comparator)：
根据指定的 Comparator 产生的顺序对 List 集合元素进行排序。大概是这个意思


比较器就是一个接口，通过实现这个接口重写compare方法，返回正值代表大于返回0代表等于，
返回负值代表小于。这样就可以自定义排序方法。jdk8的List本身也支持比较器排序。
jdk7中集合可以使用Collections的sort方法，实现自定义比较器排序，
数组可以通过Arrays.sort()方法实现自定义比较器排序。
*/
    public static String PrintMinNumber(int [] numbers) {  // int arr[]={3,32,321};
        if(numbers == null || numbers.length == 0)
            return "";
        int len = numbers.length;
        String[] arr = new String[len];             // 1. int数组 转 string数组
        StringBuilder sb = new StringBuilder();
        // 将int[] --> String []
        for(int i = 0; i < len; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr,new Comparator<String>(){   // 2.Arrays.sort 自定义比较器
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                System.out.println("c1="+c1+"  c2="+c2+"  ->"+c1.compareTo(c2));
                //return c2.compareTo(c1);
                return c1.compareTo(c2);
            }
        });

        System.out.println("-->"+Arrays.toString(arr));     // [321, 32, 3]
        for(int i = 0; i < len; i++){              // 3. 排序后的字符串数组 输出
            System.out.print(arr[i]+" ");
            sb.append(arr[i]);
        }
        System.out.println("==="+sb);  // 321323
        return sb.toString();
    }


    /*
    方法 2 类比冒泡排序
     */

    public String PrintMinNumber2(int [] numbers) {
        String str = "";
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                int a = Integer.valueOf(numbers[i]+""+numbers[j]);
                int b = Integer.valueOf(numbers[j]+""+numbers[i]);
                if (a > b){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }

            }
        }
        for (int i = 0; i < numbers.length; i++) {
            str += String.valueOf(numbers[i]);
        }
        return str;
    }

}
