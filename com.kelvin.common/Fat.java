import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Fat
 * @Descripiton
 * @Author kelvin
 * @Date 2019/10/24 上午11:26
 * @Version 1.0
 **/
public class Fat {

    int all = 120;

    public static void main(String[] args) {
        Fat fat = new Fat();
        fat.test();
    }

    public int random(int src){
        int max=src,min=1;
        int ran2 = (int) (Math.random()*(max-min)+min);
        return ran2;
    }

    public void test(){
        int lou = random(all);
        int bu = random(lou);
        int[] louDays = new int[lou];
        for(int i=0; i<lou; i++){
//            int ran = random(all);
            int res = 0;
            boolean flag = true;
            while (flag) {
                int ran = random(all);
                boolean a = false;
                for (int b = 0; b < louDays.length; b++) {
                    if (ran == louDays[b]) {
                        a = true;
                        break;
                    }
                }
                flag = a;
                res = ran;
            }
            louDays[i] = res;

        }
        System.out.println(lou + "," +bu);
//        for(int a=0; a<louDays.length; a++){
//            System.out.print(louDays[a] + ",");
//        }
//        System.out.println();
        int res = bu(7,3,new int[]{10,30,55,56,90,99,110});
//        int res = bu(lou,bu, louDays);
        System.out.println(res);
    }

    public int bu(int lou, int bu, int[] louDays){
        if(bu >= lou){
            return all;
        }
        int[] result = new int[lou+1];
        Arrays.sort(louDays);
        for(int i=0;i<louDays.length;i++){
            System.out.print(louDays[i]+",");
        }
        System.out.println();
        int flag = 1;
        for(int i=0; i<lou; i++){
            result[i] = louDays[i] - flag;
            flag = louDays[i] + 1;
        }
        result[lou] = all - louDays[lou-1];
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+",");
        }
        System.out.println();
        int res;
        int realRes = 0;
        for(int i=0 ;i<result.length-bu; i++){
            res = 0;
            for(int j=0; j<bu+1; j++){
                res = res+result[i+j];
            }
            if(res > realRes){
                realRes = res;
            }
        }
        realRes = realRes + bu;
        return realRes;
    }
}
