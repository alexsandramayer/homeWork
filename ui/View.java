package seminar7.ui;

import seminar7.presenter.Presenter;

public interface View 
{
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
    String scan(); 
}