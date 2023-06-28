import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "хлеб", 20);
        Product product2 = new Product(11, "молоко", 50);
        Product product3 = new Product(12, "сыр", 100);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(11);
        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveNoProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "хлеб", 20);
        Product product2 = new Product(11, "молоко", 50);
        Product product3 = new Product(12, "сыр", 100);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(123);
        });

    }

}
