package 排序;

public class 年龄排序 {
    public static void sort(int []ages){
        int oldestAge=100;
        int []timesOfAges=new int[oldestAge];

        int len=ages.length;
        for(int i=0;i<len;i++){
            timesOfAges[ages[i]]++;;
        }


        //排序
        int index=0;
        for(int i=0;i<oldestAge;i++){
            for(int j=0;j<timesOfAges[i];j++){

                ages[index]=i;
                index++;
            }
        }


    }

    public static void main(String[] args) {
        int age[] = {4,2,8,0,5,7,1,3,9,8,4,19,20,13,11,12,13,13,14,0};
        sort(age);
        System.out.println(age.length);
    }
}
