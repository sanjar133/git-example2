import controller.dto.CategoryCreateRequest;
import controller.dto.ProductCreateRequest;
import model.Category;
import model.User;
import service.CategoryService;
import service.UserService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        int stepCode = 10;
        CategoryService categoryService = new CategoryService();
        UserService userService = new UserService();
        User currentUser = new User();
        boolean loginAdd = false;
        while (stepCode != 0) {
            System.out.println("1. Register user 2. Login user 0. Exit");
            stepCode = scannerInt.nextInt();
            switch (stepCode) {
                case 1 -> {
                    System.out.println("Enter username: ");
                    String username = scannerStr.nextLine();
                    System.out.println("Enter password: ");
                    String password = scannerStr.nextLine();
                    String result = userService.register(username, password);
                    System.out.println(result);
                }
                case 2 -> {
                    System.out.println("Enter username: ");
                    String username = scannerStr.nextLine();
                    System.out.println("Enter password: ");
                    String password = scannerStr.nextLine();
                    String login = userService.login(username, password);
                    System.out.println(login);
                    if (login.equals("successfully")) {
                        currentUser.setUsername(username);
                        currentUser.setPassword(password);
                        loginAdd = true;
                    }
                }
            }
            if (loginAdd) {
                while (stepCode != 0) {
                    System.out.println("1. Add Category 2. List Category 3. Delete Category 4. Add Product");
                    stepCode = scannerInt.nextInt();

                    switch (stepCode) {
                        case 1 -> {
                            CategoryCreateRequest categoryCreateRequest = new CategoryCreateRequest();
                            System.out.println("enter name: ");
                            categoryCreateRequest.setName(scannerStr.nextLine());
                            System.out.println("is this category associate to parent ?");

                            Map<Integer, UUID> categoryMap = new HashMap<>();
                            if (scannerStr.nextLine().equalsIgnoreCase("yes")) {
                                int key = 1;
                                for (Category category : categoryService.getList()) {
                                    System.out.println(key + "." + category.getName());
                                    categoryMap.put(key++, category.getId());
                                }

                                System.out.println(" please enter just number of categoryId");
                                UUID parentId = categoryMap.get(scannerInt.nextInt());
                                categoryCreateRequest.setParentId(parentId);
                            }
                            categoryService.add(currentUser.getUsername(), categoryCreateRequest);
                        }

                        case 2 -> {
                            for (Category category : categoryService.getList()) {
                                System.out.println(category.getName());
                            }
                        }

                        case 3 -> {
                            Map<Integer, UUID> categoryMap = new HashMap<>();
                            int key = 1;
                            for (Category category : categoryService.getList()) {
                                System.out.println(key + "." + category.getName());
                                categoryMap.put(key++, category.getId());
                            }

                            categoryService.deleteById(currentUser.getUsername(), categoryMap.get(scannerInt.nextInt()));
                        }
                        case 4 -> {
                            ProductCreateRequest productCreateRequest = new ProductCreateRequest();
                            System.out.println("Enter name: ");
                            productCreateRequest.setName(scannerStr.nextLine());

                            System.out.println("choose category");
                            List<Category> parentCategories = categoryService.getParentCategories();
                        }
                    }
                }
            }
        }
    }
}