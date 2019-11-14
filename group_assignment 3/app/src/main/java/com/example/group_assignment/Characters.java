package com.example.group_assignment;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.lang.reflect.Array;
@Entity
public class Characters {
    @PrimaryKey
    @NonNull
    private int cha_id;
    private String character;
    private String pinyin;
    private String Status;
    private String explaination;
    private String translation;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public int getCha_id() {
        return cha_id;
    }

    public void setCha_id(int cha_id) {
        this.cha_id = cha_id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
