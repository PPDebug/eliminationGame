package online.pengpeng.game.eliminate.controller;

import online.pengpeng.game.eliminate.view.Brand;
import online.pengpeng.game.eliminate.model.SelectedBrands;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * BrandClickHandler
 * @author PPDebug
 */
public class BrandClickHandler extends MouseAdapter {

    private final SelectedBrands selectedBrands = SelectedBrands.getInstance();

    private static final BrandClickHandler SINGLETON = new BrandClickHandler();

    private BrandClickHandler() {
    }

    public static BrandClickHandler getInstance() {
        return SINGLETON;
    }

    public void mouseClicked(MouseEvent e) {
        Brand brand = (Brand) e.getSource();
        if (brand.isCovered()) {
            System.out.println("This brand is covered, please remove it's front brand first!");
            return;
        }
        if (selectedBrands.size() == SelectedBrands.MAX_SIZE) {
            System.err.println("The Box is full");
            return;
        }
        selectedBrands.add(brand);
        brand.removeMouseListener();
        System.out.println(brand.getName() + " has been clicked!");
    }
}


