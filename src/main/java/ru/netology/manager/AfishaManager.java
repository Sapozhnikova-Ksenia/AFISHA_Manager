package ru.netology.manager;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.afisha.Film;

@NoArgsConstructor
@Data

public class AfishaManager {
    //ввели переменную ожидаемого (желаемого) выводимого количества фильмов по умолчанию
    private int expectedLengthAfishaFilm = 10;

    public AfishaManager(int expectedLengthAfishaFilm) {
        this.expectedLengthAfishaFilm = expectedLengthAfishaFilm;
    }
//создали с помощью конструктора АфишуМенеджер (аннотации выше)


    //создаем пустой массив фильмов
    private Film[] films = new Film[0];

    //создаем метод добавления фильмов в массив,
    // он публичный, не возвращающий,
    // в скобках пишем тип и название объекта, которое берем на вход при добавлении
    public void addNewFilm(Film film) {
        //обозначаем что индекс равен 0
        int i = 0;
        //создаем новый массив на единицу больше такого же типа, но с др названием
        Film[] tmp = new Film[films.length + 1];
        //копируем поэлементно из массива фильмов в массив тмп
        // первая ячейка с нулевым индексом, пока индекс текущей ячейки меньше
        // длинны массива, увеличиваем индекс (номер трогаемой ячейки на 1)
        for (i = 0; i < films.length; i++) {
            //и присваиваем ячейке из тмп скопированное из фильмов
            tmp[i] = films[i];
        }
        //заполяем последнюю ячейку тмп тем элементом, который мы прописали что хотим добавить
        //этот элемент у нас в скобках на входе, при именовании метода
        tmp[tmp.length - 1] = film;
        //переименовываем массив тмп в массив фильмов
        films = tmp;
    }


    //создаем метод вывода в ленту последних добавленных фильмов
    //метод публичный, возвращаемый тип- массив каких-то фильмов, и название
    //на вход ничего не передаем, все что надо он уже помнит
    public Film[] getLastFilm() {
        //вводим переменную определяющую длину отдаваемого размера ленты афиши
        int resultLengthAfishaFilm;
        // прописываем условие- что если количество фильмов (длинна массива фильмов)
        // больше ожидаемой длины выдаваемой ленты афиши фильмов resultLengthAfishaFilm,
        // то тогда наша итоговая переменная resultLengthAfishaFilm будет равна expectedLengthAfishaFilm,
        // иначе если фильмов меньше чем ожидаемая длина ленты,то итоговая переменная resultLengthAfishaFilm
        // будет равна длине массива фильмов
        if (films.length > expectedLengthAfishaFilm) {
            resultLengthAfishaFilm = expectedLengthAfishaFilm;
        } else {
            resultLengthAfishaFilm = films.length;
        }
        //теперь когда мы определились сколько фильмов в ленту выдавать, сделаем выдачу фильмов "наоборот"
        //создадим новый массив тмп, в который будут копироваться элементы из массива Фильмов, от послед к первому

        Film[] tmp = new Film[resultLengthAfishaFilm];
        //введем переменную инт индекс
        int i = 0;
        for (i = 0; i < tmp.length; i++) {
            tmp[i] = films[films.length - i - 1];
        }
        return tmp;
    }
}


