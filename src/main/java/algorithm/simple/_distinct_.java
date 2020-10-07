package algorithm.simple;//package algorithm.simple;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.google.common.collect.Sets;
//
//import java.util.*;
//
//public class _distinct_ {
//    public static void main(String[] args) {
//        int arr2[]={1,2,2,3,3,4,5};
//        showNonDuplicateArray(arr2);
//
//
//        Object arr1[]={1,2,2,3,3,4,5};
//        System.out.println(Arrays.toString(fourClear(arr1)));
//
//
//
//        String[] arr = {"jslkdfj", "sds", "ss", "dd", "nn", "mm", "nn", "mm"};
//        //数组去重：
//        //  方案一：（将数据放入到新的List里面）
//        List<String> list = Lists.newArrayList();
//        for (int i = 0; i < arr.length; i++) {
//            if (!list.contains(arr[i])) {
//                list.add(arr[i]);
//            }
//        }
//        list.stream().forEach(System.out::println);
//        // 方案二：（利用java8新特性去重）
//        Arrays.asList(arr).stream().distinct().forEach(System.out::println);
//        // 方案三：（利用Set集合或是TreeSet集合）
//        Set<String> set = Sets.newHashSet(Arrays.asList(arr));
//        Iterator<String> it = set.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//        // 方案四：（利用Map集合中的keySet、entrySet方法）
//        Map<String, Object> map = Maps.newHashMap();
//        for (String s : arr) {
//            map.put(s, s);
//        }
//        // for (String key : map.keySet()) {
//        //    System.out.println(key);
//        //  }
//        for (Map.Entry<String, Object> m : map.entrySet()) {
//            System.out.println(m.getKey());
//        }
//
//
//        //方案五：（利用两次for循环，一个正循环，一个倒循环）
//        List<String> listStr = Lists.newArrayList(arr);
//        for (int i = 0; i <= listStr.size() - 1; i++) {
//            for (int j = listStr.size() - 1; j > i; j--) {
//                if (listStr.get(i).equals(listStr.get(j))) {
//                    listStr.remove(j);
//                }
//            }
//        }
//
//        listStr.forEach(System.out::println);
//
//
//
//    }
//
//    // todo pass
//    public static void showNonDuplicateArray(int[] a) {
//        int[] newArr = new int[a.length];
//
//        int index = 0; // 新数组存储元素索引(或者说无重复的个数)
//
//        outer: for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                //当数据重复时,跳出外圈循环
//                if (a[i] == a[j]) {
//                    continue  outer; // 还不能用break
//                }
//            }
//            // 后面没有与当前元素重复的值,保存这个数
//            newArr[index] = a[i];
//            index++;
//        }
//        // 新数组中存储着无重复的值和后面一些0
//        int[] result = new int[index];
//        for (int i = 0; i < index; i++) { // 遍历有效值个数
//            result[i] = newArr[i];
//        }
//        System.out.println(Arrays.toString(result));
//        System.out.println("-----------------------");
//
//    }
//
//    //第一种方式:最开始想到的是利用Set集合的不可重复性进行元素过滤
//    public static Object[] oneClear(Object[] arr){
//        Set set = new HashSet();
//        for(int i=0;i<arr.length;i++){
//        set.add(arr[i]);
//    }
//        return set.toArray();
//    }
//
//    //第二种方式:要想保持原数组的顺序就使用有顺序、不重复特点的链表的哈希集合
//    public static Object[] twoClear(Object[] arr){
//        LinkedHashSet<Object> temp = new LinkedHashSet<>();
//        for(int i=0;i<arr.length;i++){
//        temp.add(arr[i]);
//    }
//        return temp.toArray();
//    }
//
//    //第三种方式:创建一个list集合，然后遍历数组将元素放入集合，再用contains()方法判断一个集合中是否已存在该元素即可
//    public static Object[] threeClear(Object[] arr){
//        List list = new ArrayList();
//        for(int i=0;i<arr.length;i++){
//            if(!list.contains(arr[i])){
//                list.add(arr[i]);
//            }
//        }
//        return list.toArray();
//    }
//
//    //第四种方式:两层循环遍历原数组，然后逐个判断是否和之后的元素重复，同时设立一个标记，用来分辨是否重复，根据标记将不重复的元素存入新数组
//
//    public static Object[] fourClear(Object[] arr){
//    int t=0;
//    //临时数组
//        Object[] xinArr=new Object[arr.length];
//
//        for(int i=0;i<arr.length;i++){
//            //声明标记，是否重复
//            boolean isRepeat = true;
//            for(int j=i+1;j<arr.length;j++){
//                //如果有重复元素，将标记置为false
//                if(arr[i]==arr[j]){
//                    isRepeat = false;
//                    break;
//                }
//            }
//            //标记为true表示没有重复元素
//            if(isRepeat){
//                xinArr[t] = arr[i];
//                t++;
//            }
//        }
//        //去重后数组
//        Object[] newArr = new Object[t];
//        System.arraycopy(xinArr, 0, newArr, 0, t);
//        return newArr;
//    }
//}
