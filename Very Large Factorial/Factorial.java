import java.text.DecimalFormat;

/**
 * Factorial class can be used to calculate factorial of a number.
 */
public class Factorial {
    private static DecimalFormat dec = new DecimalFormat("000");

    // Helper method to add two lists
    private static List addLists(List list1, List list2){
        List list3 = new List();
        int res = 0;
        int carry = 0;

        ListNode cursor1 = list1.getFirstNode();
        ListNode cursor2 = list2.getFirstNode();

        while(cursor1 != null && cursor2 != null){
            res = carry + cursor1.getInfo() + cursor2.getInfo();
            if(res > 999) {
                carry = res / 1000;
                res = res % 1000;
            }
            else
                carry = 0;
            list3.addLast(res);
            cursor1 = cursor1.getNext();
            cursor2 = cursor2.getNext();
        }


        while (cursor1 != null) {
            res = cursor1.getInfo() + carry;
            if (res > 999) {
                carry = res / 1000;
                res = res % 1000;
            } else
                carry = 0;
            list3.addLast(res);
            cursor1 = cursor1.getNext();
        }
        while (cursor2 != null) {
            res = cursor2.getInfo() + carry;
            if (res > 999) {
                carry = res / 1000;
                res = res % 1000;
            }
            else
                carry = 0;
            list3.addLast(res);
            cursor2 = cursor2.getNext();
        }

        if(carry != 0){
            list3.addLast(carry);
        }

        return list3;
    }

    // Shifts the List by n number of tens
    private static void shift10(List list, int n){

        int carry = 0;
        for(int i =0; i < n; i++){
            ListNode cursor = list.getFirstNode();

            int res = cursor.getInfo() * 10;

            while (cursor.getNext() != null) {
                if (res > 999) {
                    carry = res / 1000;
                    res = res % 1000;
                } else
                    carry = 0;
                cursor.setInfo(res);
                //list.addLast(res);
                cursor = cursor.getNext();
                res = cursor.getInfo() * 10 + carry;
                //System.out.println(res);
            }

            if (res > 999) {
                carry = res / 1000;
                res = res % 1000;
            } else {
                carry = 0;
            }
            cursor.setInfo(res);
            //list.addLast(res);

            if (carry != 0)
                list.addLast(carry);
            //result.addLast(res);

        }

    }


    /**
     * Finds factorial of a given number and returns it in the form of a List,
     * whose nodes contain 3 digits from the number. First Node contains 3
     * least significant digits and last node contains most significant digit.
     * @param num integer
     * @return List containing the number
     */
    public static List findFactorial(int num) {
        if (num < 0) {
            System.out.println("[ERROR] It must be " +
                    "a positive number.");
            return null;
        }

        List result = new List();
        result.addFirst(1);
        //result.reverse();
        for (int i = 2; i <= num; i++) {
            int carry = 0;
            int multiplier = i;
            int k = -1;
            List add = new List();

            while (multiplier > 0) {
                List hl = new List();
                int j = (multiplier % 10);
                //System.out.println("When multiplier is "+j+"\n");
                multiplier = multiplier / 10;
                k = k + 1;
                if (j == 0) {
                    continue;
                }
                ListNode cursor = result.getFirstNode();

                int res = cursor.getInfo() * j;

                while (cursor.getNext() != null) {
                    if (res > 999) {
                        carry = res / 1000;
                        res = res % 1000;
                    } else
                        carry = 0;
                    //cursor.setInfo(res);
                    hl.addLast(res);
                    cursor = cursor.getNext();
                    res = cursor.getInfo() * j + carry;
                    //System.out.println(res);
                }

                if (res > 999) {
                    carry = res / 1000;
                    res = res % 1000;
                } else {
                    carry = 0;
                }
                //cursor.setInfo(res);
                hl.addLast(res);

                if (carry != 0)
                    hl.addLast(carry);
                //result.addLast(res);

                shift10(hl,k);
                add = addLists(add, hl);

            }
            result = add;
        }
        return result;
    }

    /**
     * Calculates factorial of a given number and returns it in a form of
     * String.
     * @param num integer
     * @return String representation of the number
     */
    public static String findFactorialString(int num) {
        List result = findFactorial(num);
        //System.out.println(result.size());
        DecimalFormat dec= new DecimalFormat("000");
        ListNode cursor = result.getFirstNode();
        String str = "";
        while (cursor.getNext() != null) {
            num = cursor.getInfo();
            str = ","+ dec.format(num) + str;
            cursor = cursor.getNext();
        }
        str = cursor.getInfo() + str;
        return str;
    }

    /**
     * Can be used to convert the list obtained from findFactorial(int num)
     * to formatted string. The output string is properly formatted with
     * commas after every 3 digits and maximum 45 digits in a line.
     * @param result List obtained from findFactorial(int num)
     * @return String representation of the List
     */
    public static String formatNumberOutput(List result) {

        //DecimalFormat dec= new DecimalFormat("000");
        ListNode cursor = result.getFirstNode();
        String str = "";
        int count = 0;
        int size = result.size();
        count = 15 - (size % 15) ;
        while (cursor.getNext() != null) {
            int num = cursor.getInfo();
            count++;
            if(count / 15 == 1) {
                str = ",\n" +dec.format(num)+ str;
                count = 0;
            }
            else
                str = ","+ dec.format(num) + str;
            cursor = cursor.getNext();
        }
        str = cursor.getInfo() + str;

        return str;
    }

    /**
     * Calculates the number of digits in the result
     * @param result List obtained from findFactorial(int num)
     * @return int
     */
    public static int numOfDigits(List result){
        if (result == null)
            return 0;
        if(result.size() == 0)
            return 0;
        if(result.size() == 1) {
            String firstNum = result.getLast() + "";
            return firstNum.length();
        }
        String firstNum = result.getLast() + "";
        return firstNum.length()+(result.size()-1)*3;
    }
}
