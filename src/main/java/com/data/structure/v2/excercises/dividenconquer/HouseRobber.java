package com.data.structure.v2.excercises.dividenconquer;

public class HouseRobber {


    public void maxMoneyCanbeStolenFromHouses(int[] netWorthofHouses) {
        int maxMoney = maxMoneyStolenRecursive(netWorthofHouses, 0);
        System.out.println("max money stolen : "+ maxMoney);
    }

    private int maxMoneyStolenRecursive(int[] netWorthofHouses, int index) {
        if(index >= netWorthofHouses.length) {
            return 0;
        }
        int firstHouseStolenValue = netWorthofHouses[index] + maxMoneyStolenRecursive(netWorthofHouses, index+2);
        int secondHouseStolenValue = maxMoneyStolenRecursive(netWorthofHouses, index+1);
        return Math.max(firstHouseStolenValue, secondHouseStolenValue);
    }

    public static void main(String[] args) {
        int netWorthofHouses[] = {6,7,1,30,8,2,4};
        HouseRobber hr = new HouseRobber();
        hr.maxMoneyCanbeStolenFromHouses(netWorthofHouses);
    }

}
