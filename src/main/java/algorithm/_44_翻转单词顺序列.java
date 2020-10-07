package algorithm;

import java.util.Stack;

/*
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class _44_翻转单词顺序列 {
    public static void main(String[] args) {
        System.out.println(ReverseSentence("student. a am I"));;
        //如果用python 挺简单的
//        def ReverseSentence(self, s):
//        return " ".join(s.split()[::-1])   if s.strip() != "" else s
    }


    /*
    方法论
        split 得到每一个字符串，之后字符串倒叙加入sb

        思路
            1. 得到每一个字符串
            2. 将每一个字符串反转
     */

    public static  String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] arr = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = arr.length-1; i >=0;i--){
            o.append(arr[i]);
            o.append(" ");
        }
        return o.toString();
    }

    public static  String ReverseSentence_(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] arr = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = arr.length-1; i >=0;i--){
            o.append(arr[i]);
//            if(i > 0){
                o.append(" ");
//            }
        }
        return o.toString();
    }




    // 使用栈  步骤 1. 将split后的 每个字符串入栈 2.之后出栈，刚好顺序倒转
    public String ReverseSentence2(String str) {
        if (str.trim().equals("") && str.length() > 0) {
            return str;
        }
        Stack reverse = new Stack();
        String string = str.trim();
        String[] strings = string.split(" ");
        for (int i = 0; i <strings.length; i++) {
            reverse.push(strings[i]);
        }
        string = (String)reverse.pop();
        while (!reverse.isEmpty()) {
            string = string + " " + reverse.pop();
        }
        return string;
    }




    /**  属于编程的基本功力，熟练
      算法思想：先翻转整个句子，然后，依次翻转每个单词。
    依据空格来确定单词的起始和终止位置
     student. a am I

     */
    public String ReverseSentence3(String str) {
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length - 1);
        int blank = -1;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                int nextBlank = i;
                reverse(chars,blank + 1,nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars,blank + 1,chars.length - 1);//最后一个单词单独进行反转
        return new String(chars);

    }
    public void reverse(char[] chars,int low,int high){
        while(low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }





    /*  是将方法3的if 替换成了while
     * 剑指offer的思想：两次翻转
     */
        public String ReverseSentence4(String str) {
            if(str==null||str.trim().getClass().equals(""))
                return str;
            char[] c=str.toCharArray();

            reverse4(c, 0, str.length()-1);//翻转整个句子

            //翻转句子中的每个单词
            int begin=0;
            int end=0;
            while(begin!=c.length){//若起始字符为空格，则begin和end都自加
                if(c[begin]==' '){
                    begin++;
                    end++;
                }
                else if(c[end]==' '){//遍历到终止字符为空格，就进行翻转
                    reverse4(c, begin, --end);
                    begin=++end;
                }
                else if(end==c.length-1){//若遍历结束，就进行翻转
                    reverse4(c, begin,end);
                    begin=++end;
                }
                else{//没有遍历到空格或者遍历结束，则单独对end自减
                    end++;
                }
            }

            return String.valueOf(c);
        }

        //完成翻转功能
        private void reverse4(char[] c,int begin,int end){
            while(begin<end){
                char temp=c[begin];
                c[begin]=c[end];
                c[end]=temp;

                begin++;
                end--;
            }
        }

}

