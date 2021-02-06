package com.example.clockify;

import com.example.clockify.Entities.nameOfProducts;
import com.example.clockify.Entities.typeOfProducts;
import com.example.clockify.repsitories.typeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClockifyApplication implements CommandLineRunner {

    @Autowired
    typeProduct typeProduct;

    public static void main(String[] args) {
        SpringApplication.run(ClockifyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //set type of product to their names
        //mergetypesWithNames();

    }

    private void mergetypesWithNames() {

        typeOfProducts electronics=new typeOfProducts("لوازم الکترونیکی");
        typeOfProducts homeMade=new typeOfProducts("لوازم خانگی");
        typeOfProducts car=new typeOfProducts("خودرو");
        typeOfProducts personality=new typeOfProducts("وسایل شخصی");

        //electronicies
        nameOfProducts seshvar=new nameOfProducts(10,12000000,"سشوار");
        nameOfProducts jaroo=new nameOfProducts(5,23500000,"جاروبرقی");
        nameOfProducts yakhjal=new nameOfProducts(3,50000000,"یخچال");
        nameOfProducts utoo=new nameOfProducts(10,27000000,"اتو");

        //home features:
        nameOfProducts heater=new nameOfProducts(2,30000000,"بخاری");
        nameOfProducts table=new nameOfProducts(20,17000000,"میزغذاخوری");
        nameOfProducts copet=new nameOfProducts(1,123000000,"فرش");
        nameOfProducts door=new nameOfProducts(4,215000000,"درب آلومینیومی");
        //lavazem shakhsi
        nameOfProducts holeh=new nameOfProducts(100,200000,"حوله");
        nameOfProducts saboon=new nameOfProducts(40,70000,"صابون");
        nameOfProducts dastmal=new nameOfProducts(40,156000,"دستمال کاغذی");
        nameOfProducts atr=new nameOfProducts(12,850000,"عطر");
        //cars:
        nameOfProducts pride=new nameOfProducts(10000,970000000,"پراید");
        nameOfProducts tiba=new nameOfProducts(5000,310000000,"تیبا");
        nameOfProducts samand=new nameOfProducts(1,270000000,"سمند");
        nameOfProducts peykan=new nameOfProducts(100,500000000,"پیکان");

        electronics.getNameOfProductsList().add(seshvar);
        electronics.getNameOfProductsList().add(jaroo);
        electronics.getNameOfProductsList().add(yakhjal);
        electronics.getNameOfProductsList().add(utoo);

        homeMade.getNameOfProductsList().add(heater);
        homeMade.getNameOfProductsList().add(table);
        homeMade.getNameOfProductsList().add(copet);
        homeMade.getNameOfProductsList().add(door);

        car.getNameOfProductsList().add(pride);
        car.getNameOfProductsList().add(samand);
        car.getNameOfProductsList().add(tiba);
        car.getNameOfProductsList().add(peykan);

        personality.getNameOfProductsList().add(holeh);
        personality.getNameOfProductsList().add(saboon);
        personality.getNameOfProductsList().add(dastmal);
        personality.getNameOfProductsList().add(atr);

        typeProduct.save(electronics);
        typeProduct.save(car);
        typeProduct.save(personality);
        typeProduct.save(homeMade);
    }
}
