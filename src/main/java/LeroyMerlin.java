public class LeroyMerlin {
//    указывайте пожалуйста emailIndex на 1 больше при каждом запуске
    public static String emailIndex = "72";

    public static void main(String[] args) throws InterruptedException {
        Registration.main(args);
//        ChangePersonalData.main(args);

        System.out.println();

        if (Registration.testCaseRegistrationSuccess & ChangePersonalData.testCaseChangeDataSuccess){
            System.out.println("Тест-сет выполнен успешно");
        } else {
            System.out.println("Тест-сет провален");
        }
    }
}
