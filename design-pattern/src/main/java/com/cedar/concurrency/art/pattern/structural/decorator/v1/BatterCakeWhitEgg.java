package com.cedar.concurrency.art.pattern.structural.decorator.v1;

/**
 * @author zhangnan
 * @date 2020-06-28 11:15
 * @description
 */
public class BatterCakeWhitEgg extends BatterCake {

    @Override
    protected String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
