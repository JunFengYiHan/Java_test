package leetcode.other.员工的重要性;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-01
 * Time: 11:19
 */

public class Solution {
    Map<Integer,Employee> map = new HashMap<>();//以员工的id映射其他属性
    public int getImportance(List<Employee> employees, int id) {
        //存入映射关系
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id,employees.get(i));
        }
        return getValue(id);
    }
    //返回当前员工的重要度
    private int getValue(int id) {
        Employee master = map.get(id);
        int ret = master.importance;//当前员工重要度
        for (int sub:master.subordinates) {
            ret += getValue(sub);//下属的重要度
        }
        return ret;
    }
//    private int getValue(int id) {
//        Employee master = map.get(id);
//        int ret = master.importance;//当前员工重要度
//        for (int dirSub:master.subordinates) {
//            Employee other = map.get(dirSub);
//            ret +=other.importance;//直系下属员工重要度
//            for (int sub:other.subordinates) {
//                ret += getValue(sub);//下属的下属
//            }
//        }
//        return ret;
//    }
    //未完善的做法
//    public int getImportance(List<Employee> employees, int id) {
//        int index = -1;
//        for (int i = 0; i < employees.size(); i++) {
//            if (employees.get(i).id==id) {
//                index = i;//拿到当前id所在下标
//                break;
//            }
//        }
//        int importance = employees.get(index).importance;//初值为当前员工的重要程度
//        for (int i = 0; i < employees.get(index).subordinates.size(); i++) {
//            importance += helper(employees,employees.get(index).subordinates.get(i));
//        }
//        return importance;
//    }
//
//    private int helper(List<Employee> employees, Integer id) {
//        int index = -1;
//        for (int i = 0; i < employees.size(); i++) {
//            if (employees.get(i).id==id) {
//                index = i;//拿到当前id所在下标
//                break;
//            }
//        }
//        return employees.get(index).importance;
//    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
