package LeetCodeCards.Array;

import java.time.LocalDate;

public class DVD {
    public  int id;
    public String name;
    public int releaseYear;

    @Override
    public String toString() {
        return "ID: " + this.id + " NAME: " + this.name + " RELEASE YEAR: " + this.releaseYear;
    }

    public static void main(String[] args) {
        DVD[] dvds = new DVD[15];

        for (int i=0; i<15; i++){
            dvds[i] = new DVD();
            dvds[i].id = i;
            dvds[i].name = "DVD" + i;
            dvds[i].releaseYear = LocalDate.now().getYear() - i;
        }
        for (DVD dvd : dvds){
            System.out.println(dvd.toString());
        }
    }
}
