package seminar7.presenter;

import seminar7.model.FamilyTree;
import seminar7.model.Human;
import seminar7.model.IO;
import seminar7.model.comparator.HumanComparatorByAge;
import seminar7.ui.View;

public class Presenter {
    private View view;
    private IO serializ;
    private FamilyTree<Human> familyConnect;
    private HumanComparatorByAge sortAge;

    public Presenter(View view, FamilyTree<Human> familyConnect, IO serializ, HumanComparatorByAge sortAge) 
    {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serializ = serializ;
        this.sortAge = sortAge;
        view.setPresenter(this);
    }

    public void addHumanNew(String name, String sex, int age)
    {        
        familyConnect.addFamilyFree(new Human(name, sex, age));
        view.print("Новый член семьи добавлен !");
    }

    public void familyPrint() 
    {
        String family = familyConnect.toString();
        view.print(family);       
    }

    public void humanSearch(String name) 
    {
        Human chelovek = familyConnect.getByName(name);
        if (chelovek == null) view.print("Такого человека нет в семье !");
        
        else 
        {
            String human = chelovek.toString();
            view.print(human);
        }
    }

    public void saveFamily()
    {
        familyConnect.saveObj(serializ);
        view.print("Семейное древо сохранено !");
    }

    public void loadFamily()
    {
        serializ.load("FreeFamily.data");
    }

    public void sortFamilyName()
    {
        familyConnect.getFamilyFree().sort(null);
        view.print("Сортировка завершена !");
    }

    public void sortFamilyAge()
    {
        familyConnect.getFamilyFree().sort(sortAge);
        view.print("Сортировка завершена !");
    }
}
