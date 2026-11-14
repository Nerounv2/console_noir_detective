package ru.noir.model.entities;

import ru.noir.model.investigation.Clue;

import java.util.List;

public class Detective {
    public int x, y;
    private List<Clue> notebook;

    public Detective(int x, int y){
            this.x = x;
            this.y = y;
    }

    public void move(int dx,int dy){
        this.x += dx;
        this.y += dy;
    }

    public void addClue(Clue clue){
        this.notebook.add(clue);
    }


    public List<Clue> getNotebook(){
        return this.notebook;
    }
}
