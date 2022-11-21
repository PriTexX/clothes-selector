package com.example.clothesservice.service.implementations;

import com.example.clothesservice.models.ClothesKit;
import com.example.clothesservice.models.WeatherModel;
import com.example.clothesservice.service.interfaces.IClothesSelector;
import com.example.clothesservice.util.ChoiceTree;

public class ClothesSelector implements IClothesSelector {
    @Override
    public ClothesKit PickClothes(WeatherModel weatherModel) {
        var tree = new ChoiceTree();
        var rootNode = new ChoiceTree.Node();

        var firstNode = new ChoiceTree.Node();
        firstNode.set_condition("-20_-15");
        firstNode.set_predicate((var one, var another) -> {
            var range = ParseString(one);
            return Integer.parseInt(another) > range[0] && Integer.parseInt(another) < range[1];
        });
        return null;
    }

    private int[] ParseString(String str){
        var idx = str.indexOf("_");
        if(idx == -1) throw new RuntimeException("Cannot parse string %s".formatted(str));

        var firstInt = Integer.parseInt(str.substring(0, idx));
        var secondInt = Integer.parseInt(str.substring(idx+1));

        return new int[]{firstInt, secondInt};
    }
}
