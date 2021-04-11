package Bridge;

import factorymethod.Food;

public class Goodboy {

    public void chase(PreetyGirl girl) {
        Gift gift = new WarmGift(new Flower());
        give(girl, gift);

    }

    public void give(PreetyGirl girl, Gift gift) {

    }
}
