package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.afisha.Film;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class AfishaManagerTest {

    //подготавливаем данные
    Film one = new Film(1, 123, "ty1hu", "Bloodshot", "action");
    Film two = new Film(2, 234, "ty2hu", "Onward", "cartoon");
    Film three = new Film(3, 345, "ty3hu", "Hotel_Belgrad", "comedy");
    Film four = new Film(4, 456, "ty4hu", "The_Gentelmen", "action");
    Film five = new Film(5, 567, "ty5hu", "The_invisible_man", "horror");
    Film six = new Film(6, 678, "ty6hu", "Trolls_World_Tour", "cartoon");
    Film seven = new Film(7, 789, "ty7hu", "Number_one", "comedy");
    Film eight = new Film(8, 910, "ty8hu", "Harley_Queen_the_burds_of_prey", "comedy");
    Film nine = new Film(9, 101, "ty9hu", "Venom", "action");
    Film ten = new Film(10, 111, "ty10u", "Green_lord", "horror");
    Film eleven = new Film(11, 112, "ty11u", "Disappeared", "drama");
    Film twelve = new Film(12, 113, "ty12u", "Qruella_Devil", "drama");

    //готовим тест и называем его
    @Test
    //тестируем поведение ленты при стандартном количестве фильмов 10 шт и ленте по умолчанию на 10 фильмов
    void shoudPresentLentaWithStandart() {
        //создаем новый экземпляр афиши-менеджера
        AfishaManager manager = new AfishaManager();
        //добавляем в него новые фильмы
        manager.addNewFilm(four);
        manager.addNewFilm(one);
        manager.addNewFilm(seven);
        manager.addNewFilm(two);
        manager.addNewFilm(three);
        manager.addNewFilm(eight);
        manager.addNewFilm(nine);
        manager.addNewFilm(ten);
        manager.addNewFilm(eleven);
        manager.addNewFilm(twelve);
        //выводим ожидаемое количество фильмов в массиве и фактическое
        //1ое: тип-массив фильмов, переменная-фактический рез-т= ссылаемся
        // на объект (коробку менеджера, которую мы создали в 27 строке) .
        //и ссылка на метод
        Film[] actual = manager.getLastFilm();
        //2ое: ожид рез-т = чтобы инициализировать массив, мы его как бы "создаем"
        //через нью и в фигурных скобках пишем его "ожидаемое" содержимое которое наоборот
        Film[] expected = new Film[]{twelve, eleven, ten, nine, eight, three, two, seven, one, four};
        //сравниваем два массива через ассертАррауИклс
        assertArrayEquals(expected, actual);
    }

    //тестируем поведение ленты когда фильмов более 10 (12 шт.), а лента по умолчанию на 10 фильмов
    @Test
    void shoudPresentLentaWithFilmUpStandart() {
        //создаем новый экземпляр афиши-менеджера
        AfishaManager manager = new AfishaManager();
        //добавляем в него новые фильмы
        manager.addNewFilm(four);
        manager.addNewFilm(one);
        manager.addNewFilm(seven);
        manager.addNewFilm(two);
        manager.addNewFilm(three);
        manager.addNewFilm(eight);
        manager.addNewFilm(nine);
        manager.addNewFilm(ten);
        manager.addNewFilm(eleven);
        manager.addNewFilm(twelve);
        manager.addNewFilm(six);
        manager.addNewFilm(five);
        //выводим ожидаемое количество фильмов в массиве и фактическое
        //1ое: тип-массив фильмов, переменная-фактический рез-т= ссылаемся
        // на объект (коробку менеджера, которую мы создали в 27 строке) .
        //и ссылка на метод
        Film[] actual = manager.getLastFilm();
        //2ое: ожид рез-т = чтобы инициализировать массив, мы его как бы "создаем"
        //через нью и в фигурных скобках пишем его "ожидаемое" содержимое которое наоборот
        Film[] expected = new Film[]{five, six, twelve, eleven, ten, nine, eight, three, two, seven};
        //сравниваем два массива через ассертАррауИклс
        assertArrayEquals(expected, actual);
    }

    // тестируем когда фильмов менее чем 10, лента по умолчанию уменьшается до количества фильмов
    @Test
    void shoudPresentLentaWithFilmDownStandart() {
        //создаем новый экземпляр афиши-менеджера
        AfishaManager manager = new AfishaManager();
        //добавляем в него новые фильмы
        manager.addNewFilm(nine);
        manager.addNewFilm(ten);
        manager.addNewFilm(eleven);
        manager.addNewFilm(twelve);

        //выводим ожидаемое количество фильмов в массиве и фактическое
        //1ое: тип-массив фильмов, переменная-фактический рез-т= ссылаемся
        // на объект (коробку менеджера, которую мы создали в 27 строке) .
        //и ссылка на метод
        Film[] actual = manager.getLastFilm();
        //2ое: ожид рез-т = чтобы инициализировать массив, мы его как бы "создаем"
        //через нью и в фигурных скобках пишем его "ожидаемое" содержимое которое наоборот
        Film[] expected = new Film[]{twelve, eleven, ten, nine};
        //сравниваем два массива через ассертАррауИклс
        assertArrayEquals(expected, actual);
    }

    //тестируем метод возврата фильмов, меньшего чем по умолчанию, заданного вручную
    @Test
    void shoudPresentLentaWithFilmNoStandart() {
        //создаем новый экземпляр афиши-менеджера
        AfishaManager manager = new AfishaManager(5);
        //добавляем в него новые фильмы
        manager.addNewFilm(one);
        manager.addNewFilm(two);
        manager.addNewFilm(three);
        manager.addNewFilm(four);
        manager.addNewFilm(five);
        manager.addNewFilm(six);
        manager.addNewFilm(seven);
        manager.addNewFilm(eight);
        manager.addNewFilm(nine);
        manager.addNewFilm(ten);
        manager.addNewFilm(eleven);
        manager.addNewFilm(twelve);
        //выводим ожидаемое количество фильмов в массиве и фактическое
        //1ое: тип-массив фильмов, переменная-фактический рез-т= ссылаемся
        // на объект (коробку менеджера, которую мы создали в 27 строке) .
        //и ссылка на метод
        Film[] actual = manager.getLastFilm();
        //2ое: ожид рез-т = чтобы инициализировать массив, мы его как бы "создаем"
        //через нью и в фигурных скобках пишем его "ожидаемое" содержимое которое наоборот
        Film[] expected = new Film[]{twelve, eleven, ten, nine, eight};
        //сравниваем два массива через ассертАррауИклс
        assertArrayEquals(expected, actual);
    }
}


