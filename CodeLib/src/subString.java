import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class subString {
    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Set<Character> repeatChar;
        int max = 0;
        int count;
        for (int i = 0; i < arr.length; ++i) {
            count = 1;
            repeatChar = new HashSet<Character>();
            repeatChar.add(arr[i]);
            for (int j = i + 1; j < arr.length; ++j) {
                if (repeatChar.contains(arr[j])) {
                    break;
                }
                repeatChar.add(arr[j]);
                count++;
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        int max = 0, i = 0, j = 0;
        Set<Character> strWithoutRepeat = new HashSet<Character>();
        while (i < len && j < len) {
            if (!strWithoutRepeat.contains(s.charAt(j))) {
                strWithoutRepeat.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                strWithoutRepeat.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        String a = "abcabcbb";
//        String b = "bbbbb";
//        String c = "pwwkew";
//
//        System.out.println(lengthOfLongestSubstring2(a));
//        System.out.println(lengthOfLongestSubstring2(b));
//        System.out.println(lengthOfLongestSubstring2(c));

        subString a = new subString();



    }

    public subString() {
        Manager boss = new Manager().setBonus(200);
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee[] employees = new Employee[3];
        employees[0] = boss;
        employees[1] = employee1;
        employees[2] = employee2;
        System.out.println(employees[0].getName() + " " + employees[0].getClass());
    }

    public class Employee {
        private String name;
        private double salary;

        public Employee() {
            this.name = "default";
            this.salary = 6.66;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public class Manager extends Employee {
        private double bonus;

        public double getBonus() {
            return bonus;
        }

        public Manager setBonus(double bonus) {
            this.bonus = bonus;
            return this;
        }

        @Override
        public double getSalary() {
            return super.getSalary() + bonus;
        }

        @Override
        public String toString() {
            return "Manager{" +
                    "name='" + getName() + '\'' +
                    ", salary=" + getSalary() +
                    ", bonus=" + bonus +
                    '}';
        }
    }
}
