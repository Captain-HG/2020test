package com.lzc.nginxsetting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = NginxSettingApplicationTests.class)
class NginxSettingApplicationTests {

    @Test
    void sortMaoPao() {
        String str="dsadasda4";
        System.out.println(str.substring(0,2));
        int[] arr ={1,5,8,1651,22,651,1516,65};

        int length = arr.length;
        for(int i=0; i<length; i++){
            for(int j=0 ;j<length-i-1;j++){

                if(arr[j]>arr[j+1]){
                   int temp = arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
                }
            }
        }

        for(int z=0 ;z<length;z++){
            System.out.println(arr[z]);
        }

    }

    /**
     * 快速排序
     */
    void sortQuicky(int[] arr, int left ,int right){

//        int[] arr ={1,5,8,3,12,2,15,20};

         int k = arr[left];//基准

        int i=left;
        int j=right;

        while (j>i){

            //判断右边
            if(k<arr[j]){
              j--;
            }

            //判断左边
            if(k>arr[i]){
              i++;
            }

        }



    }


    /**
     * 折半查询
     */
    @Test
    void midQuery(){
        int arr[] = {1,2,5,9,14,15,19,23,55,66};
        int queryNum = 15;
        int min=0;
        int max=arr.length-1;

        int mid = (arr.length-1)/2;//中间点
        int index = -1;
        System.out.println(min+","+max+","+mid);

        while(true){
            if(arr[mid]==queryNum){
                index=mid;
                break;
            }

            if(arr[mid]>queryNum){
                max=mid-1;
                mid=(min+max)/2;
            }

            if(arr[mid]<queryNum){
                min=mid+1;
                mid=(min+max)/2;
            }

            if(mid>max){
                System.out.println("查询无结果");

                break;
            }

        }
            if(index==-1){
                System.out.println("查询无结果");
            }else{
                System.out.println(index);
            }
    }


    /**
     * 选择排序
     */
    @Test
    public void sortChance(){
        int[] arr ={1,5,8,1651,22,651,1516,65};

        int max = arr.length;
        int index = 0;

        for(int i=0;i<max-1;i++){
            index=i;
            for(int j=i+1;j<max;j++){
                System.out.println("j:"+j);
                if(arr[j]<arr[index]){
                    index=j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[index];
            arr[index]=temp;
        }


        for(int z=0 ;z<max;z++){
            System.out.println(arr[z]);
        }

    }
}
