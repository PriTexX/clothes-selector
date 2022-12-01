package com.example.clothesservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClothesKit {
    private List<String> upperClothes;
    private List<String> lowerClothes;
    private List<String> shoes;
}
