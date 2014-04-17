package com.fajfar.java101.lesson2.strategy;

import java.util.HashMap;
import java.util.Map;

public class WriterManager {
    private Map<WriterAction, Writer> actionMap;

    public WriterManager(){
        this.actionMap = new HashMap<>();

        this.actionMap.put(WriterAction.LOWER_CASE, new LowerCaseWriter());
        this.actionMap.put(WriterAction.UPPER_CASE, new UpperCaseWriter());
        this.actionMap.put(WriterAction.REMOVE_VOVELS, new RemoveVowels());
    }

    public String applyWriterAction(String target, WriterAction...writerActions){
        for(WriterAction action : writerActions){
            if(this.actionMap.containsKey(action)){
                target = this.actionMap.get(action).write(target);
            }
        }
        return target;
    }
}
