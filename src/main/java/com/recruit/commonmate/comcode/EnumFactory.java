package com.recruit.commonmate.comcode;

import com.recruit.commonmate.comcode.dto.EnumDTO;
import com.recruit.commonmate.comcode.dto.EnumMapper;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnumFactory {

    private Map<String, List<EnumDTO>> factory = new LinkedHashMap<>();

    public List<EnumDTO> get(String key){
        return factory.get(key);
    }

    public Map<String, List<EnumDTO>> get(List<String> keys){
        if (keys == null || keys.isEmpty())
            return new LinkedHashMap<>();
        return keys.stream()
                .collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
    }

    public Map<String, List<EnumDTO>> get(){
        return this.factory;
    }

    public List<String> keys(){
        return new ArrayList<>(factory.keySet());
    }

    public void put(String key, Class<? extends EnumMapper> e){
        factory.put(key, toEnumValue(e));
    }

    private List<EnumDTO> toEnumValue(Class<? extends EnumMapper> e){
        return Arrays.stream(e.getEnumConstants())
                .map(EnumDTO::new)
                .collect(Collectors.toList());
    }

}
