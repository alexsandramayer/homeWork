package seminar7.model.comparator;

import java.util.Iterator;
import java.util.List;

import seminar7.model.Animal;

public class AnimalIterator <T extends Animal> implements Iterator<T>{
    private int index;
    private List<T> humans;

    public AnimalIterator(List<T> humans)
    {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() // есть ли следующий элемент
    {
        return humans.size() > index;
    }

    @Override
    public T next() // выдает элемент
    {
        return humans.get(index++);
    }
}



