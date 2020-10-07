package algorithm;
import java.util.*;
/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class _54_字符流中第一个不重复的字符 {
    //用的是字符的扩展的ASCII码，总共有256个字符，值是从0-255






    /*
    一个字符占8位，因此不会超过256个，可以申请一个256大小的数组来实现一个简易的哈希表。
    时间复杂度为O(n)，空间复杂度O(n).


1）一个字符占8bit，所以ascii码表中的字符256个，但只有128是可见的，所以数组大小改为128也没问题。
3）时间复杂度，O(n)，简单点说你这个hashtable就是一个标记数组，说是hash表也没错，
本质上是的，地址够多不需要解决冲突，哈希算法也是1对1的。
你要做的是从hash表中找到值为1的键，而不是根据键去找值，所以时间复杂度必定是n，而不会是1。
     */
    public class Solution_norepeat1
    {
        int[] hashtable=new int[256];
        StringBuffer s=new StringBuffer();
        //Insert one char from stringstream
        public void Insert(char ch)
        {
            s.append(ch);
            hashtable[ch]+=1;
        }
        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce()
        {
            char[] str=s.toString().toCharArray();
            for(char c:str)
            {
                if(hashtable[c]==1)
                    return c;
            }
            return '#';
        }
    }



    /*
Solution: Java版的，使用一个HashMap来统计字符出现的次数，同时用一个ArrayList来记录输入流，
        每次返回第一个出现一次的字符都是在这个ArrayList（输入流）中的字符作为key去map中查找。
*/
    class Solution_norepeat2 {
        HashMap<Character, Integer> map=new HashMap();
        ArrayList<Character> list=new ArrayList<Character>();
        //Insert one char from stringstream
        public void Insert(char ch)
        {
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
            list.add(ch);
        }

        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce()
        {   char c='#';
            for(char key : list){
                if(map.get(key)==1){
                    c=key;
                    break;      // 此处可以直接reture 了
                }
            }

            return c;
        }
    }

/*
    LinkedHashMap是有序的，且默认为插入顺序。
    LinkedHashMap = HashMap + LinkedList。LinkedHashMap
    就是在 HashMap 的基础上多维护了一个双向链表，用来保证元素迭代顺序。

hashmap1.8结构：数组+红黑树+链表
LinkedHashMap1.8结构，数组+红黑树+双向链表。
LinkedHashMap是继承于HashMap，是基于HashMap和双向链表来实现的。
HashMap无序；LinkedHashMap有序，可分为插入顺序和访问顺序两种。
如果是访问顺序，那put和get操作已存在的Entry时，都会把Entry移动到双向链表的表尾(其实是先删除再插入)。
 */

    public class Solution_norepeat3 {
        //用有序的Map：LinkedHashMap来存放char，并且记录其出现次数
        Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        //Insert one char from stringstream
        public void Insert(char ch)
        {
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);
            }
        }
        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce()
        {
            for(char ch:map.keySet()){
                int count = map.get(ch);
                //目前第一个只出现一次的字符，返回
                if(count == 1)
                    return ch;
            }
            return '#';
        }
    }


}




