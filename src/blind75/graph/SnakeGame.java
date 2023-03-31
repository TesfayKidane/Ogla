package blind75.graph;

import java.util.LinkedHashSet;
import java.util.Objects;

public class SnakeGame {

    class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    int width;
    int height;
    int r;
    int c;
    LinkedHashSet<Pair> snakeSet;
    LinkedHashSet<Pair> foodSet;
    public SnakeGame (int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        snakeSet = new LinkedHashSet<>();
        foodSet = new LinkedHashSet<>();

        for(int r = 0; r < food.length; r++) {
            foodSet.add(new Pair(food[r][0], food[r][1]));
        }

        snakeSet.add(new Pair(0, 0));
        this.r = 0;
        this.c = 0;
    }

    public int move(String direction) {
        if(direction.length() != 1) return -1;

        if("U".equals(direction)) {
            // check if snake is not bitting itself.
            if(!moveIsValid(r - 1, c)) {
                return -1;
            }
            r--;
            changeSnakeSize(r, c);
        } else if ("D".equals(direction)) {
            if(!moveIsValid(r + 1, c)) {
                return -1;
            }
            r++;
            changeSnakeSize(r, c);
        } else if("L".equals(direction)) {
            if(moveIsValid(r, c - 1)) {
                return -1;
            }
            c--;
            changeSnakeSize(r, c);
        } else if("R".equals(direction)) {
            if(moveIsValid(r, c + 1)) {
                return -1;
            }
            c++;
            changeSnakeSize(r, c);
        } else {
            return -1;
        }

        return snakeSet.size() - 1;
    }

    private void changeSnakeSize(int r, int c) {
        Pair food = foodSet.stream().findFirst().get();
        if(food.equals(new Pair(r, c))) {
            snakeSet.add(new Pair(r, c));
            foodSet.remove(food);
        } else {
            // add new pair (cell / position) to head of the snake
            snakeSet.add(new Pair(r, c));
            // remove one pair from the tail of the snake to simulate movement.
            Pair snakeTail = snakeSet.stream().findFirst().get();
            snakeSet.remove(snakeTail);
        }
    }

    private boolean moveIsValid(int r, int c) {
        if(snakeSet.contains(new Pair(r, c)) || r < 0 || r >= width || c < 0 || c >= height)
            return false;
        return true;
    }

}
