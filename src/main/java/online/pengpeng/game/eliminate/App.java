package online.pengpeng.game.eliminate;

import online.pengpeng.game.eliminate.config.BrandsList;
import online.pengpeng.game.eliminate.view.Background;
import online.pengpeng.game.eliminate.view.Brand;
import online.pengpeng.game.eliminate.view.EliminationBox;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 消消乐游戏
 * @author PPDebug
 */
public class App extends JFrame {
    private final int WIDTH = 450;
    private final int HEIGHT = 800;

    private void init() {
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("羊了个羊");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(0, 0, WIDTH, HEIGHT);
    }

    private void setBackground() {
        EliminationBox eliminationBox = EliminationBox.getInstance();
        eliminationBox.setBounds(-1, 650, 450, 150);
        this.getContentPane().add(eliminationBox);

        Background bg = Background.getInstance();
        bg.setBounds(0, 0, WIDTH, HEIGHT);
        this.getContentPane().add(bg);
    }

    private void setCard() {
        int column = 8;
        int row = 9;
        ArrayList<Brand> brands = new ArrayList<>();
        Random random = new Random();
        String[] brandNames = BrandsList.brands;
        for (int i=0; i < column * row / 3; i++) {
            String name = brandNames[random.nextInt(brandNames.length)];
            brands.add(new Brand(name));
            brands.add(new Brand(name));
            brands.add(new Brand(name));
        }
        Collections.shuffle(brands);
        for (int c = 0; c < column; c++) {
            int x = c * Brand.BRAND_WIDTH;
            for (int r = 0; r < row; r++) {
                int y = r * Brand.BRAND_HEIGHT;
                int index = c * row + r;
                Brand brand = brands.get(index);
                brand.setBounds(10 + x, 10 + y, Brand.BRAND_WIDTH, Brand.BRAND_HEIGHT);
                this.getContentPane().add(brand);
            }
        }
    }

    private void animate() {
        new Thread( () -> {
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
            }
        }).start();
    }
    public App() {

        init();

        setCard();

        setBackground();

        animate();
    }

    public static void main(String[] args) {
        new App();
    }
}
