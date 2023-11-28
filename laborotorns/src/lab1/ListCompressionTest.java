package lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListCompressionTest {
    private static final List<String> ORIGINAL_LIST = List.of("Michael",
            "Sarah", "Joshua", "Narine", "David", "Sajid", "Melanie", "Daniel",
            "Wei", "Dean", "Brian", "Murat", "Lisa");
    public void sortArrayList(List<String> array){
        Collections.sort(array);
        System.out.println(array);
    }

    @Test
    void main() {
        ListCompression originalOrder = new ListCompression(ORIGINAL_LIST);
        sortArrayList(originalOrder.getMyList());
        ArrayList<ListCompression> initialPopulation = new ArrayList<>();
        final int POPULATION_SIZE = 5;
        final int GENERATIONS = 5;
        final double THRESHOLD = 2.0;
        for (int i = 0; i < POPULATION_SIZE; i++) {
            initialPopulation.add(ListCompression.randomInstance());
        }
        GeneticAlgorithm<ListCompression> ga = new GeneticAlgorithm<>(
                initialPopulation,
                0.2, 0.7, GeneticAlgorithm.SelectionType.TOURNAMENT);
        ListCompression result = ga.run(GENERATIONS, THRESHOLD);

        sortArrayList(result.getMyList()); // сортировка выходных данных

        Assertions.assertEquals(originalOrder.getMyList(),result.getMyList());
        System.out.println(result);
    }

    @Test
    public void testBytesCompressed() {
        // Создаем список
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Hello");
        myList.add("World");

        // Создаем экземпляр класса
        ListCompression listCompression = new ListCompression(myList);

        // Вызываем метод bytesCompressed()
        int compressedBytes = listCompression.bytesCompressed();

        // Проверяем, что количество сжатых байт не равно 0
        Assertions.assertNotEquals(0, compressedBytes, "Количество сжатых байт должно быть больше нуля");

        // Проверяем, что количество сжатых байт больше 0
        Assertions.assertTrue(compressedBytes > 0, "Количество сжатых байт должно быть больше нуля");

        // проверка на правильность конвертаций
        Assertions.assertEquals(91,compressedBytes,"неверное количество бaйтов в выходных данных");
    }
}