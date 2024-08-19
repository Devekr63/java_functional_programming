package org.example.anonymous_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunMethods {
    public static void main(String[] args) {
        ListFilter filter = new ListFilter(){
//            @Override
//            public boolean filterNumsFromList(int num){
//                if ((num^1) == num+1) return true;
//                return false;
//            }
            @Override
            public boolean filterNumsFromList(int num){
                if (num > 3) return true;
                return false;
            }
        };

        System.out.println(filter.filterNumsFromList(4));

        Filter newFilter = new Filter(filter);
        newFilter.execute(Arrays.asList(2,1,5,6,7,8,11)).forEach(System.out::println);
    }
}

//Filter interface
interface ListFilter {
    boolean filterNumsFromList(int num);
}

class Filter {
    ListFilter listFilter;

    public Filter(ListFilter listFilter) {
        this.listFilter = listFilter;
    }

    public List<Integer> execute(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for(Integer num : list){
            if(listFilter.filterNumsFromList(num)) res.add(num);
        }
        return res;
    }
}
