package online.pengpeng.game.eliminate.model;

import online.pengpeng.game.eliminate.view.Brand;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * EliminationBox<br>
 * @author PPDebug
 */
public class SelectedBrands {
    private List<Brand> brands;
    public static final int MAX_SIZE = 8;

    private static final SelectedBrands SINGLETON= new SelectedBrands();

    private SelectedBrands() {
        this.brands = new ArrayList<>();
    }

    public static SelectedBrands getInstance() {
        return SINGLETON;
    }

    public void add(Brand brand) {
        brands.add(brand);
        if (brands.stream().filter(b -> brand.getName().equals(b.getName())).count() == 3) {
            clear(brand.getName());
            System.out.println("success, you eliminate a triple!");
        }
        sort();
    }

    private void sort() {
        brands.sort(Comparator.comparing(Component::getName));
        changePosition();
    }

    public int size() {
        return brands.size();
    }

    private void clear(String brandName) {
        brands.stream()
                .filter( b -> b.getName().equals(brandName))
                .forEach(b -> b.getParent().remove(b));
        brands = brands.stream().filter( b -> !b.getName().equals(brandName)).collect(Collectors.toList());
    }

    private void clear() {
        brands.clear();
    }

    private void changePosition() {
        for (int i=0; i<brands.size(); i++) {
            Brand brand = brands.get(i);
            brand.setBounds(15 +  Brand.BRAND_WIDTH * i, 650 + 30, Brand.BRAND_WIDTH, Brand.BRAND_HEIGHT);
        }
    }
}
