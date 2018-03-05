import javax.xml.ws.Holder;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        test1();
    }
    private static void test1(){
//       Stream<String> stream=Stream.of("wyj","am","i","hello");
//        Integer length=stream.reduce(0,(sum,str)->sum+str.length(),
//                (a,b)->a+b);
//        int length = stream.mapToInt(str -> str.length()).sum();
//        System.out.println(length);
        //stream.sorted().forEach(x->System.out.println(x));
        //stream.sorted((x,y)->x.length()-y.length()).forEach(System.out::println);
//
//        stream.map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));
//        List<String> list = Arrays.asList("qqq","aaa","bbb","ccc","ddd");
//        list.stream().sorted().forEach(System.out::println);
//
//        Stream<List<Integer>> stream1 = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
//        stream1.flatMap(l -> l.stream())
//                .forEach(i -> System.out.println(i));

//        Stream<String> stream = Stream.of("I", "love", "you", "too");
//        //List<String> lst=stream.collect(Collectors.toList());
//        //Set<String> set=stream.collect(Collectors.toSet());
//        Map<String,Integer> map=stream.collect(Collectors.toMap(Function.identity(),String::length));
//        map.forEach((x,y)->System.out.println(x+" "+y));

        //1. 前端数组
        Integer[] client=new Integer[]{111,121,151,141,131};
        //2. 定义一个map
        // key:group value:map<id,no>
        Map<Integer,Map<Integer,Integer>> bigMap=new HashMap<>();
        //3. 根据数组，查询出对应的group和no，填充到map集合
        for(Integer i:client){
            Integer group=0;
            Integer no=1;
            // 这里假设group和no是随机数，实际情况从数据库获得
            group=(int)(Math.random()*5);
            no=(int)(Math.random()*10);
            if(bigMap.containsKey(group)){ // 如果已存在，则追加
                bigMap.get(group).put(i,no);
            }else { // 如果不存在则添加新值
                Map<Integer,Integer> valueMap= new HashMap<>();
                valueMap.put(i,no);
                bigMap.put(group,valueMap);
            }
        }
        // 打印集合，查看结果
        bigMap.forEach((x,y)->{
                 System.out.println("group:"+x);
                 y.forEach((a,b)->{
                     System.out.println("   id:"+a+" no:"+b);
                 });
                });
        // 4. 根据集合排序value里面的值
        bigMap.forEach((x,y)->{
           // 获取一个组里面的所有no，然后顺序赋值给value
            List<Integer> integers=y.values().stream().collect(Collectors.toList());
            y.forEach((a,b)->{
                // 查询integers集合里的最小值
                Integer smallValue=integers.stream().min(Comparator.comparing(num -> num)).get();
                y.put(a,smallValue); // 给最小的值
                integers.remove(smallValue); // 清除掉集合里的最小值
            });
        });
        // 打印集合，查看结果
        System.out.println("排序后----------");
        bigMap.forEach((x,y)->{
            System.out.println("group:"+x);
            y.forEach((a,b)->{
                System.out.println("   id:"+a+" no:"+b);
            });
        });


//
//        Map<Integer,Integer> m=new HashMap<>();
//        m.put(1,1);
//        m.put(2,2);
//        m.put(3,3);
//
//        Integer[] in=m.values().stream().toArray(Integer[]::new);
//        for (Integer i:in) {
//            System.out.println(i);
//        }

    }
}
