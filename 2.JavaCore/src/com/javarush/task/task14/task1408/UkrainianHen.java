package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen implements Country{
    @Override
    public int getCountOfEggsPerMonth() {
        return 250;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+String.format(" Моя страна - %s. Я несу %d яиц в месяц.",Country.UKRAINE,getCountOfEggsPerMonth());
    }
}
