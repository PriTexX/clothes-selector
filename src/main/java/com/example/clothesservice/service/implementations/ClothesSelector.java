package com.example.clothesservice.service.implementations;

import com.example.clothesservice.models.ClothesKit;
import com.example.clothesservice.models.WeatherModel;
import com.example.clothesservice.service.interfaces.IClothesSelector;
import com.example.clothesservice.util.choiceTree.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ClothesSelector implements IClothesSelector {
    @Override
    public ClothesKit PickClothes(WeatherModel weatherModel) {
        ChoiceTree tree;
        try {
            tree = new FileChoiceTreeBuilder("src/main/resources/data.json").Build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var nextNode = ChoiceTree.MakeChoice(tree.get_root(), Integer.toString(weatherModel.getFeelsLike()));
        nextNode = ChoiceTree.MakeChoice(nextNode, Integer.toString(weatherModel.getWindSpeed()));
        nextNode = ChoiceTree.MakeChoice(nextNode, weatherModel.getWeather());

        var data = nextNode.get_data();

        return new ClothesKit(List.of(data.get(0).split(";")), List.of(data.get(1).split(";")), List.of(data.get(2).split(";")));
    }
}
