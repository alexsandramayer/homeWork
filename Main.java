package seminar7;

import java.io.IOException;

import seminar7.model.FamilyTree;
import seminar7.model.Human;
import seminar7.model.IO;
import seminar7.model.comparator.HumanComparatorByAge;
import seminar7.presenter.Presenter;
import seminar7.ui.Console;
import seminar7.ui.View;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        FamilyTree<Human> familyFree = new FamilyTree<>();

        familyFree.addFamilyFree(new Human("Майк", "муж.", 37));
        familyFree.addFamilyFree(new Human("Алекс", "муж.", 35));
        familyFree.addFamilyFree(new Human("Аннет", "жен.", 27));
        familyFree.addFamilyFree(new Human("Сири", "муж.", 7, 
            familyFree.getByName("Аннет"), familyFree.getByName("алекс"))); 
        familyFree.addFamilyFree(new Human("Кейт", "жен.", 5, 
            familyFree.getByName("Аннет"), familyFree.getByName("алекс")));
        
        // Модуль MVP
        View view = new Console();
        IO serializ = new IO();
        HumanComparatorByAge sortAge =  new HumanComparatorByAge();
        new Presenter(view, familyFree, serializ, sortAge);
        view.start();
    }
    
}
