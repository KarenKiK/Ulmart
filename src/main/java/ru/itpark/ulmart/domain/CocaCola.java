package ru.itpark.ulmart.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CocaCola extends Product{
    private int shelfLIve;
    private String volume;
    private String taste;

    public CocaCola(int shelfLIve, String volume, String taste) {
        this.shelfLIve = shelfLIve;
        this.volume = volume;
        this.taste = taste;
    }

    public CocaCola(int id, String name, int price, int shelfLIve, String volume, String taste) {
        super(id, name, price);
        this.shelfLIve = shelfLIve;
        this.volume = volume;
        this.taste = taste;
    }

    public CocaCola(String name, int price, String os, int id, int shelfLIve, String volume, String taste) {
        super(name, price, os, id);
        this.shelfLIve = shelfLIve;
        this.volume = volume;
        this.taste = taste;
    }
}
