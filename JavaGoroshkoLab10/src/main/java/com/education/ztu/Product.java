package com.education.ztu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * Клас, що представляє продукт і реалізує інтерфейс Serializable для
 * серіалізації.
 */
@XmlRootElement
public class Product implements Serializable {
    private static final long serialVersionUID = -5691506514689799346L;
    private static final Logger logger = LoggerFactory.getLogger(Product.class);

    private String name;
    private String brand;
    private double price;
    private transient int count;

    /**
     * Конструктор класу Product.
     *
     * @param name  Назва продукту.
     * @param brand Бренд продукту.
     * @param price Ціна продукту.
     * @param count Кількість продукту.
     */
    public Product(String name, String brand, double price, int count) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.count = count;
    }

    public Product() { }

    /**
     * Метод для серіалізації об'єкта в файл.
     *
     * @param fileName Ім'я файлу для збереження серіалізованого об'єкта.
     */
    public void serialize(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            logger.info("Serialization completed. Object saved to {}", fileName);
        } catch (Exception e) {
            logger.error("Serialization failed.", e);
        }
    }

    /**
     * Метод для десеріалізації об'єкта з файлу.
     *
     * @param fileName Ім'я файлу, з якого виконується десеріалізація об'єкта.
     * @return Десеріалізований об'єкт типу Product.
     */
    public static Product deserialize(String fileName) {
        Product product = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            product = (Product) ois.readObject();
            logger.info("Deserialization completed. Object loaded from {}", fileName);
        } catch (Exception e) {
            logger.error("Deserialization failed.", e);
        }
        return product;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Product fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Product.class);
    }

    /**
     * Метод для отримання назви продукту.
     *
     * @return Назва продукту.
     */
    @XmlElement
    public String getName() {
        return name;
    }

    /**
     * Метод для встановлення назви продукту.
     *
     * @param name Нова назва продукту.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод для отримання бренду продукту.
     *
     * @return Бренд продукту.
     */
    @XmlElement
    public String getBrand() {
        return brand;
    }

    /**
     * Метод для встановлення бренду продукту.
     *
     * @param brand Новий бренд продукту.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Метод для отримання ціни продукту.
     *
     * @return Ціна продукту.
     */
    @XmlElement
    public double getPrice() {
        return price;
    }

    /**
     * Метод для встановлення ціни продукту.
     *
     * @param price Нова ціна продукту.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Метод для отримання кількості продукту.
     *
     * @return Кількість продукту.
     */
    @XmlElement
    public int getCount() {
        return count;
    }

    /**
     * Метод для встановлення кількості продукту.
     *
     * @param count Нова кількість продукту.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Перевизначений метод для отримання рядкового представлення об'єкту.
     *
     * @return Рядкове представлення об'єкту.
     */
    @Override
    public String toString() {
        return "Product [name=" + name + ", brand=" + brand + ", price=" + price + ", count=" + count + "]";
    }
}