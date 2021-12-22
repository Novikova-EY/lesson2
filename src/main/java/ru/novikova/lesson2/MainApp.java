package ru.novikova.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.novikova.lesson2.product.ProductRepository;

import java.util.Map;
import java.util.Scanner;

@Configuration
@ComponentScan("ru.novikova.lesson2")
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);

        System.out.println("Список всех товаров:");
        System.out.println(productRepository.findAll().toString());
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Действия с корзиной: 2 - добавить товар, 1 - удалить товар, 0 - выйти");
            int choiceAction = scanner.nextInt();
            if (choiceAction == 0) {
                break;
            } else if (choiceAction == 1) {
                deleteFromCart(cart);
            } else if (choiceAction == 2) {
                addToCart(cart);
            }

            System.out.println("Корзина:");
            for (Map.Entry cart1 : cart.findAll().entrySet()) {
                System.out.println(cart1);
            }

            context.close();
        } while (true);
    }

    private static void addToCart(Cart cart) {
        System.out.println("Для добавления товара в корзину введите его id и количество");
        Scanner scannerInput = new Scanner(System.in);
        String input = scannerInput.nextLine();
        String[] inputArray = input.trim().split(" ");
        if (inputArray.length > 2) {
            System.out.println("Введите корректные данные");
        } else {
            long id = Long.parseLong(inputArray[0]);
            int count = Integer.parseInt(inputArray[1]);
            cart.addToCart(id, count);
        }
    }

    private static void deleteFromCart(Cart cart) {
        System.out.println("Для удаления товара из корзины введите его id и количество");
        Scanner scannerInput = new Scanner(System.in);
        String input = scannerInput.nextLine();
        String[] inputArray = input.trim().split(" ");
        if (inputArray.length > 2) {
            System.out.println("Введите корректные данные");
        } else {
            long id = Long.parseLong(inputArray[0]);
            int count = Integer.parseInt(inputArray[1]);
            cart.deleteFromCart(id, count);
        }
    }
}
